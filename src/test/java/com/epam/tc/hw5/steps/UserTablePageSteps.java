package com.epam.tc.hw5.steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import org.testng.asserts.SoftAssert;

public class UserTablePageSteps extends AbstractBaseStep {

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkAmountOfDropdowns(int dropdowns) {
        assertThat(userTablePage.getDropdownsList().size()).isEqualTo(dropdowns);
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void checkAmountOfUsernames(int usernames) {
        assertThat(userTablePage.getUsernamesList().size()).isEqualTo(usernames);
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void checkAmountOfImageTextDescriptions(int textDescriptions) {
        assertThat(userTablePage.getClearedDescriptionTextsList().size()).isEqualTo(textDescriptions);
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkAmountOfVipCheckboxes(int checkboxes) {
        assertThat(userTablePage.getVipCheckboxesList().size()).isEqualTo(checkboxes);
    }

    @And("User table should contain following values:")
    public void checkUserTableValues(DataTable dataTable) {
        SoftAssert softAssert = new SoftAssert();
        List<Map<String, String>> userTable = dataTable.asMaps(String.class, String.class);

        softAssert.assertEquals(userTablePage.getTableNumbersList(),
            userTablePage.getNumberColumnExpected(userTable)
        );
        softAssert.assertEquals(userTablePage.getUsernamesList(),
            userTablePage.getUserColumnExpected(userTable)
        );
        softAssert.assertEquals(userTablePage.getClearedDescriptionTextsList(),
            userTablePage.getDescriptionColumnExpected(userTable)
        );
        softAssert.assertAll();
    }

    @And("^droplist should contain value in column Type for user Roman$")
    public void checkDropdownElementsForUserRoman(DataTable dataTable) {
        List<String> listExpected = dataTable.asList(String.class);
        SoftAssert softAssert = new SoftAssert();

        for (int n = 0; n < userTablePage.getRomanDropdownList().size(); n++) {
            softAssert.assertEquals(userTablePage.getRomanDropdownList().get(n),
                listExpected.get(n + 1)
            );
        }
        softAssert.assertAll();
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectVipCheckboxForUserIvan() {
        userTablePage.clickCheckboxSergeyIvan();
    }

    @Then("1 log row has {string} text in log section")
    public void checkLogRowForUserIvan(String logRow) {
        assertThat(userTablePage.getLogsAsLitOfStrings(logRow)
                                .get(0)).contains(logRow);

    }

}
