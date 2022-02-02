package com.epam.tc.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.composite.pages.JdiHomePage;
import com.epam.tc.hw7.composite.pages.JdiMetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {
    @Url("/index.html")
    public static JdiHomePage homePage;
    @Url("/metals-colors.html")
    public static JdiMetalsAndColorsPage metalsAndColorsPage;



    public static void open() {
        homePage.open();
    }
}
