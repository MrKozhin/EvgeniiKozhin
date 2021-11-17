package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.components.HeaderMenu;
import com.epam.tc.hw3.components.LeftSideMenu;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends HeaderMenu {
    WebDriver webDriver;
    HeaderMenu headerMenu;
    LeftSideMenu leftSideMenu;

    @FindBy(className = "benefit-icon")
    private List<WebElement> mainPageIcons;


    public HomePage(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
        this.headerMenu = new HeaderMenu(driver);
        this.leftSideMenu = new LeftSideMenu();
        PageFactory.initElements(webDriver, this);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }










}
