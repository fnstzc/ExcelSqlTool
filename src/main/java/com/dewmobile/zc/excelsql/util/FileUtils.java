package com.dewmobile.zc.excelsql.util;

import org.springframework.util.StringUtils;

import java.io.File;
import java.util.Optional;

/**
 * 文件操作类
 * @author zc
 */
public class FileUtils {

    public static Optional<String> getFileName(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            return Optional.empty();
        } else {
            File file = new File(filePath);
            return Optional.of(file.getName());
        }
    }

    public static void main(String[] args) {
        System.out.println(getFileName("/Users/zc/Documents/city.xlsx"));
    }
}
