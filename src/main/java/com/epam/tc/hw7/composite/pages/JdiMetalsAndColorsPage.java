package com.epam.tc.hw7.composite.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.composite.forms.MetalsAndColorsForm;


public class JdiMetalsAndColorsPage extends WebPage {
    @UI(".main-content-hg")
    public static MetalsAndColorsForm metalsAndColorsForm;

}
