package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;

public class CmnPageObject {
    private static final Logger logger = LogManager.getLogger(CmnPageObject.class);
    WebDriver driver;
    private By search_Text_Box = By.id("twotabsearchtextbox");
    private By Search_Btn = By.xpath("//input[@Value = 'Go']");
    private By DroppDownList = By.id("nav-hamburger-menu");
    private By Nav_Link_logo = By.xpath("//a[@class='nav-logo-link']");
    private By Nav_Link_Cart = By.id("nav-cart");
    private By Nav_Link_prime = By.id("nav-link-prime");
    private By Nav_Link_Orders = By.id("nav-orders");
    private By Nav_Link_Account = By.id("nav-link-accountList");

    private String hamburger_menu_category_link_xpath =  "//div[@id='hmenu-content']//div[text()='%s']";
    private String hamburger_menu_sub_category_link_xpath =  "//div[@id='hmenu-content']//a[text()='%s']";

    public CmnPageObject(WebDriver driver) {
        this.driver = driver;

    }
    public void Search_Text_box(String text) {
        WebDriverWait Waittill = new WebDriverWait(driver,20);
        WebElement Elements_Srch_Box = Waittill.until(ExpectedConditions.elementToBeClickable(search_Text_Box));
        Elements_Srch_Box.sendKeys(text);
        logger.info(" Value Enterted in Search Box" + text);
    }
    public void Search_Btn() {
        driver.findElement(Search_Btn).click();
        logger.info("Search button Clicked" );

    }
    public void Click_On_Hmenu_Button() {
        driver.findElement(DroppDownList).click();
        logger.info("Clicked on Hamburger Menu");
    }
    public void Click_On_Hmenu_Category_Link(String linkText) {
        By byElement = By.xpath(String.format(hamburger_menu_category_link_xpath,linkText));
        driver.findElement(byElement);
        logger.info("Clicked on Hmburger menu Cetogories" + linkText);

    }
    public void Click_on_Hmenu_Sub_Category_Menu_Link(String linkText) {
        By byElement = By.xpath(String.format(hamburger_menu_sub_category_link_xpath, linkText));
        driver.findElement(byElement).click();
        logger.info("Clicked on Humburger Sub-Menu" + linkText);
    }
    public void Validetion_Hamburger_Menu_Displeyed() {
        boolean b = driver.findElement(DroppDownList).isDisplayed();
        Assert.assertEquals("Hamburger menu Link",true, b);
    }
    public void Validate_Amazon_Logo() {
        boolean b = driver.findElement(Nav_Link_logo).isDisplayed();
        Assert.assertEquals("Navigation Link Logo", true, b);

    }
    public void Validate_pageTitle(String ExectedTitle) {
        WebDriverWait Wait = new WebDriverWait(driver,20);
        boolean b = Wait.until(ExpectedConditions.titleContains(ExectedTitle));
        Assert.assertEquals("Title Validation", true, b);
        logger.info("Page Title Mactched" + ExectedTitle);
    }

    public void ValidatePresentInHeaderSection(String text) throws Exception
    {
        boolean b = false;
        switch(text.toLowerCase().trim())
        {
            case "hamburger menu":
                b = driver.findElement(DroppDownList).isDisplayed();
                break;
            case "Amazon prime logo":
                b = driver.findElement(Nav_Link_logo).isDisplayed();
                break;
            case "Account And list link":
                b = driver.findElement(Nav_Link_Account).isDisplayed();
                break;
            case "Return And Orders":
                b = driver.findElement(Nav_Link_Orders).isDisplayed();
                break;
            case "your Prime Link":
                b= driver.findElement(Nav_Link_prime).isDisplayed();
                break;
            case "Cart link":
                b = driver.findElement(Nav_Link_Cart).isDisplayed();
                break;
            case "Search Text box":
                b = driver.findElement(search_Text_Box).isDisplayed();
                break;
            default:
                logger.fatal("Header Link Description is not present in the case. Please add link description first.");
                throw new Exception("Header Link Description is not present in the case. Please add link description first.");
        }
        if(b) {
            logger.info("Header link is Displayed" + text);
            Assert.assertEquals("Header Link displayed",true, b);
        }else {
            logger.fatal("Header Link is not displayed: " + text);
            Assert.fail("Header Link is not displayed: " + text);
        }
    }
}

