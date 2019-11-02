package framework.webPages;

import org.openqa.selenium.By;

public class HotelsHomePage extends BasePage {

    private By hotelQueryPanel = By.xpath("//div[contains(@class,'widget-query-nights-display')]");
    private By destinationTextField = By.xpath("//input[@id='qf-0q-destination']");
    private By destinationAutoSuggestResultList = By.xpath("//tbody[@class='autosuggest-city']//div[@class='autosuggest-category-result']");
    private By searchButton = By.xpath("//button[@class='cta cta-strong']");
    private By roomsRoomAndOccupantDDL = By.xpath("//select[@id='qf-0q-compact-occupancy']");
    private By roomsRoomOnlyDDL = By.xpath("//select[@id='qf-0q-rooms']");
    private By roomOccupantsPanels = By.xpath("//div[@class='widget-query-group widget-query-room-options']");

    private By destinationDisambiguationField = By.xpath("//div[@class='widget-overlay widget-disambiguation widget-overlay-active']");
    private By destinationDisambiguationRadioButtonList = By.xpath("//div[@class='widget-overlay-bd']//input[@type='radio']");
    private By destinationDisambiguationSearchButton = By.xpath("//div[@class='widget-overlay-ft']//button[text()='Search']");

    private final String MORE_OPTIONS = "More options…";

    public boolean isHotelQueryPanelDisplayed()
    {
        return isElementDisplayed(hotelQueryPanel);
    }

    public void clickSearchButton()
    {
        clickOn(searchButton);
    }

    public void setDestinationTextField(String destination)
    {
        setValue(destinationTextField, destination);
    }

    public void clickOnDestinationAutoSuggestResultByText(String text)
    {
        clickOnElementInListByText(destinationAutoSuggestResultList, text, false);
    }

    public void selectFromRoomsDDLByText(String numOfRooms)
    {
        if(isElementDisplayed(roomsRoomAndOccupantDDL))
            selectByText(roomsRoomAndOccupantDDL, MORE_OPTIONS);

        selectByText(roomsRoomOnlyDDL, numOfRooms);

    }

    public int getNumberOfRoomOccupancyPanelsDisplayed()
    {
        return getNumberOfElementsInWebElementsList(roomOccupantsPanels);
    }

    public boolean isDestinationDisambiguationFieldDisplayed()
    {
        return isElementDisplayed(destinationDisambiguationField);
    }

    public void clickOnDestinationRadioButtonOnDisambiguationFieldByText(String text)
    {
        clickOnElementInListByText(destinationDisambiguationRadioButtonList, text, true);
    }

    public void clickOnSearchButtonOnDestinationDisambiguationField()
    {
        clickOn(destinationDisambiguationSearchButton);
    }
}
