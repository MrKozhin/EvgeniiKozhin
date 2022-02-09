package com.epam.tc.hw9;

import static com.epam.tc.hw9.BoardApi.createBoard;
import static com.epam.tc.hw9.BoardApi.deleteBoard;
import static com.epam.tc.hw9.BoardApi.getBoard;
import static com.epam.tc.hw9.BoardApi.getBoardResponse;
import static com.epam.tc.hw9.BoardApi.updateBoard;
import static com.epam.tc.hw9.utils.Utils.generateRandomString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.epam.tc.hw9.beans.Board;
import com.epam.tc.hw9.data.TrelloApiDataProvider;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


public class BoardTest extends BaseTest {

    @Test
    public void createBoardTest() {
        assertThat(createdBoard.getName(), equalTo(randomBoardName));
    }

    @Test
    public void getBoardTest() {
        Board board = getBoard(createdBoard.getId());
        assertThat(board.getName(), equalTo(randomBoardName));
    }

    @Test
    public void deleteBoardTest() {
        Board board = createBoard(new ApiBuilder().setBoardOrListName("Board for delete"));

        deleteBoard(board.getId());

        Response response = getBoardResponse(board.getId());
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test(dataProvider = "boardBackgroundColorDataProvider", dataProviderClass = TrelloApiDataProvider.class)
    public void updateBoardTest(String color) {
        randomBoardNameForUpdate = generateRandomString();
        randomBoardDescriptionForUpdate = generateRandomString();

        createdBoard = updateBoard(createdBoard.getId(), apiBuilder.setBoardOrListName(randomBoardNameForUpdate)
                                                                   .setDescription(randomBoardDescriptionForUpdate)
                                                                   .updBackground(color));

        assertThat(createdBoard, equalTo(getBoard(createdBoard.getId())));
    }





}
