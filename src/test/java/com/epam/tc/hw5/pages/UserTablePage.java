package com.epam.tc.hw5.pages;

import com.epam.tc.hw3.components.HeaderMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends HeaderMenu {
    protected WebDriver webDriver;
    protected HeaderMenu headerMenu;

    @FindBy(css = "td select")
    private List<WebElement> dropdownsList;
    @FindBy(css = "td a")
    private List<WebElement> usernamesList;
    @FindBy(css = "td span")
    private List<WebElement> descriptionImageTextsList;
    @FindBy(css = "input[type$=box]")
    private List<WebElement> vipCheckboxesList;
    @FindBy(css = "tr td:first-child")
    private List<WebElement> tableNumbersList;
    @FindBy(xpath = "//td[text()='1'] / following-sibling :: td / descendant :: option")
    private List<WebElement> romanDropdownElements;
    @FindBy(css = "input[type='checkbox'][id='ivan']")
    private WebElement sergeyIvanCheckbox;
    @FindBy(css = "ul[class*='logs'] li")
    private List<WebElement> logsAsList;


    public UserTablePage(WebDriver driver) {
        super(driver);
        this.webDriver = driver;
        this.headerMenu = new HeaderMenu(driver);
    }

    public List<WebElement> getDropdownsList() {
        return dropdownsList;
    }

    public List<String> getUsernamesList() {
        return usernamesList.stream()
                            .map(WebElement::getText)
                            .collect(Collectors.toList());
    }

    public List<WebElement> getVipCheckboxesList() {
        return vipCheckboxesList;
    }

    public List<String> getTableNumbersList() {
        return tableNumbersList.stream()
                               .map(WebElement::getText)
                               .collect(Collectors.toList());
    }

    public List<String> getClearedDescriptionTextsList() {
        return descriptionImageTextsList.stream()
                                        .map(webElement -> webElement.getText().replaceAll("\n", " "))
                                        .collect(Collectors.toList());
    }

    public List<String> getNumberColumnExpected(List<Map<String, String>> listOfMaps) {
        List<String> column = new ArrayList<>();
        listOfMaps.forEach(mapRow -> column.add(mapRow.get("Number")));
        return column;
    }

    public List<String> getUserColumnExpected(List<Map<String, String>> listOfMaps) {
        List<String> column = new ArrayList<>();
        listOfMaps.forEach(mapRow -> column.add(mapRow.get("User")));
        return column;
    }

    public List<String> getDescriptionColumnExpected(List<Map<String, String>> listOfMaps) {
        List<String> column = new ArrayList<>();
        listOfMaps.forEach(mapRow -> column.add(mapRow.get("Description")));
        return column;
    }

    public List<String> getRomanDropdownList() {
        return romanDropdownElements.stream()
                                    .map(WebElement::getText)
                                    .collect(Collectors.toList());
    }

    public void clickCheckboxSergeyIvan() {
        sergeyIvanCheckbox.click();
    }

    public List<String> getLogsAsLitOfStrings(String log) {
        return logsAsList.stream()
                         .map(webElement -> webElement.getText().replaceAll("\n", " "))
                         .filter(string -> string.contains(log))
                         .collect(Collectors.toList());
    }
}
