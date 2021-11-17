package com.epam.tc.hw3.ex2;

import static com.epam.tc.hw3.data.TestDataExpected.LOG_ROWS_EXPECTED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw3.pagetests.HW3BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Exercise2 extends HW3BaseTest {



    @Test
    public void exercise1Test() {

        //        2. Assert Browser title

        assertThat(webDriver.getTitle()).isEqualTo("Home Page");

        //        4. Assert User name in the left-top side of screen that user is logged in

        webElement = webDriver.findElement(By.cssSelector("#user-name"));
        assertThat(webElement.getText()).isEqualTo("ROMAN IOVLEV");
        assertThat(webElement.isDisplayed()).isTrue();

        //        5. Open through the header menu Service -> Different Elements Page

        webElement = webDriver.findElement(
            By.xpath("//body[@wfd-invisible='true']/descendant::a[@class='dropdown-toggle']")
        );
        webElement.click();
        webElement = webDriver.findElement(
            By.xpath("//a[contains(text(),'Different elements')]")
        );
        webElement.click();

        //        6. Select checkboxes Water, Wind

        webElement = webDriver.findElement(
            By.xpath("//div[@class='checkbox-row']/descendant::input[@type='checkbox'][1]")
        );
        webElement.click();

        webElement = webDriver.findElement(
            By.xpath("//div[@class='checkbox-row']/descendant::input[@type='checkbox'][3]")
        );
        webElement.click();

        //        7. Select radio Selen

        webElement = webDriver.findElement(
            By.xpath("//div[@class='checkbox-row']/descendant::input[@type='radio'][4]")
        );
        webElement.click();

        //        8. Select in dropdown Yellow

        webElement = webDriver.findElement(
            By.xpath("//div[@class='colors']/descendant::option[4]")
        );
        webElement.click();

        //        9. Assert that
        //        for each checkbox there is an individual log row and value is corresponded to the status of checkbox

        String logRowWater = webDriver.findElement(By.xpath("//li[contains(text(), 'Water')]")).getText();
        assertThat(logRowWater).contains(LOG_ROWS_EXPECTED.get(0));

        String logRowWind = webDriver.findElement(By.xpath("//li[contains(text(), 'Wind')]")).getText();
        assertThat(logRowWind).contains(LOG_ROWS_EXPECTED.get(1));

        //        for radio button there is a log row and value is corresponded to the status of radio button

        String logRowSelen = webDriver.findElement(By.xpath("//li[contains(text(), 'Selen')]")).getText();
        assertThat(logRowSelen).contains(LOG_ROWS_EXPECTED.get(2));

        //        for dropdown there is a log row and value is corresponded to the selected value.

        String logRowYellow = webDriver.findElement(By.xpath("//li[contains(text(), 'Yellow')]")).getText();
        assertThat(logRowYellow).contains(LOG_ROWS_EXPECTED.get(3));


    }

}
