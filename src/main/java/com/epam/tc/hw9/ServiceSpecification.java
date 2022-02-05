package com.epam.tc.hw9;

import static com.epam.tc.hw9.Constants.KEY;
import static com.epam.tc.hw9.Constants.TOKEN;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.ContentType.TEXT;
import static org.hamcrest.Matchers.lessThan;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.HttpStatus;

public class ServiceSpecification {

    static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setContentType(JSON)
            .setAccept(JSON)
            .addQueryParam(KEY, ApiProperties.getInstance().getProperty(KEY))
            .addQueryParam(TOKEN, ApiProperties.getInstance().getProperty(TOKEN))
            .build();
    }

    public static ResponseSpecification responseSpecification() {
        return new ResponseSpecBuilder()
            .expectResponseTime(lessThan(600L))
            .build();
    }

    public static String generateRandomString() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public static ResponseSpecification notFoundSpecification() {
        return new ResponseSpecBuilder()
            .addResponseSpecification(responseSpecification())
            .expectContentType(TEXT)
            .expectStatusCode(HttpStatus.SC_NOT_FOUND)
            .build();
    }


}
