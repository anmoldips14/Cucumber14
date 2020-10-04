package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPageObject {

    private static final Logger logger = LogManager.getLogger(SearchPageObject.class);

    private WebDriver driver;


    @FindBy(xpath="//a[@class='a-link-normal a-text-normal']")
    WebElement product_link_list;

    @FindBy(id="s-refinements")
    WebElement search_refinement_categories_segment;

    public SearchPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void ValidateProductSearchIsSuccessfull(){
        if ((search_refinement_categories_segment).isDisplayed()){
            Assert.assertTrue(true);
            logger.info("Search Page is displayed because refinement category is displayed");
        }else{
            logger.fatal("Search Page is not displayed because refinement category is not displayed");
            Assert.fail("Search Page is not displayed because refinement category is not displayed");
        }
    }

    public String ClickOnTheProductLink(int productIndex){
        //List<WebElement> listOfProducts = driver.findElements();
        List<WebElement> listOfProducts = driver.findElements((By) product_link_list);
        logger.info("Number of products searched: " + listOfProducts.size());


        listOfProducts.get(productIndex).click();
        logger.info("Clicked on the Link in the List with index: " + productIndex +
                ". Link Text: " + listOfProducts.get(productIndex).getText());


        return listOfProducts.get(productIndex).getText();

    }
}