package com.dewmobile.zc.excelsql.common.sql;

import sun.misc.MessageUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SQL操作类
 * @author zc
 */
public class SqlOperator {

    public static class Create implements SqlFactory {
        private static final String DEFAULT_NULL = "DEFAULT NULL";
        private static final String NOT_NULL = "NOT NULL";

        public static String createTable(String tableName, List<String> fields) {
            // TODO 区分是否覆盖原有的表
            String dropSql = String.format(Create.DROP, tableName);
            String createSql = String.format(Create.SQL, tableName, createSql(fields));
            return dropSql + ";" + createSql;
        }

        private static String createSql(List<String> fields) {
            StringBuffer sb = new StringBuffer();
            fields.forEach(field -> sb.append(String.format(Create.VARCHAR, field, 200, DEFAULT_NULL)).append(","));
            String str = sb.toString();
            return str.substring(0, str.lastIndexOf(","));
        }
    }

    public static class Insert implements SqlFactory {
        private static final String DEFAULT_NULL = "DEFAULT NULL";
        private static final String NOT_NULL = "NOT NULL";

        public static String insertSql(String tableName, List<String> fields,  List<List<String>> dataCache) {
            String fieldSql = String.join(",", fields);

            StringBuilder dataLines = new StringBuilder();
            for (List<String> datas : dataCache) {
                dataLines.append(" (");
//                dataLines.append(String.join("','", data));
                for (String data : datas) {
                    if (data == null) {
                        dataLines.append(data).append(",");
                    } else {
                        dataLines.append("'").append(data).append("'").append(",");
                    }
                }
                dataLines.deleteCharAt(dataLines.lastIndexOf(","));
                dataLines.append("),");
            }
            String dataSql = dataLines.toString();
            dataSql = dataSql.substring(0, dataSql.lastIndexOf(","));

            return String.format(Insert.SQL, tableName, fieldSql, dataSql);
        }
    }
}
