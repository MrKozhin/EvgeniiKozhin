package com.epam.tc.hw7.composite;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.entities.MetalsAndColorsDataEntity;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultSection extends Section {

    @UI("[class='panel-body-list results'] li")
    public static WebList results;

    public static List<String> getActualResultSection() {
        return results.stream()
                      .map(UIElement::getText)
                      .collect(Collectors.toList());
    }

    public static List<String> getExpectedResultSection(MetalsAndColorsDataEntity data) {
        return Arrays.asList(
            "Summary: " + (Integer.parseInt(data.summary.get(0)) + Integer.parseInt(data.summary.get(1))),
            "Elements: " + String.join(", ", data.elements),
            "Color: " + data.color,
            "Metal: " + data.metals,
            "Vegetables: " + String.join(", ", data.vegetables)
        );
    }

}
