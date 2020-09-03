package Tasks;

import org.openqa.selenium.WebDriver;
import pageObjects.GoogleSearchPage;


public class GoogleSearchTasks {
    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;
    private String
            search = "Search",
            result = "Result",
            suggestion = "Suggestion";

    /**
     * Constructor
     *
     * @param driver The webDriver instance that comes from the Hook class
     */
    public GoogleSearchTasks(WebDriver driver) {
        this.driver = driver;
        googleSearchPage = new GoogleSearchPage(driver);
    }


    /**
     * Navigates towards the url that's sent as a parameter
     *
     * @param url The url to which the browser must navigate
     */
    public void openANewBrowserOn(String url) {
        driver.get(url);

    }

    public void searchInGoogleFor(String bookName) {
        googleSearchPage.type(bookName, search);
        googleSearchPage.PressEnter(search);
        getCurrentUrl();
    }

    public void waitForTheDropBox() {
        googleSearchPage.waitForDropbox();
    }

    public void checkForFirstResult(String bookName) {
        googleSearchPage.checkFirstResult(bookName, result);
    }

    public void clickFirstResult() {
        googleSearchPage.clickFirst(result);
        getCurrentUrl();
    }

    public void checkCurrentPage(String pageTitle) {
        googleSearchPage.checkName(pageTitle);
    }

    public void sendInfo(String bookName) {
        googleSearchPage.sendInformationToTheField(bookName, search);
    }

    public void clickFirstSuggestion() {
        googleSearchPage.clickFirstSuggestion(suggestion);
        googleSearchPage.PressEnter(search);
        getCurrentUrl();
    }

    public void getCurrentUrl() {
        driver.get(driver.getCurrentUrl());

    }

}