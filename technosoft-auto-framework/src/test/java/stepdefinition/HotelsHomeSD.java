package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HotelsHomePage;
import org.testng.Assert;

public class HotelsHomeSD {

    private HotelsHomePage homePage = new HotelsHomePage();

    @Given("^I am on the Hotels home page$")
    public void iAmOnTheHotelsHomePage()
    {
        Assert.assertTrue(homePage.isHotelQueryPanelDisplayed(), "Invalid home page");
    }

    @When("I select (.+) from the (rooms) drop down list$")
    public void selectItemFromRoomsDDLByText(String anyTextValue, String anyDDL)
    {
        switch (anyDDL)
        {
            case "rooms":
                homePage.selectFromRoomsDDLByText(anyTextValue);
                break;
        }
    }

    @Then("I verify the correct number of occupancy panels displayed is (.+)$")
    public void verifyNumOfOccupancyPanelMatchesNumRoomSelected(String expectedValue)
    {
        Assert.assertEquals(homePage.getNumberOfRoomOccupancyPanelsDisplayed(), Integer.parseInt(expectedValue), "Number of panels does not match expected value");
    }
}
