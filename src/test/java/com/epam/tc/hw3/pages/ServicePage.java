package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.components.HeaderMenu;
import com.epam.tc.hw3.components.LeftSideMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServicePage extends HeaderMenu {
    WebDriver webDriver;
    HeaderMenu headerMenu;
    LeftSideMenu leftSideMenu;

    @FindBy(xpath = "//div[@class='checkbox-row']/descendant::input[@type='checkbox'][1]")
    private WebElement checkBoxWater;
    @FindBy(xpath = "//div[@class='checkbox-row']/descendant::input[@type='checkbox'][3]")
    private WebElement checkBoxWind;
    @FindBy(xpath = "//div[@class='checkbox-row']/descendant::input[@type='radio'][4]")
    private WebElement elementSelen;
    @FindBy(xpath = "//div[@class='colors']/descendant::option[4]")
    private WebElement dropdownYellow;
    @FindBy(xpath = "//li[contains(text(), 'Water')]")
    private WebElement logRowWater;
    @FindBy(xpath = "//li[contains(text(), 'Wind')]")
    private WebElement logRowWind;
    @FindBy(xpath = "//li[contains(text(), 'Selen')]")
    private WebElement logRowSelen;
    @FindBy(xpath = "//li[contains(text(), 'Yellow')]")
    private WebElement logRowYellow;


    public ServicePage(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
        this.headerMenu = new HeaderMenu(driver);
        this.leftSideMenu = new LeftSideMenu(driver);
    }

    public ServicePage clickWaterCheckBox() {
        checkBoxWater.click();
        return this;
    }

    public ServicePage clickWindCheckBox() {
        checkBoxWind.click();
        return this;
    }

    public ServicePage clickSelenElement() {
        elementSelen.click();
        return this;
    }

    public ServicePage clickDropdownYellow() {
        dropdownYellow.click();
        return this;
    }

    public WebElement getLogRowWater() {
        return logRowWater;
    }

    public WebElement getLogRowWind() {
        return logRowWind;
    }

    public WebElement getLogRowSelen() {
        return logRowSelen;
    }

    public WebElement getLogRowYellow() {
        return logRowYellow;
    }
}
