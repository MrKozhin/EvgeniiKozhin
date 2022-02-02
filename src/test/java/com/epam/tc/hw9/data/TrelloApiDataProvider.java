package com.epam.tc.hw9.data;

import org.testng.annotations.DataProvider;

public class TrelloApiDataProvider {

    @DataProvider
    public static Object[][] boardDataProvider() {
        return new Object[][] {
            {"pink"}
        };
    }

    @DataProvider
    public static Object[][] boardBackgroundColorDataProvider() {
        return new Object[][] {
            {"purple"},
            {"lime"},
            {"sky"}
        };
    }


}
