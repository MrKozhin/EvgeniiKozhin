package com.epam.tc.hw7.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;

public class VegetablesMultiDropdown extends UIElement {

    @UI("#vegetables .caret")
    private static WebElement expandCaret;

    @UI("#vegetables label")
    private static List<WebElement> valuesList;

    @UI("#vegetables .btn")
    private static Button selectedField;

    public static void customSelect(List<String> values) {
        markElementsList(Arrays.asList(selectedField.getText().split(", ")));
        markElementsList(values);

    }

    private static void markElementsList(List<String> select) {
        expandCaret.click();
        valuesList.stream()
                  .filter(e -> select.contains(e.getText()))
                  .forEach(WebElement::click);
    }
}
