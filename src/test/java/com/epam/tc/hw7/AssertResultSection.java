package com.epam.tc.hw7;

import static com.epam.tc.hw7.composite.ResultSection.getActualResultSection;
import static com.epam.tc.hw7.composite.ResultSection.getExpectedResultSection;

import com.epam.tc.hw7.entities.MetalsAndColorsDataEntity;
import org.assertj.core.api.Assertions;

public class AssertResultSection {

    public static void assertResultSection(MetalsAndColorsDataEntity data) {
        Assertions.assertThat(getActualResultSection()).isEqualTo(getExpectedResultSection(data));
    }

}
