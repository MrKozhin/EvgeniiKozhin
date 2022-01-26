package com.epam.tc.hw9;

import static org.hamcrest.Matchers.lessThan;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang.RandomStringUtils;

public class ServiceSpecification {

    public static ResponseSpecification responseSpecification() {
        return new ResponseSpecBuilder()
            .expectResponseTime(lessThan(500L))
            .build();
    }

    public static String generateRandomString() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
