package com.epam.tc.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/com/epam/tc/hw5/Exercise1.feature",
    plugin = {"pretty"}
)
public class TestRunnerEx1 extends AbstractTestNGCucumberTests {
}

