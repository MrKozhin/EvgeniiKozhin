package com.epam.tc.hw9;

import static com.epam.tc.hw9.BoardApi.createBoardList;
import static com.epam.tc.hw9.BoardApi.getBoardLists;
import static com.epam.tc.hw9.utils.Utils.generateRandomString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.epam.tc.hw9.beans.BoardList;
import java.util.List;
import org.testng.annotations.Test;

public class ListTest extends BaseTest {

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
}
