package com.dewmobile.zc.excelsql.common.sql;

public interface SqlFactory {
    class Create {
        static final String INT = " `%s` INT(%s) %s";
        static final String VARCHAR = " `%s` VARCHAR(%s) %s";
        static final String SQL = "create table `%s` (`id` int unsigned PRIMARY KEY NOT NULL AUTO_INCREMENT, %s) ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }

    class Insert {
        static final String SQL = "insert into `%s` (%s) values %s";
    }
}
