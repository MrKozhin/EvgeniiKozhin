package com.epam.tc.hw3.pages;

import static com.epam.tc.hw3.util.PropertyUtil.PASSWORD;
import static com.epam.tc.hw3.util.PropertyUtil.URL;
import static com.epam.tc.hw3.util.PropertyUtil.USERNAME;

import com.epam.tc.hw3.components.HeaderMenu;
import com.epam.tc.hw3.components.LeftSideMenu;
import org.openqa.selenium.WebDriver;

public class LogInPage extends HeaderMenu {
    WebDriver webDriver;
    HeaderMenu headerMenu;
    LeftSideMenu leftSideMenu;

    public LogInPage(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
        this.headerMenu = new HeaderMenu(driver);
        this.leftSideMenu = new LeftSideMenu(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }

    public LogInPage open() {
        webDriver.get(URL);
        return this;
    }

    public void logIn() {
        headerMenu.clickUserIcon();
        headerMenu.nameSendKeys(USERNAME);
        headerMenu.passwordSendKeys(PASSWORD);
        headerMenu.clickLogInButton();
    }


}
