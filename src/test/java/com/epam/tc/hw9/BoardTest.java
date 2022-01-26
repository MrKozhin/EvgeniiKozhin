package com.epam.tc.hw9;

import static com.epam.tc.hw9.BoardApi.createBoard;
import static com.epam.tc.hw9.BoardApi.deleteBoard;
import static com.epam.tc.hw9.BoardApi.getBoard;
import static com.epam.tc.hw9.BoardApi.getBoardResponse;
import static com.epam.tc.hw9.BoardApi.notFoundSpecification;
import static com.epam.tc.hw9.ServiceSpecification.generateRandomString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.epam.tc.hw9.beans.Board;
import org.testng.annotations.Test;


public class BoardTest {

    @Test
    public void createBoardTest() {
        String generatedString = generateRandomString();
        ApiBuilder apiBuilder = new ApiBuilder();
        apiBuilder.setName(generatedString);
        Board board = createBoard(apiBuilder);
        assertThat(board.getName(), equalTo(generatedString));

        deleteBoard(board.getId());
    }

    @Test
    public void getBoardTest() {
        String someString = generateRandomString();
        ApiBuilder apiBuilder = new ApiBuilder();
        apiBuilder.setName(someString);
        Board createdBoard = createBoard(apiBuilder);

        Board board = getBoard(createdBoard.getId());
        assertThat(board.getName(), equalTo(someString));
        deleteBoard(board.getId());
    }

    @Test
    public void deleteBoardTest() {
        ApiBuilder apiBuilder = new ApiBuilder();
        apiBuilder.setName(generateRandomString());
        Board board = createBoard(apiBuilder);
        deleteBoard(board.getId());

        getBoardResponse(board.getId())
            .then()
            .spec(notFoundSpecification());
    }

}
