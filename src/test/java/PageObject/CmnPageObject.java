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

public class CmnPageObject {
    public static final Logger logger= LogManager.getLogger(CmnPageObject.class);
    WebDriver driver;

    @FindBy(id="twotabsearchtextbox")
    WebElement SearchTextBox;

    @FindBy(xpath="//div[@id='nav-logo']//span[1]")
    WebElement Logo;

    @FindBy(xpath="//div[@id='nav-cart-text-container']")
    WebElement Cart;

    @FindBy(xpath="//span[contains(text(),'& Orders')]")
    WebElement ReturnsAndOrders;

    @FindBy(xpath="//a[@id='nav-link-prime']//span[contains(text(),'Prime')]")
    WebElement TryPrime;

    @FindBy(className="nav-input")
    WebElement searchBtn;

    @FindBy(id="nav-hamburger-menu")
    WebElement DropDownList;

    public CmnPageObject(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void Search_Text_Box(String text)
    {
        WebDriverWait Waittill=new WebDriverWait(driver,20);
        SearchTextBox=Waittill.until(ExpectedConditions.elementToBeClickable(SearchTextBox));
        SearchTextBox.sendKeys(text);
        logger.info("value entered in the search box");

    }
public void Click_Search_Btn()
{
    searchBtn.click();
    logger.info("search button is clicked");
}

public void Click_On_Hamburger_Menu()
{
    DropDownList.click();
    logger.info("Click on DropDownList menu");
}

public void validate_Page_Title(String ExpectedTitle)
{
    WebDriverWait Wait=new WebDriverWait(driver,20);
    boolean b=Wait.until(ExpectedConditions.titleContains(ExpectedTitle));
    Assert.assertEquals("Title Validation",true,b);
    logger.info(" Page title matched" + ExpectedTitle);
}

public void Validate_Present_in_Header_section(String text) throws Exception
{
    boolean b=false;
    switch (text.toLowerCase().trim())
    {
        case "Amazon prime logo":
            b=Logo.isDisplayed();
            break;

        case "hamburger menu":
            b=DropDownList.isDisplayed();
            break;

        case "Returns and Order":
            b= ReturnsAndOrders.isDisplayed();
            break;

        case "Try Prime":
            b= TryPrime.isDisplayed();
            break;

        case "Cart":
            b= Cart.isDisplayed();
            break;

        default:
            logger.fatal("Header link description is not present in the case.Please add the description first");
            throw new Exception("Header link description is not present in the case.Please add the description first");
    }
    if(b) {
        logger.info("Header link is displayed" + text);
        Assert.assertEquals("Header link is displayed", true, b);
    }
    else{
        logger.fatal("Header link is not displayed" +text);
        Assert.fail("header link is not displayed"+text);
    }
}
}
