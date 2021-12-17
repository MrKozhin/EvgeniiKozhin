package com.epam.tc.hw7.composite.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7.complex.VegetablesMultiDropdown;
import com.epam.tc.hw7.entities.MetalsAndColorsDataEntity;

public class MetalsAndColorsForm extends Form<MetalsAndColorsDataEntity> {
    @Css("#summary-block input")
    public static RadioButtons summary;

    @JDropdown(root = "#colors",
               list = "li",
               expand = ".caret")
    public static Dropdown colors;

    @UI("#metals input")
    public static DataListOptions metals;

    public static VegetablesMultiDropdown vegetables;

    @UI("input[type=checkbox]")
    public static Checklist elements;

    @UI("#submit-button")
    public static Button submitFormButton;

    @Override
    public void submit(MetalsAndColorsDataEntity data) {
        summary.select(data.summary.get(0), data.summary.get(1));
        elements.select(data.elements.toArray(new String[] {}));
        colors.select(data.colors);
        metals.select(data.metals);
        VegetablesMultiDropdown.customSelect(data.vegetables);
        submitFormButton.click();
    }


}
