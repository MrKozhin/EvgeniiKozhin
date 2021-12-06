package com.epam.tc.hw6.service;

import java.util.Locale;
import java.util.Objects;
import org.openqa.selenium.WebDriver;

public final class WebDriverProvider {
    private static WebDriver webDriver;

    private WebDriverProvider() {
    }

    public static WebDriver getWebDriver() {
        if (Objects.isNull(webDriver)) {
            String launchType = System.setProperty("launch.type", "local");
            String browserName = System.setProperty("browser.name", "chrome");
            webDriver = WebDriverFactory.createWebDriver(launchType,
                Browser.valueOf(browserName.toUpperCase(Locale.ROOT)));
        }
        return webDriver;
    }

    public static void closeDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
