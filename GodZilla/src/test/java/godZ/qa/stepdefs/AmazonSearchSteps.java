package godZ.qa.stepdefs;

import godZ.qa.driver.DriverManager;
import godZ.qa.pages.AmazonHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class AmazonSearchSteps {
    private WebDriver driver;
    private AmazonHomePage amazonHomePage;

    public AmazonSearchSteps() {
        this.driver = DriverManager.getDriver();
    }


    @Given("I am on the Amazon homepage")
    public void iAmOnTheAmazonHomepage() {
        driver.get("https://www.amazon.in");
        amazonHomePage = new AmazonHomePage(driver);
    }
    @When("I search for {string}")
    public void iSearchForProduct(String product) {
        amazonHomePage.enterSearchProduct(product);
        amazonHomePage.clickSearch();

    }
    @Then("I should see search results for {string}")
    public void iShouldSeeSearchResultsForProduct(String product) {
        Assert.assertTrue(amazonHomePage.isSearchResultDisplayed(product), "Search result is not displayed");


    }
}
