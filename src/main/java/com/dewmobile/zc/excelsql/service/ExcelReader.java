package com.dewmobile.zc.excelsql.service;

import com.alibaba.excel.EasyExcel;
import com.dewmobile.zc.excelsql.dao.ExcelDao;
import com.dewmobile.zc.excelsql.listener.DataListener;
import com.dewmobile.zc.excelsql.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Excel解析
 * @author zc
 */
@Component
@Slf4j
public class ExcelReader {

    private static final String FILE_SUFFIX_SPLIT = ".";

    @Autowired
    ExcelDao excelDao;

    public void readToDb(String filePath) {
        getTableNameFromFile(filePath).ifPresent(tableName ->
                EasyExcel.read(filePath, new DataListener(tableName, excelDao)).doReadAll());
    }

    private Optional<String> getTableNameFromFile(String filePath) {
        return FileUtils.getFileName(filePath).map(fileName -> {
            if (fileName.contains(FILE_SUFFIX_SPLIT)) {
                return fileName.substring(0, fileName.indexOf(FILE_SUFFIX_SPLIT));
            } else {
                return fileName;
            }
        });
    }
}
