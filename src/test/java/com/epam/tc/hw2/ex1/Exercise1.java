package com.epam.tc.hw2.ex1;

import static com.epam.tc.hw2.TestDataExpected.SIDEBAR_EXPECTED;
import static com.epam.tc.hw2.TestDataExpected.TEXTS_EXPECTED;

import com.epam.tc.hw2.HW2BaseTest;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1 extends HW2BaseTest {



    @Test
    public void exercise1Test() {

        //        2. Assert Browser title

        softAssert.assertEquals(webDriver.getTitle(), "Home Page");

        //        4. Assert Username is logged in

        webElement = webDriver.findElement(By.cssSelector("#user-name"));
        softAssert.assertEquals(webElement.getText(), "ROMAN IOVLEV");

        //        5. Assert that there are 4 items on the header section are displayed, and they have proper texts

        webElement = webDriver.findElement(By.linkText("Home"));
        softAssert.assertEquals(webElement.getText(), "Home");

        webElement = webDriver.findElement(By.linkText("Contact form"));
        softAssert.assertEquals(webElement.getText(), "Contact form");

        webElement = webDriver.findElement(
            By.xpath("//body[@wfd-invisible='true']/descendant::a[@class='dropdown-toggle']")
        );
        softAssert.assertEquals(webElement.getText(), "SERVICE");

        webElement = webDriver.findElement(By.linkText("Metals & Colors"));
        softAssert.assertEquals(webElement.getText(), "Metals & Colors");


        //        6. Assert that there are 4 images on the Index Page, and they are displayed

        List<WebElement> mainPageIcons = webDriver.findElements(By.className("benefit-icon"));

        for (int i = 0; i < 4; i++) {
            softAssert.assertTrue(mainPageIcons.get(i).isDisplayed());
        }


        //        7. Assert that there are 4 texts on the Index Page under icons, and they have proper text

        List<WebElement> mainPageTexts = webDriver.findElements(By.className("benefit-txt"));
        for (WebElement text : mainPageTexts) {
            softAssert.assertTrue(text.isDisplayed());
        }

        softAssert.assertEquals(mainPageTexts
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList()), TEXTS_EXPECTED
        );


        //        8. Assert that there is the iframe with “Frame Button” exist

        WebElement frame = webDriver.findElement(By.id("frame"));
        softAssert.assertTrue(frame.isDisplayed());


        //       9. Switch to the iframe and check that there is “Frame Button” in the iframe

        webDriver.switchTo().frame(frame);
        WebElement frameButton = webDriver.findElement(By.id("frame-button"));
        softAssert.assertTrue(frameButton.isEnabled());


        //        10. Switch to original window back

        webDriver.switchTo().parentFrame();


        //        11. Assert that there are 5 items in the Left Section are displayed, and they have proper texts

        List<WebElement> sideBar = webDriver.findElements(By.cssSelector("#mCSB_1_container > ul > li"));

        for (WebElement button : sideBar) {
            softAssert.assertTrue(button.isDisplayed());
        }

        softAssert.assertEquals(sideBar
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList()), SIDEBAR_EXPECTED
        );

        softAssert.assertAll();

    }

}
