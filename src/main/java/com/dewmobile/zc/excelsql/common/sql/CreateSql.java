package com.dewmobile.zc.excelsql.common.sql;

import java.util.List;

public class CreateSql implements SqlFactory {

    private static final String DEFAULT_NULL = "DEFAULT NULL";
    private static final String NOT_NULL = "NOT NULL";

    public static String createTable(String tableName, List<String> fields) {
        return String.format(Create.SQL, tableName, createSql(fields));
    }

    private static String createSql(List<String> fields) {
        StringBuffer sb = new StringBuffer();
        fields.forEach(field -> sb.append(String.format(Create.VARCHAR, field, 200, DEFAULT_NULL)).append(","));
        String str = sb.toString();
        return str.substring(0, str.lastIndexOf(","));
    }
}
