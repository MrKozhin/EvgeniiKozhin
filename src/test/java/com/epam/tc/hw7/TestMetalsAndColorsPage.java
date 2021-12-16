package com.epam.tc.hw7;

import static com.epam.tc.hw7.composite.pages.JdiMetalsAndColorsPage.metalsAndColorsForm;
import static com.epam.tc.hw7.entities.User.ROMAN;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.entities.MetalsAndColorsDataEntity;
import com.epam.tc.hw7.entities.User;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestMetalsAndColorsPage {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        PageFactory.initSite(JdiSite.class);
    }

    @BeforeClass
    public void beforeClass() {
        JdiSite.open();
        JdiSite.homePage.login(ROMAN);
        String userName = JdiSite.homePage.getUsername();
        Assert.assertEquals(userName, ROMAN.getLoggedInUsername());
    }

    @Test(dataProviderClass = MetalsAndColorsDataProvider.class, dataProvider = "JSON Data Provider")
    public void testMetalsAndColors(MetalsAndColorsDataEntity metalsAndColorsDataEntity) {
        JdiSite.homePage.openMetalsAndColorsPage();
        metalsAndColorsForm.submit(metalsAndColorsDataEntity);


    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
