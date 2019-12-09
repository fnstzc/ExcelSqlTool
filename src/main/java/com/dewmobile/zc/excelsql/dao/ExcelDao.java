package com.dewmobile.zc.excelsql.dao;

import com.dewmobile.zc.excelsql.common.sql.SqlOperator;
import com.dewmobile.zc.excelsql.mapper.ExcelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import java.util.List;

@Slf4j
@Repository
public class ExcelDao {

    private final ExcelMapper excelMapper;

    public ExcelDao(ExcelMapper excelMapper) {
        this.excelMapper = excelMapper;
    }

    public void createTable(String tableName, List<String> fields) {
        String sql = SqlOperator.Create.createTable(tableName, fields);
        excelMapper.createTable(sql);
    }

    public void insertData(String tableName, List<String> fields, List<List<String>> dataCollection) {
        String sql = SqlOperator.Insert.insertSql(tableName, fields, dataCollection);
        int completeCount = excelMapper.insertData(sql);
        log.info("success insert data count: [{}]", completeCount);
    }

}
