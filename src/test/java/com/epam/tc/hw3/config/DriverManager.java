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

    public WebDriver setUpDriver() {
        setUpChromeDriver();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);

        return driver;
    }


}
