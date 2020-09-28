package StepDef;

import PageObject.HomePageObject;
import PageObject.ProductDescObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import PageObject.CmnPageObject;

public class StepDefs {
   public static final Logger logger= LogManager.getLogger(StepDefs.class);


    WebDriver driver;
    CmnPageObject cmnpageobject;
    HomePageObject homepageobject;
    ProductDescObject productdescobject;

    public StepDefs(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @Given("User open the browser")
    public void user_open_the_browser()
    {
           System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
             driver=new ChromeDriver();
             driver.manage().window().maximize();
             logger.info("Chrome browser is opened");
    }

    @And("user navigated to the home application url")
    public void user_navigated_to_the_home_application_url() {
        driver.get("https://www.amazon.in/");
        logger.info("Amazon website is opened");




    }

    @And("user serach for the product {string}")
    public void user_serach_for_the_product(String string) {

    }

    @When("User click on the search product")
    public void user_click_on_the_search_product() {

    }

    @Then("pdroduct description open in a new tab")
    public void pdroduct_description_open_in_a_new_tab() {

    }


}
