package com.epam.tc.hw7.composite;

public enum Header {
    Home("Home"),
    ContactForm("Contact Form"),
    Service("Service"),
    MetalsAndColors("Metals & Colors");

    public String value;

    Header(String value) {
        this.value = value;
    }
}
