package com.epam.tc.hw3.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

    public static final String URL;
    public static final String USERNAME;
    public static final String PASSWORD;

    static  {
        Properties properties = new Properties();
        try (
            FileInputStream inputStream = new FileInputStream("src/main/resources/com/epam/tc/hw2/login.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println(e.getMessage() + "   \"Properties file not found\"");
        }

        URL = properties.getProperty("url");
        USERNAME = properties.getProperty("username");
        PASSWORD = properties.getProperty("password");

    }
}
