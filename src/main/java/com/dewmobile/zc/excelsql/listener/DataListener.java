package com.dewmobile.zc.excelsql.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.dewmobile.zc.excelsql.dao.ExcelDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Slf4j
public class DataListener extends AnalysisEventListener<Map<Integer, String>> {

    private final String excelName;
    private List<String> fields;
    private static final int CACHE_SIZE = 500;
    private static List<List<String>> dataCache = new ArrayList<>(CACHE_SIZE);

    private ExcelDao excelDao;

    public DataListener(String excelName, ExcelDao excelDao) {
        this.excelName = excelName;
        this.excelDao = excelDao;
    }

    @Override
    public void invoke(Map<Integer, String> dataMap, AnalysisContext analysisContext) {
        dataCache.add(new ArrayList<>(dataMap.values()));
        if (dataCache.size() >= CACHE_SIZE) {
            doInsert();
        }
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        List<String> fields = new ArrayList<>(headMap.values());
        if (CollectionUtils.isEmpty(fields)) {
            log.error("haven't read excel head");
        } else {
            this.fields = fields;
            excelDao.createTable(excelName, fields);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        doInsert();
        log.debug("resolve over");
    }

    private void doInsert() {
        excelDao.insertData(excelName, fields, dataCache);
        clearCache();
    }

    private void clearCache() {
        dataCache.clear();
    }
}
