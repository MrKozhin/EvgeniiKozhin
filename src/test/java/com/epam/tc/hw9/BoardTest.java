package com.epam.tc.hw9;

import static com.epam.tc.hw9.BoardApi.createBoard;
import static com.epam.tc.hw9.BoardApi.deleteBoard;
import static com.epam.tc.hw9.BoardApi.getBoard;
import static com.epam.tc.hw9.BoardApi.getBoardResponse;
import static com.epam.tc.hw9.BoardApi.updateBoard;
import static com.epam.tc.hw9.ServiceSpecification.generateRandomString;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.epam.tc.hw9.beans.Board;
import com.epam.tc.hw9.data.TrelloApiDataProvider;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.AfterMethod;
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
        baseURI = ApiProperties.getInstance().getProperty("root_path");
        basePath = ApiProperties.getInstance().getProperty("endpoint");
        randomBoardName = generateRandomString();
        randomBoardDescription = generateRandomString();
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
    }

    @Test
    public void setBoardDescriptionTest() {
        assertThat(createdBoard.getDesc(), equalTo(randomBoardDescription));
    }

    @Test
    public void boardBackgroundTest() {
        assertThat(createdBoard.getPrefs().getBackground(), equalTo("pink"));
    }

    @Test
    public void getBoardTest() {
        Board board = getBoard(createdBoard.getId());
        assertThat(board.getName(), equalTo(randomBoardName));
    }

    @Test
    public void deleteBoardTest() {
        Board board = createBoard(new ApiBuilder().setBoardName("Board for delete"));

        deleteBoard(board.getId());

        Response response = getBoardResponse(board.getId());
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Test(dataProvider = "boardBackgroundColorDataProvider", dataProviderClass = TrelloApiDataProvider.class)
    public void updateBoardTest(String color) {
        randomBoardNameForUpdate = generateRandomString();
        randomBoardDescriptionForUpdate = generateRandomString();

        createdBoard = updateBoard(createdBoard.getId(), apiBuilder.setBoardName(randomBoardNameForUpdate)
                                                                   .setDescription(randomBoardDescriptionForUpdate)
                                                                   .updBackground(color));

        assertThat(createdBoard.getPrefs().getBackground(), equalTo(color));

    }

    @AfterMethod
    public void tearDown() {
        deleteBoard(createdBoard.getId());
    }

}
