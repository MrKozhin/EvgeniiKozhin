package com.epam.tc.hw6.exception;

public class WebDriverLaunchTypeException extends IllegalArgumentException {

    public WebDriverLaunchTypeException() {
        super("Unsupported launch type. Only local and remote launch types supported");
    }
}
