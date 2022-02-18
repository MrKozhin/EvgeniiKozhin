package com.epam.tc.hw9.utils;

import org.apache.commons.lang.RandomStringUtils;

public class Utils {

    public static String generateRandomString() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
