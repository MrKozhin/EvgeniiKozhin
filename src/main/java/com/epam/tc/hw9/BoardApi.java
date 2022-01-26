package com.epam.tc.hw9;

import static com.epam.tc.hw9.Constants.ENDPOINT;
import static com.epam.tc.hw9.Constants.KEY;
import static com.epam.tc.hw9.Constants.ROOT_PATH;
import static com.epam.tc.hw9.Constants.TOKEN;
import static com.epam.tc.hw9.ServiceSpecification.responseSpecification;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.ContentType.TEXT;

import com.epam.tc.hw9.beans.Board;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class BoardApi {

    private static Board getGson(Response response) {
        return new Gson().fromJson(response
            .asString()
            .trim(), new TypeToken<Board>() {}
            .getType());
    }

    public static Response getBoardResponse(String id) {
        return RestAssured
            .given(requestSpecification())
            .with()
            .log().all()
            .when()
            .get(ROOT_PATH + ENDPOINT + id)
            .prettyPeek();
    }

    public static Board getBoard(String id) {
        return getGson(RestAssured
            .given(requestSpecification())
            .with()
            .log().all()
            .get(ROOT_PATH + ENDPOINT + id)
            .prettyPeek());
    }

    public static Board createBoard(ApiBuilder apiBuilder) {
        return getGson(RestAssured
            .given(requestSpecification())
            .with()
            .queryParams(apiBuilder.params)
            .log().all()
            .post(ROOT_PATH + ENDPOINT).prettyPeek());
    }

    public static void deleteBoard(String id) {
        getGson(RestAssured
            .given(requestSpecification())
            .with()
            .log().all()
            .delete(ROOT_PATH + ENDPOINT + id).prettyPeek());
    }

    public static ResponseSpecification notFoundSpecification() {
        return new ResponseSpecBuilder()
            .addResponseSpecification(responseSpecification())
            .expectContentType(TEXT)
            .expectStatusCode(HttpStatus.SC_NOT_FOUND)
            .build();
    }

    private static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setContentType(JSON)
            .setAccept(JSON)
            .addQueryParam(KEY, ApiProperties.getInstance().getProperty(KEY))
            .addQueryParam(TOKEN, ApiProperties.getInstance().getProperty(TOKEN))
            .build();
    }

}
