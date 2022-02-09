package com.epam.tc.hw9;

import static com.epam.tc.hw9.BoardApi.createBoard;
import static com.epam.tc.hw9.BoardApi.deleteBoard;
import static com.epam.tc.hw9.utils.Utils.generateRandomString;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

import com.epam.tc.hw9.beans.Board;
import com.epam.tc.hw9.utils.ApiProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
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

    @AfterMethod
    public void tearDown() {
        deleteBoard(createdBoard.getId());
    }
}
