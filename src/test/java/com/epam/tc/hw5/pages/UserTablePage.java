package com.epam.tc.hw5.pages;

import com.epam.tc.hw3.components.HeaderMenu;
import com.epam.tc.hw3.pages.LogInPage;
import org.openqa.selenium.WebDriver;

public class UserTablePage extends HeaderMenu {

    protected LogInPage logInPage;
    protected WebDriver webDriver;
    protected HeaderMenu headerMenu;

    public UserTablePage(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
        this.logInPage = new LogInPage(driver);
        this.headerMenu = new HeaderMenu(driver);
    }







}
