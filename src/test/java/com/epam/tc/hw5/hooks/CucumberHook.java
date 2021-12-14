package com.epam.tc.hw5.hooks;

import com.epam.tc.hw3.config.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class CucumberHook {

    public static WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new DriverManager().setUpDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
