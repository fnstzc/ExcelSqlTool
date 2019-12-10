package com.dewmobile.zc.excelsql;

import com.dewmobile.zc.excelsql.service.ExcelReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
@SpringBootTest
class ExcelsqlApplicationTests {

    @Autowired
    ExcelReader excelReader;

    @Test
    void contextLoads() {
        excelReader.readToDb("/Users/zc/Documents/operator.xlsx");
    }

}
