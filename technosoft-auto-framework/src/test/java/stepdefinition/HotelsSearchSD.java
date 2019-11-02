package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HotelsHomePage;
import framework.webPages.HotelsSearchPage;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;

public class HotelsSearchSD {

    private HotelsHomePage homePage = new HotelsHomePage();
    private HotelsSearchPage searchPage = new HotelsSearchPage();

    private final String PARTIAL_DESTINATION_NEWYORK = "New York";
    private final String DESTINATION_NEWYORK = "New York, New York, United States of America";
    private final char STAR_RATING_DELIMITER = (char) 45;
    private final char SPACE_DELIMITER = (char) 32;
    private final String HILTON_HOTEL = "hilton";

    @Given("^I am on the Hotels search page using default values$")
    public void iAmOnTheSearchPage()
    {
        if(homePage.isHotelQueryPanelDisplayed())
        {
            homePage.setDestinationTextField(PARTIAL_DESTINATION_NEWYORK);
            homePage.clickOnDestinationAutoSuggestResultByText(DESTINATION_NEWYORK);
            homePage.clickSearchButton();

            if(homePage.isDestinationDisambiguationFieldDisplayed())
            {
                homePage.clickOnDestinationRadioButtonOnDisambiguationFieldByText(DESTINATION_NEWYORK);
                homePage.clickOnSearchButtonOnDestinationDisambiguationField();
            }
        }

        Assert.assertTrue(searchPage.isFiltersPanelDisplayed(), "Invalid page");
    }

    @When("^I select the (.+)-star checkbox in the Star Rating collapsible list$")
    public void clickOnStarCheckBoxByValue(String value)
    {
        searchPage.clickOnStarRatingCheckBoxByValue(value);
    }

    @When("^I click on the Landmarks filter in the filter panel$")
    public void clickOnLandmarksFilterInFilterPanel()
    {
        searchPage.scrollToLandmarksFilter();
        searchPage.clickOnLandmarksButton();
    }

    @When("^I select the (.+) checkbox in the Landmarks collapsible list$")
    public void clickOnCityCenterCheckboxInLandmarks(String landmark)
    {
        switch(landmark.toLowerCase())
        {
            case "city center":
                searchPage.clickOnCityCenterCheckBox();
                break;
        }
    }

    @When("^I set the distance to be (.+) in the Distance drop down list$")
    public void setDistanceFromLandmark(String distance)
    {
        searchPage.scrollToLandmarkDistanceDDL();
        searchPage.selectItemFromLandmarkDistanceDDLByText(distance);
    }

    @Then("^I verify that only hotels which have a (.+)-star rating are displayed$")
    public void verifyHotelsDisplayedMatchStarCheckboxFilter(String value)
    {
        //load all the hotels onto the screen
        searchPage.scrollUntilAdditionalInfoFieldIsDisplayed();
        searchPage.clickOnBackToTopButton();
        String[][] hotels = searchPage.getStarRatingsFromSearchResults();

        ArrayList<String> incorrectRatings = new ArrayList<String>(0);

        int rating;

        for(int i = 0; i < hotels.length; i ++)
        {
            rating = (int) Double.parseDouble(hotels[i][searchPage.VALUE].substring(0, hotels[i][searchPage.VALUE].indexOf(STAR_RATING_DELIMITER)));

            if(rating != Integer.parseInt(value))
                incorrectRatings.add(hotels[i][searchPage.KEY] + " has incorrectly displayed with rating: " + hotels[i][searchPage.VALUE]);
        }

        Assert.assertTrue(incorrectRatings.size() == 0,
                "Hotels with rating " + value + " expected but hotels with incorrect rating displayed: "
                        + Arrays.toString(incorrectRatings.toArray()));
    }

    @Then("^I verify that the only hotels which are within (.+) from the (.+) are displayed$")
    public void verifyHotelsDisplayedMatchDistanceFromCityCenterFilter(String distance, String landmark)
    {
        //load all the hotels onto the screen
        searchPage.scrollUntilAdditionalInfoFieldIsDisplayed();
        searchPage.clickOnBackToTopButton();

        String[][] hotels = searchPage.getDistanceFromLandmarkFromSearchResults(landmark);

        Assert.assertFalse(hotels == null, "Landmark not recognised");

        ArrayList<String> incorrectDistances = new ArrayList<String>(0);

        double hotelDistance;
        double maxDistance = Double.parseDouble(distance.substring(0, distance.indexOf(SPACE_DELIMITER)));

        for(int i = 0; i < hotels.length; i++)
        {
            hotelDistance = Double.parseDouble(hotels[i][searchPage.VALUE].substring(0, hotels[i][searchPage.VALUE].indexOf(SPACE_DELIMITER)));

            if(hotelDistance > maxDistance)
                incorrectDistances.add(hotels[i][searchPage.KEY] + " is " + hotels[i][searchPage.VALUE] + " from " + landmark + " which is outside max radius of " + maxDistance);
        }

        Assert.assertTrue(incorrectDistances.size() == 0,
                "Hotels with distances less than  " + maxDistance + " expected but hotels with greater distances displayed: "
                        + Arrays.toString(incorrectDistances.toArray()));
    }

    @Then("^I verify there is at least one Hilton Hotel displayed in the search results$")
    public void verifyHiltonHotelIsDisplayed()
    {
        String[] hotels = searchPage.getHotelNamesFromSearchResults();

        boolean isHiltonHotelFound = false;
        int index = 0;

        while(!isHiltonHotelFound && index < hotels.length)
        {
            isHiltonHotelFound = hotels[index].trim().toLowerCase().contains(HILTON_HOTEL);
            index++;
        }

        Assert.assertTrue(isHiltonHotelFound, "No Hilton hotels found");
    }

    @Then("^I verify the Deal of the Day is displayed$")
    public void verifyDealOfTheDayIsDisplayed()
    {
        Assert.assertTrue(searchPage.isDealOfTheDayDisplayed(), "Deal of the day should be displayed");
    }

    @Then("^I verify that the Deal of the Day is less than \\$200$")
    public void verifyDealOfTheDayPrice()
    {
        String hotelName = searchPage.getDealOfTheDayHotelName();
        int hotelPrice = searchPage.getDealOfTheDayPrice();

        Assert.assertTrue(hotelPrice <= 200,
                "Deal of the Day with hotel name " + hotelName + " has price $" + hotelPrice + " which is greater than $200");
    }
}
