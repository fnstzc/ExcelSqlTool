package com.dewmobile.zc.excelsql.dao;

import com.dewmobile.zc.excelsql.common.sql.SqlOperator;
import com.dewmobile.zc.excelsql.mapper.ExcelMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

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

    public void insertData(String tableName, List) {

    }

}
