package com.dewmobile.zc.excelsql;

import com.dewmobile.zc.excelsql.service.ExcelReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ExcelsqlApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ExcelsqlApplication.class, args);
        ExcelReader reader = context.getBean(ExcelReader.class);
        reader.readToDb(args[0]);
    }

}
