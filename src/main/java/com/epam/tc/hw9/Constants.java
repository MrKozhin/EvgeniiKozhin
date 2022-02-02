package com.epam.tc.hw9;

public class Constants {
    public static final String KEY = "key";
    public static final String TOKEN = "token";
    public static final String ROOT_PATH = ApiProperties.getInstance().getProperty("root_path");
    public static final String ENDPOINT = ApiProperties.getInstance().getProperty("endpoint");
}
