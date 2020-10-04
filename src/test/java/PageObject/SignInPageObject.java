package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPageObject {

    private static final Logger logger = LogManager.getLogger(SignInPageObject.class);

     WebDriver driver;

    @FindBy(id="ap_email")
WebElement input_textbox_email;

    public SignInPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void validateEmailInputTextBoxIsDisplayed(){
        if ((input_textbox_email).isDisplayed()){
            Assert.assertTrue(true);
            logger.info("Email input box is displayed");
        }else{
            logger.fatal("Email input box not displayed");
            Assert.fail("Email text box does not appear for login after clicking on Sign in button");
        }
    }

    public void enterTextInEmailTextBox(String text){
        logger.info("Text entered in email id: " + text);
        (input_textbox_email).sendKeys(text);
    }

}