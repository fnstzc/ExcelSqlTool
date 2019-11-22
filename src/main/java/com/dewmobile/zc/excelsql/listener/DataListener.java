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
    private Map<Integer, String> headMap = new LinkedHashMap<>();
    private ExcelDao excelDao;

    public DataListener(String excelName, ExcelDao excelDao) {
        this.excelName = excelName;
        this.excelDao = excelDao;
    }

    @Override
    public void invoke(Map<Integer, String> dataMap, AnalysisContext analysisContext) {

    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        this.headMap = headMap;
        List<String> fields = (List<String>) headMap.values();
        if (CollectionUtils.isEmpty(fields)) {
            log.error("haven't read excel head");
        } else {
            excelDao.createTable(excelName, fields);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println(analysisContext);
    }
}
