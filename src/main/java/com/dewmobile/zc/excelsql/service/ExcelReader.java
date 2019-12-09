package com.dewmobile.zc.excelsql.service;

import com.alibaba.excel.EasyExcel;
import com.dewmobile.zc.excelsql.dao.ExcelDao;
import com.dewmobile.zc.excelsql.listener.DataListener;
import com.dewmobile.zc.excelsql.mapper.ExcelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Semaphore;

@Component
public class ExcelReader {

    @Autowired
    ExcelDao excelDao;

    private String fileName = "/Users/zc/Documents/city.xlsx";

    public void readHeads() {
        String excelName = "city";
        EasyExcel.read(fileName, new DataListener(excelName, excelDao)).doReadAll();
    }
}
