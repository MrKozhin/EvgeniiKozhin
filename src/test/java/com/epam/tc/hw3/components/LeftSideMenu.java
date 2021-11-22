package com.epam.tc.hw3.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftSideMenu {
    WebDriver webDriver;

    @FindBy(css = "#mCSB_1_container > ul > li")
    List<WebElement> sideBar;


    public LeftSideMenu(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public List<WebElement> getSideBar() {
        return sideBar;
    }


}
