package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
    public static final Logger logger= LogManager.getLogger(HomePageObject.class);
   private  WebDriver driver;

    @FindBy(linkText="sign in securely")
    WebElement Link_Sing_in_Securly;



    public  HomePageObject(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void Click_Sing_In_Securly() {
        Link_Sing_in_Securly.click();
        logger.info("click Link: Sign in Securly");
    }
}
