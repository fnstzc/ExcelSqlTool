package com.dewmobile.zc.excelsql.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ExcelMapper {

    @Update({"${sql}"})
    void createTable(@Param("sql") String sql);

    @Insert({"${sql}"})
    int insertData(@Param("sql") String sql);
}
