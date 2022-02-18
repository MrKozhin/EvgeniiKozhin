package com.epam.tc.hw9.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApiProperties extends Properties {

    protected static ApiProperties apiProperties;

    public static ApiProperties getInstance() {
        if (apiProperties == null) {
            apiProperties = new ApiProperties();
            try {
                apiProperties.load(new FileInputStream("src/test/resources/test.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return apiProperties;
    }
}
