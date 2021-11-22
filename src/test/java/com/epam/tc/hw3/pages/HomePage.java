package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.components.HeaderMenu;
import com.epam.tc.hw3.components.LeftSideMenu;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HeaderMenu {
    WebDriver webDriver;
    HeaderMenu headerMenu;
    LeftSideMenu leftSideMenu;

    @FindBy(className = "benefit-icon")
    private List<WebElement> mainPageIcons;
    @FindBy(className = "benefit-txt")
    private List<WebElement> mainPageTexts;
    @FindBy(id = "frame")
    private WebElement frame;
    @FindBy(id = "frame-button")
    private WebElement frameButton;


    public HomePage(WebDriver driver) {
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

    public List<WebElement> imagesIsDisplayedList() {
        return mainPageIcons;
    }

    public List<WebElement> mainPageTextsList() {
        return mainPageTexts;
    }

    public WebElement getFrame() {
        return frame;
    }

    public void switchToFrame() {
        webDriver.switchTo().frame(frame);
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public void switchBack() {
        webDriver.switchTo().parentFrame();
    }

    public List<WebElement> getLeftSideSideMenuList() {
        return leftSideMenu.getSideBar();
    }



}
