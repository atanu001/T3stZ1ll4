package godZ.qa.pages;

import godZ.qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends BasePage {

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    public void enterSearchProduct(String product) {
        searchBox.clear();
        searchBox.sendKeys(product);
    }

    public void clickSearch() {
        searchButton.click();
    }

    public boolean isSearchResultDisplayed(String keyword) {
        return driver.getTitle().toLowerCase().contains(keyword.toLowerCase());
    }


}
