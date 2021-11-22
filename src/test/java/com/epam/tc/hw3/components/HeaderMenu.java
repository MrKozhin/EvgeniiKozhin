package com.epam.tc.hw3.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderMenu {
    WebDriver webDriver;

    @FindBy(css = ".profile-photo")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement nameInputField;
    @FindBy(id = "password")
    private WebElement passwordInputField;
    @FindBy(id = "login-button")
    private WebElement logInButton;
    @FindBy(css = "#user-name")
    private WebElement userLoggedInName;
    @FindBy(linkText = "Home")
    private WebElement homeButton;
    @FindBy(linkText = "Contact form")
    private WebElement contactFormButton;
    @FindBy(xpath = "//body[@wfd-invisible='true']/descendant::a[@class='dropdown-toggle']")
    private WebElement serviceButton;
    @FindBy(linkText = "Metals & Colors")
    private WebElement metalsAndColorsButton;
    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]/li")
    private List<WebElement> headerMenuElementsList;
    @FindBy(xpath = "//a[contains(text(),'Different elements')]")
    private WebElement differentElementsButton;


    public HeaderMenu(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }


    public void clickUserIcon() {
        userIcon.click();
    }

    public void nameSendKeys(String url) {
        nameInputField.sendKeys(url);
    }

    public void passwordSendKeys(String password) {
        passwordInputField.sendKeys(password);
    }

    public void clickLogInButton() {
        logInButton.click();
    }

    public WebElement getLoggedInUsername() {
        return userLoggedInName;
    }

    public WebElement getHomeButtonElement() {
        return homeButton;
    }

    public WebElement getContactFormButtonElement() {
        return contactFormButton;
    }

    public WebElement getServiceButtonElement() {
        return serviceButton;
    }

    public WebElement getMetalsAndColorsButtonElement() {
        return metalsAndColorsButton;
    }

    public HeaderMenu clickHeaderMenuItem(String headerMenuItemText) {
        for (WebElement item : headerMenuElementsList) {
            if (headerMenuItemText.equals(item.getText())) {
                item.click();
                break;
            }
        }
        return this;
    }

    public HeaderMenu clickDifferentElementsButton() {
        differentElementsButton.click();
        return this;
    }




}
