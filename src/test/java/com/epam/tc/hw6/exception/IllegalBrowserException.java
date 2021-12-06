package com.epam.tc.hw6.exception;

import com.epam.tc.hw6.service.Browser;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class IllegalBrowserException extends IllegalArgumentException {

    public IllegalBrowserException() {
        super(String.format("Unsopported browser. Only %s browsers supported.",
            Arrays.stream(Browser.values())
                  .map(browser -> browser.name().toLowerCase(Locale.ROOT))
                  .collect(Collectors.joining(", "))));
    }
}
