package com.epam.tc.hw9;

import static com.epam.tc.hw9.ServiceSpecification.requestSpecification;

import com.epam.tc.hw9.beans.Board;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BoardApi {

    private static Board getGson(Response response) {
        return new Gson().fromJson(response.asString().trim(), new TypeToken<Board>() {}
            .getType());
    }

    public static Response getBoardResponse(String id) {
        return RestAssured
            .given(requestSpecification())
                .with()
                .log().all()
            .when()
                .get(id)
                .prettyPeek();
    }

    public static Board getBoard(String id) {
        return getGson(RestAssured
            .given(requestSpecification())
                .with()
                .log().all()
                .get(id)
                .prettyPeek());
    }

    public static Board createBoard(ApiBuilder apiBuilder) {
        return getGson(RestAssured
            .given(requestSpecification())
                .with()
                .queryParams(apiBuilder.params)
                .log().all()
                .post()
                .prettyPeek());
    }

    public static void deleteBoard(String id) {
        getGson(RestAssured
            .given(requestSpecification())
                .with()
                .log().all()
                .delete(id)
                .prettyPeek());
    }

    public static Board updateBoard(String id, ApiBuilder apiBuilder) {
        return getGson(RestAssured
            .given(requestSpecification())
                .with()
                .queryParams(apiBuilder.params)
                .log().all()
                .put(id)
                .prettyPeek());
    }



}
