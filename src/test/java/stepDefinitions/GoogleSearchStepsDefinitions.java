package stepDefinitions;

import Tasks.GoogleSearchTasks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * This class contains the step definitions use for the feature files
 */
public class GoogleSearchStepsDefinitions {
    private GoogleSearchTasks googleSearchTasks;
    private String bookName = "Book Name",
            suggestionSearch = "Suggestion Search",
            url = "https://www.google.com";

    @Given("I'm on the google homepage")
    public void imOnTheGooglePage() {
        googleSearchTasks = new GoogleSearchTasks(Hook.driver);
        googleSearchTasks.openANewBrowserOn(url);
    }

    @When("^I search for \"(.*?)\" in Google$")
    public void iSearchForTheNameOfTheWindInGoogle(String bookName) {
        googleSearchTasks.searchInGoogleFor(bookName);
    }

    @Then("^The first result match with \"(.*?)\"$")
    public void theFirstResultMatchWithTheNameOfTheWind(String bookName) {
        googleSearchTasks.checkForFirstResult(bookName);
    }

    @Given("I search for \"(.*?)\" on Google Search Page")
    public void iSearchForTheNameOfTheWindOnGoogleSearchPage(String bookName) {
        googleSearchTasks.searchInGoogleFor(bookName);
    }


    @When("I click on the first result")
    public void iClickOnTheFirstResult() {
        googleSearchTasks.clickFirstResult();

    }

    @Then("^I go to the \"(.*?)\" page$")
    public void iGoToThePatrickRothFussTheBooksPage(String pageName) {
        googleSearchTasks.checkCurrentPage(pageName);
    }

    @When("I type \"(.*?)\" on Google Search Page")
    public void iTypeTheNameOfTheWindOnGoogleSearchPage(String bookName){
        googleSearchTasks.sendInfo(bookName);

    }

    @When("I select the first suggestion")
    public void iSelectTheFirstSuggestion(){
        googleSearchTasks.waitForTheDropBox();
        googleSearchTasks.clickFirstSuggestion();
    }



}
