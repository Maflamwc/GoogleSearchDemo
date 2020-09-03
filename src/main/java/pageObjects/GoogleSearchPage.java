package pageObjects;

import interactions.UserActions;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

public class GoogleSearchPage {
    WebDriver driver;
    UserActions userActions;

    /**
     * Constructor
     *
     * @param driver The webDriver instance that comes from the Hook class
     */
    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        this.userActions = new UserActions(driver);
    }


    /**
     * An Enum class to gather all the webElement and its xpaths in order to call them when ever and element is needed
     */
    private enum EnumWebElement {
        INPUT_NOT_FOUND("not found", "WebElement not found"),
        INPUT_SEARCH("Search", "//input[@name='q']"),
        INPUT_FIRST_RESULT("Result", "//div [@id = \"rso\"]/div[1]//h3"),
        BUTTON_SEARCH("Zoom", "//input[@xpath='1']"),
        DROPBOX("Dropbox", "//div[@jsname = 'aajZCb']"),
        FIRST_SUGGESTION("Suggestion", "//ul[@role='listbox']//li[1]");


        private String name, xpath;

        /**
         * Enum constructor
         *
         * @param name  The ID used to identify which element is being called
         * @param xpath The string value that is returned when a search is done
         */
        EnumWebElement(String name, String xpath) {
            this.name = name;
            this.xpath = xpath;
        }

        private String getXpath() {
            return this.xpath;
        }

        private String getName() {
            return this.name;
        }

        /**
         * A search of a webElement using the name of the element through a Functional Programming function
         *
         * @param name The ID used to identify which element is being called
         * @return an string value corresponding to the @param name or a "Not Found" if the name doesn't exist
         */
        static private String getXpathByWebElementName(String name) {
            return Stream.of(GoogleSearchPage.EnumWebElement.values())
                    .filter(x -> x.getName().equals(name))
                    .findFirst()
                    .orElse(INPUT_NOT_FOUND)
                    .getXpath();
        }
    }


    /**
     * Looks for an element using the name and turn it into an webElement
     *
     * @param name The ID used to identify which element is being searched
     * @return A webElement instance
     */
    public WebElement getWebElementByName(String name) {
        return userActions.findElementByXpath(GoogleSearchPage.EnumWebElement.getXpathByWebElementName(name));
    }

    /**
     * It sends a value to a webelement that is got using its name
     *
     * @param value Data that is being sending towards the web element
     * @param field Name of the webElement to which should be sent
     */
    public void sendInformationToTheField(String value, String field) {
        userActions.sendKeys(value, getWebElementByName(field));
    }


    public void checkFirstResult(String s, String field) {
        Assert.assertTrue("The expect result is: " + s + " and the actual result was: " + getWebElementByName(field).getText(), getWebElementByName(field).getText().equals(s));
    }

    public void type(String s, String field) {
        userActions.sendKeys(s, getWebElementByName(field));
    }

    public void clickFirst(String result) {
        getWebElementByName(result).click();

    }

    public void PressEnter(String field) {
        getWebElementByName(field).sendKeys(Keys.ENTER);
    }

    public void checkName(String result) {
        Assert.assertTrue("The page doesn't have the expected title",driver.getTitle().equals(result));
    }

    public void clickFirstSuggestion(String suggestion) {
        getWebElementByName(suggestion).click();

    }

    public void waitForDropbox() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
