package com.epam.tc.hw3.data;

import java.util.List;

public class TestDataExpected {

    public static final String PAGE_TITLE_EXPECTED = "Home Page";
    public static final String USERNAME_EXPECTED = "ROMAN IOVLEV";

    public static final List<String> HEADER_BUTTONS_EXPECTED = List.of(
        "Home",
        "Contact form",
        "SERVICE",
        "Metals & Colors"
    );

    public static final List<String> TEXTS_EXPECTED = List.of(
        "To include good practices\nand ideas from successful\nEPAM project",
        "To be flexible and\ncustomizable",
        "To be multiplatform",
        "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"
    );

    public static final List<String> SIDEBAR_EXPECTED = List.of(
        "Home",
        "Contact form",
        "Service",
        "Metals & Colors",
        "Elements packs"
    );

    public static final List<String> LOG_ROWS_EXPECTED = List.of(
        "Water: condition changed to true",
        "Wind: condition changed to true",
        "metal: value changed to Selen",
        "Colors: value changed to Yellow"
    );

}
