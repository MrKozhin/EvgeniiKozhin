package com.epam.tc.hw9;

import static com.epam.tc.hw9.BoardApi.createBoard;
import static com.epam.tc.hw9.BoardApi.createBoardList;
import static com.epam.tc.hw9.BoardApi.deleteBoard;
import static com.epam.tc.hw9.BoardApi.getBoard;
import static com.epam.tc.hw9.BoardApi.getBoardLists;
import static com.epam.tc.hw9.BoardApi.getBoardResponse;
import static com.epam.tc.hw9.BoardApi.updateBoard;
import static com.epam.tc.hw9.ServiceSpecification.generateRandomString;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.epam.tc.hw9.beans.Board;
import com.epam.tc.hw9.beans.BoardList;
import com.epam.tc.hw9.data.TrelloApiDataProvider;
import io.restassured.response.Response;
import java.util.List;
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
    protected String randomBoardListName;
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
        apiBuilder.setBoardOrListName(randomBoardName)
                  .setDescription(randomBoardDescription)
                  .setBackground("pink");
        createdBoard = createBoard(apiBuilder);
    }

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

        Board board = createBoard(new ApiBuilder().setBoardOrListName(randomBoardNameForUpdate)
                                                  .setDescription(randomBoardDescriptionForUpdate)
                                                  .setBackground(color));

        createdBoard = updateBoard(createdBoard.getId(), apiBuilder.setBoardOrListName(randomBoardNameForUpdate)
                                                                   .setDescription(randomBoardDescriptionForUpdate)
                                                                   .updBackground(color));

        assertThat(board, equalTo(createdBoard));
        deleteBoard(board.getId());

    }

    @Test
    public void getBoardListsTest() {
        List<BoardList> boardLists = getBoardLists(createdBoard.getId());
        for (BoardList list : boardLists) {
            assertThat(list.getIdBoard(), equalTo(createdBoard.getId()));
        }
    }

    @Test
    public void createBoardListTest() {
        randomBoardListName = generateRandomString();
        BoardList boardList = createBoardList(new ApiBuilder().setBoardOrListName(randomBoardListName),
            createdBoard.getId()
        );
        assertThat(boardList.getName(), equalTo(randomBoardListName));

    }

    @AfterMethod
    public void tearDown() {
        deleteBoard(createdBoard.getId());
    }

}
