package PageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductDescObject {

    private static final Logger logger = LogManager.getLogger(ProductDescObject.class);

    private WebDriver driver;


    @FindBy(id="productTitle")
    private WebElement product_title;

    @FindBy(css="#add_to_cart_button")
   private  WebElement add_to_cart_button;

    public  ProductDescObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void ValidateProductTileIsCorrectlyDisplayed(){
        if ((product_title).isDisplayed()){
            Assert.assertTrue(true);
            logger.info("Product Title is displayed");
        }else{
            logger.fatal("Product Title is not displayed");
            Assert.fail("Product Title is not displayed");
        }
    }

    public void ValidateAddToCartButtonIsCorrectlyDisplayed(){
        if ((add_to_cart_button).isDisplayed()){
            Assert.assertTrue(true);
            logger.info("Add to Cart Button is displayed");
        }else{
            logger.fatal("Add to Cart Button is not displayed");
            Assert.fail("Add to Cart Button is not displayed");
        }
    }


}
