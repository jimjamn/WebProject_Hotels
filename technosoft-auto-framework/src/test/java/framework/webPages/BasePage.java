package framework.webPages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import stepdefinition.SharedSD;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohammadmuntakim
 */
public class BasePage {

    private final int MAX_RETRY_ATTEMPT = 3;
    private final By PARENT_LABEL_LOCATOR = By.xpath("./parent::label");

    public final static int KEY = 0;
    public final static int VALUE = 1;

	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	// Return a List of WebElements
	public static List<WebElement> webActions(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the elements therefore Timeout Exception has been thrown");

		List<WebElement> elements = wait.until(new Function<WebDriver, List<WebElement>>() {
			public List<WebElement> apply(WebDriver driver) {
				return driver.findElements(locator);
			}
		});

		return elements;
	}

	public void clickOn(By locator) {

        try
        {
        webAction(locator).click();
        }
        catch(ElementClickInterceptedException e)
        {
            JavascriptExecutor js = (JavascriptExecutor)SharedSD.getDriver();
            js.executeScript("arguments[0].click();", webAction(locator));
        }
	}

    public void clickOnElementInListByText(By locator, String text, boolean isTextFromParentLabel)
    {
        List<WebElement> searchResults = webActions(locator);

        WebElement result;
        int resultIndex = 0;
        int retryAttempt;
        boolean retryRequired;
        boolean isResultFound = false;

        while (!isResultFound && (resultIndex < searchResults.size()))
        {
            result = searchResults.get(resultIndex);
            retryAttempt = 0;
            retryRequired = true;

            while(retryAttempt < MAX_RETRY_ATTEMPT && !isResultFound && retryRequired)
            {
                try
                {
                    if (getTextFromElement(result, isTextFromParentLabel).trim().equals(text))
                    {
                        result.click();
                        isResultFound = true;
                    }

                    retryRequired = false;
                }
                catch(StaleElementReferenceException e)
                {
                    result = refreshElement(result);
                }

                retryAttempt++;
            }

            resultIndex++;
        }
    }

    private String getTextFromElement(WebElement element, boolean isTextFromParentLabel)
    {
        if(isTextFromParentLabel)
            return element.findElement(PARENT_LABEL_LOCATOR).getText();
        else
            return element.getText().trim();
    }

    public void clickOnElementInListByAttributeAndValue(By locator, String attribute, String value)
    {
        List<WebElement> searchResults = webActions(locator);

        WebElement result;
        int resultIndex = 0;
        boolean isResultFound = false;

        while (!isResultFound && (resultIndex < searchResults.size()))
        {
            result = searchResults.get(resultIndex);

            if(result.getAttribute(attribute).equals(value))
            {
                result.click();
                isResultFound = true;
            }

            resultIndex++;
        }
    }

    /**
     * Click on calendar date where tag has an attribute containing data date
     */
    public void clickDayOnCalendarByDateStringAndAttribute(By locator, String dateToClick, String dateAttribute)
    {
        clickOnElementInListByAttributeAndValue(locator, dateToClick, dateAttribute);
    }

	public void setValue(By locator, String value) {

		webAction(locator).sendKeys(value);
	}

	public void clearValue(By locator)
	{
		webAction(locator).clear();
	}

	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public String[] getTextFromElementList(By locator)
    {
        List<WebElement> elements = webActions(locator);
        String[] textStrings = new String[elements.size()];

        for(int i = 0; i < elements.size(); i ++)
            textStrings[i] = elements.get(i).getText();

        return textStrings;

    }

    public String[][] getKeyValueTextFromElementList(By baseLocator, By keyLocator, By valueLocator )
    {
        List<WebElement> elements = webActions(baseLocator);
        String[][] textStrings = new String[elements.size()][2];

        for(int i = 0; i < textStrings.length; i++ )
        {
            textStrings[i][KEY] = getChildElementTextFromParentElement(elements.get(i), keyLocator);
            textStrings[i][VALUE] = getChildElementTextFromParentElement(elements.get(i), valueLocator);
        }

        return textStrings;
    }

	public String getValidationMessageFromHTML5RequiredElement(By locator)
    {
        return webAction(locator).getAttribute("validationMessage");
    }

