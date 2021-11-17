package com.epam.tc.hw3.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {

    public static WebDriver driver;
    protected WebDriverWait webDriverWait;

    private void setUpChromeDriver() {
        WebDriverManager.chromedriver()
                        .setup();
    }

    public static WebDriver getSingletonInstance() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public WebDriver setUpDriver() {
        setUpChromeDriver();
        WebDriver webDriver = DriverManager.getSingletonInstance();
        webDriverWait = new WebDriverWait(webDriver, 10);

        return webDriver;
    }


}
