package StepDef;

import PageObject.*;
import core.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefs {
   public static final Logger logger= LogManager.getLogger(StepDefs.class);

//to check CICD pipeline on Github
    WebDriver driver;
    String base_url = "https://amazon.in";
    int implicit_wait_timeout_in_sec = 20;
    Scenario scn;

    CmnPageObject cmnpageobject;
    HomePageObject homepageobject;
    ProductDescObject productdescobject;
    SearchPageObject searchpageobject;
    SignInPageObject  signinpageobject;



    @Before
    public void setUp(Scenario scn) throws Exception {
        this.scn = scn;
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver=new ChromeDriver();
        String browserName = WebDriverFactory.getBrowserName();
        driver = WebDriverFactory.getWebDriverForBrowser(browserName);
        logger.info("Browser invoked.");

        cmnpageobject = new CmnPageObject(driver);
        homepageobject = new HomePageObject(driver);
        productdescobject = new ProductDescObject(driver);
        searchpageobject = new SearchPageObject(driver);
        signinpageobject = new SignInPageObject(driver);
    }

        @After(order=1)
        public void cleanUp()
    {
        WebDriverFactory.quitDriver();
        //driver.close();
            scn.log("Browser Closed");
        }
        @After(order=2)
                public void takeScreenShot(Scenario s)

        {
            if(s.isFailed())
            {

                TakesScreenshot scnShot=(TakesScreenshot)driver;
                byte[] data=scnShot.getScreenshotAs(OutputType.BYTES);
                scn.attach(data,"image/png","Failed step Name:" +s.getName());

            }
            else{
                scn.log("Test is passed ,no screenshot captured");
            }

        }


    @Given("User navigated to the home application url")
    public void user_navigated_to_the_home_application_url() {
        WebDriverFactory.navigateToTheUrl(base_url);
        scn.log("Browser navigated to URL: " + base_url);

        String Expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
       cmnpageobject.Validate_pageTitle(Expected);
    }

    @When("User Search for product {string}")
    public void user_search_for_product(String productName) {
        cmnpageobject.Search_Text_box(productName);
        cmnpageobject.Search_Btn();
        scn.log("Product Searched" + productName);
    }

    @Then("Search Result page is displayed")
    public void search_result_page_is_displayed() {
     searchpageobject.ValidateProductSearchIsSuccessfull();
    }

    @When("User click on any product")
    public void user_click_on_any_product() {
       searchpageobject.ClickOnTheProductLink(0);
    }

    @Then("Product Description is displayed in new tab")
    public void product_description_is_displayed_in_new_tab() {
        WebDriverFactory.switchBrowserToTab();
        scn.log("Switched to the new window/tab");

   productdescobject.ValidateProductTileIsCorrectlyDisplayed();
   //productdescobject.ValidateAddToCartButtonIsCorrectlyDisplayed();
    }
}