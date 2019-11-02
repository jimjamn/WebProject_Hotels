package framework.webPages;

import org.openqa.selenium.By;

public class HotelsSearchPage extends BasePage {

    private By filtersPanel = By.xpath("//div[@id='filters']");
    private By starRatingCheckboxes = By.xpath("//div[@id='filter-star-rating-contents']//input[@type='checkbox']");
    private By additionalInfoField = By.xpath("//h3[contains(text(),'Want to see more hotels?')]");
    private By firstDisclaimerField = By.xpath("//p[@class='disclaimer'][1]");
    private By backToTopButton = By.xpath("//a[@id='scroll-to-top']");

    private By landmarksButtonOnFilterPanel = By.xpath("//fieldset[@data-filter-name='landmarks']//h3[@role='button']");
    private By cityCenterLandmarkCheckbox = By.xpath("//div[@id='filter-landmarks-contents']//input[@type='checkbox' and @data-os-filter-val='City center']");
    private By landmarksDistanceDDL = By.xpath("//div[@id='filter-landmarks-contents']//select[@data-filter-type='distance']");

    private By hotelNamesFromSearchResultsList = By.xpath("//ol//div[@class='description resp-module']//h3[@class='p-name']//a");

    private By hotels = By.xpath("//ol//li[@class='hotel']//div[@class='description resp-module']");
    private By hotelName = By.xpath(".//h3[@class='p-name']//a");
    private By hotelDist = By.xpath(".//ul[@class='property-landmarks']//li[contains(text(), 'City center')]");
    private By hotelStarRating = By.xpath(".//span[contains(@class,'star-rating-text')]");

    private By dealOTheDayField = By.xpath("//li[contains(@class,'deal-of-the-day')]");
    private By dealOfTheDayHotelName = By.xpath("//li[contains(@class,'deal-of-the-day')]//h3//a");
    private By dealOfTheDayHotelPrice = By.xpath("//li[contains(@class,'deal-of-the-day')]//div[@class='price']//ins");

    private final String FILTER_ATTRIBUTE = "data-os-filter-val";
    private final int SCROLL_Y_PIXELS = -100;

    public boolean isFiltersPanelDisplayed()
    {
        return  isElementDisplayed(filtersPanel);
    }

    public boolean isDealOfTheDayDisplayed()
    {
        return isElementDisplayed(dealOTheDayField);
    }

    public void clickOnBackToTopButton()
    {
        clickOn(backToTopButton);
    }

    public void clickOnStarRatingCheckBoxByValue(String value)
    {
        clickOnElementInListByAttributeAndValue(starRatingCheckboxes, FILTER_ATTRIBUTE, value);
    }

    public void clickOnLandmarksButton()
    {
        clickOn(landmarksButtonOnFilterPanel);
    }

    public void clickOnCityCenterCheckBox()
    {
        clickOn(cityCenterLandmarkCheckbox);
    }

    public void scrollUntilAdditionalInfoFieldIsDisplayed()
    {
        while(!isElementDisplayed(additionalInfoField))
        {
            scrollPageToElement(firstDisclaimerField);
            scrollPageByPixel(0,SCROLL_Y_PIXELS);
        }
    }

    public void scrollToLandmarksFilter()
    {
        if(!isElementDisplayed(landmarksButtonOnFilterPanel))
            scrollPageToElement(landmarksButtonOnFilterPanel);
    }

    public void scrollToLandmarkDistanceDDL()
    {
        if(!isElementDisplayed(landmarksDistanceDDL))
            scrollPageToElement(landmarksDistanceDDL);
    }

    public String[] getHotelNamesFromSearchResults()
    {
        return getTextFromElementList(hotelNamesFromSearchResultsList);
    }

    public String[][] getStarRatingsFromSearchResults()
    {
        return getKeyValueTextFromElementList(hotels, hotelName, hotelStarRating);
    }

    public String[][] getDistanceFromLandmarkFromSearchResults(String landmark)
    {
        switch(landmark.trim().toLowerCase())
        {
            case "city center":
                return getKeyValueTextFromElementList(hotels, hotelName, hotelDist);
            default:
                return null;
        }
    }

    public String getDealOfTheDayHotelName()
    {
        return getTextFromElement(dealOfTheDayHotelName);
    }

    public int getDealOfTheDayPrice()
    {
        String price = getTextFromElement(dealOfTheDayHotelPrice);

        return Integer.parseInt(price.substring(price.indexOf('$') + 1));
    }

    public void selectItemFromLandmarkDistanceDDLByText(String itemToSelect)
    {
        selectByText(landmarksDistanceDDL, itemToSelect);
    }
}