	public boolean isElementDisplayed(By locator) {

	    boolean isDisplayed = false;

	    try
        {
            webAction(locator).isDisplayed();
            isDisplayed = true;
        }
	    catch(TimeoutException e)
        {}

		return isDisplayed;
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public boolean isElementEnabled(By locator)
	{
		return webAction(locator).isEnabled();
	}

	public void selectByText(By locator, String text)
	{
		Select ddl = new Select(webAction(locator));
		ddl.selectByVisibleText(text);
	}

	public void selectByIndex(By locator, int index)
	{
		Select ddl = new Select(webAction(locator));
		ddl.selectByIndex(index);
	}

	public void selectByValue(By locator, String value)
	{
		Select ddl = new Select(webAction(locator));
		ddl.selectByValue(value);
	}

	public String getTextFromSelectedOption(By locator)
	{
		Select ddl = new Select(webAction(locator));
		return ddl.getFirstSelectedOption().getText();
	}

	public String getValueFromSelectedOption(By locator)
	{
		Select ddl = new Select(webAction(locator));
		return ddl.getFirstSelectedOption().getAttribute("value");
	}

	public boolean isItemInDropDownListByText(By locator, String ddlItemText)
	{
		Select ddl = new Select(webAction(locator));
		List<WebElement> ddlItems = ddl.getOptions();

		boolean isFound = false;
		int index = 0;

		while (!isFound && index < ddlItems.size())
		{
			isFound = ddlItems.get(index).getText().equals(ddlItemText);
			index++;
		}

		return isFound;
	}

	public ArrayList<String> getDuplicateDDLItems(By locator)
	{
		Select ddlToCheck = new Select(webAction(locator));
		List<WebElement> ddlItemList = ddlToCheck.getOptions();

		ArrayList<String> duplicates = new ArrayList<String>(0);
		String ddlItemText;
		int i = 0;
		int j = 0;

		while (i < ddlItemList.size())
		{
			ddlItemText = ddlItemList.get(i).getText();
			j = i + 1;

			while(j < ddlItemList.size())
			{
				//Add the duplicate to the ArrayList but only if it isn't already in the ArrayList
				if(ddlItemText.equals(ddlItemList.get(j).getText()) && !duplicates.contains(ddlItemText))
					duplicates.add(ddlItemText);
				j++;
			}
			i++;
		}

		return duplicates;
	}

	public boolean hasDuplicateDDLItems(By locator)
	{
		return getDuplicateDDLItems(locator).size() > 0;
	}

	public int getNumberOfElementsInWebElementsList(By locator)
	{
		return webActions(locator).size();
	}

	//Scrolling

	public void scrollPageByPixel(int x, int y)
	{
		JavascriptExecutor jsScrollBy = (JavascriptExecutor)SharedSD.getDriver();
		jsScrollBy.executeScript("scrollBy(" + x + "," + y + ");");
	}

    public void scrollPageToElement(By locator)
    {
        JavascriptExecutor js = (JavascriptExecutor)SharedSD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", webAction(locator));
    }

    //Windows

    public void switchToWindowOrTab(int index)
	{
		List<String> windows = new ArrayList<String>(SharedSD.getDriver().getWindowHandles());
		SharedSD.getDriver().switchTo().window(windows.get(index));
	}

	public void switchToDefaultWindowOrTab()
	{
		List<String> windows = new ArrayList<String>(SharedSD.getDriver().getWindowHandles());
		for(int i = 1; i < windows.size(); i ++)
		{
			SharedSD.getDriver().switchTo().window(windows.get(i));
			SharedSD.getDriver().close();
		}

		SharedSD.getDriver().switchTo().window((windows.get(0)));
	}

	//Navigation

	public void browserNavigateForward()
	{
		SharedSD.getDriver().navigate().forward();
	}

	public void browserNavigateBack()
	{
		SharedSD.getDriver().navigate().back();
	}

	public void browserRefresh()
	{
		SharedSD.getDriver().navigate().refresh();
	}

	//Mouse actions

	public void mouseOverElement(By locator)
	{
		WebElement elementToMouseOver = SharedSD.getDriver().findElement(locator);
		Actions action = new Actions(SharedSD.getDriver());
		action.moveToElement(elementToMouseOver).build().perform();
	}

	public void mouseDoubleClickElement(By locator)
	{
		WebElement elementToDoubleClick = SharedSD.getDriver().findElement(locator);
		Actions action = new Actions(SharedSD.getDriver());
		action.doubleClick(elementToDoubleClick);
	}

	public void mouseClickAndHoldElement(By locator)
	{
		WebElement elementToClickAndHold = SharedSD.getDriver().findElement(locator);
		Actions action = new Actions(SharedSD.getDriver());
		action.clickAndHold(elementToClickAndHold);
	}

	public void mouseContextClickElement(By locator)
	{
		WebElement elementToContextClick = SharedSD.getDriver().findElement(locator);
		Actions action = new Actions(SharedSD.getDriver());
		action.contextClick(elementToContextClick);
	}

	public void mouseDragAndDropFromElementToOtherElement(By locatorToDragFrom, By locatorToDropTo)
	{
		WebElement elementToDragFrom = SharedSD.getDriver().findElement(locatorToDragFrom);
		WebElement elementToDropTo = SharedSD.getDriver().findElement(locatorToDropTo);
		Actions action = new Actions(SharedSD.getDriver());
		action.dragAndDrop(elementToDragFrom, elementToDropTo);
	}

	//Frame

	public void switchToFrame(String frameName)
	{
		SharedSD.getDriver().switchTo().frame(frameName);
	}

	//Alerts

	public void clickOnAlertAcceptButton()
	{
		SharedSD.getDriver().switchTo().alert().accept();
	}

	public void clickOnAlertDismissButton()
	{
		SharedSD.getDriver().switchTo().alert().dismiss();
	}

	public String getAlertText()
	{
		return SharedSD.getDriver().switchTo().alert().getText();
	}

	public void setAlertText(String text)
	{
		SharedSD.getDriver().switchTo().alert().sendKeys(text);
	}

	//private methods

    private String getChildElementTextFromParentElement(WebElement parentElement, By childLocator)
    {
        String text;

        try {
            text = parentElement.findElement(childLocator).getText();
        }
        catch(NoSuchElementException e) {
            text = null;
        }

        return text;
    }

    private WebElement refreshElement(WebElement element){
        String sElement = element.toString().split("-> ")[1];
        String locatorType = sElement.split(": ")[0];
        if (locatorType.matches("css selector")) locatorType = "css";
        String loc0 = sElement.split(": ")[1];
        String theLocator = loc0.substring(0,loc0.length()-1);
        System.out.println("Refreshing element with "+locatorType+": "+theLocator);

        return getElement(theLocator,locatorType);
    }

    private WebElement getElement(String locator, String type) {

        switch(type)
        {
            case "id":
                return webAction(By.id(locator));
            case "name":
                return webAction(By.name(locator));
            case "className":
                return webAction(By.className(locator));
            case "tagName":
                return webAction(By.tagName(locator));
            case "linkText":
                return webAction(By.linkText(locator));
            case "partialLinkText":
                return webAction(By.partialLinkText(locator));
            case "xpath":
                return webAction(By.xpath(locator));
            default:
                return webAction(By.cssSelector(locator));
        }
    }
}
