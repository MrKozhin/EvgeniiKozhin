package com.epam.tc.hw9;

import static com.epam.tc.hw9.BoardApi.createBoard;
import static com.epam.tc.hw9.BoardApi.deleteBoard;
import static com.epam.tc.hw9.BoardApi.getBoard;
import static com.epam.tc.hw9.BoardApi.getBoardResponse;
import static com.epam.tc.hw9.BoardApi.updateBoard;
import static com.epam.tc.hw9.ServiceSpecification.generateRandomString;
import static com.epam.tc.hw9.ServiceSpecification.notFoundSpecification;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.epam.tc.hw9.beans.Board;
import com.epam.tc.hw9.data.TrelloApiDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BoardTest {

    protected String randomBoardName;
    protected String randomBoardNameForUpdate;
    protected String randomBoardDescription;
    protected String randomBoardDescriptionForUpdate;
    protected ApiBuilder apiBuilder;
    protected Board createdBoard;


    @BeforeClass
    public void setUp() {
        randomBoardName = generateRandomString();
        randomBoardNameForUpdate = generateRandomString();
        randomBoardDescription = generateRandomString();
        randomBoardDescriptionForUpdate = generateRandomString();
    }

    @BeforeMethod
    public void beforeTest() {
        apiBuilder = new ApiBuilder();
        apiBuilder.setBoardName(randomBoardName)
                  .setDescription(randomBoardDescription)
                  .setBackground("pink");
        createdBoard = createBoard(apiBuilder);
    }

    @Test
    public void createBoardTest() {
        assertThat(createdBoard.getName(), equalTo(randomBoardName));

        deleteBoard(createdBoard.getId());
    }

    @Test
    public void setBoardDescriptionTest() {
        assertThat(createdBoard.getDesc(), equalTo(randomBoardDescription));

        deleteBoard(createdBoard.getId());
    }

    @Test(dataProvider = "boardDataProvider", dataProviderClass = TrelloApiDataProvider.class)
    public void boardBackgroundTest(String backgroundExpected) {
        assertThat(createdBoard.getPrefs().getBackground(), equalTo(backgroundExpected));

        deleteBoard(createdBoard.getId());
    }

    @Test
    public void getBoardTest() {
        Board board = getBoard(createdBoard.getId());
        assertThat(board.getName(), equalTo(randomBoardName));

        deleteBoard(board.getId());
    }

    @Test
    public void deleteBoardTest() {
        deleteBoard(createdBoard.getId());

        getBoardResponse(createdBoard.getId())
            .then()
            .spec(notFoundSpecification());
    }

    @Test(dataProvider = "boardBackgroundColorDataProvider", dataProviderClass = TrelloApiDataProvider.class)
    public void updateBoardTest(String color) {
        createdBoard = updateBoard(createdBoard.getId(), apiBuilder.setBoardName(randomBoardNameForUpdate)
                                                                   .setDescription(randomBoardDescriptionForUpdate)
                                                                   .updBackground(color));
        assertThat(createdBoard.getName(), equalTo(randomBoardNameForUpdate));
        assertThat(createdBoard.getDesc(), equalTo(randomBoardDescriptionForUpdate));
        assertThat(createdBoard.getPrefs().getBackground(), equalTo(color));


        deleteBoard(createdBoard.getId());
    }

}
