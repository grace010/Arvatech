package actions.pageObjects;

import org.openqa.selenium.WebDriver;

import actions.commons.*;

public class HomePageObject extends BasePage{
    WebDriver driver;
    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }
    public void hoverMarketPlaceTab() {
        waitForElementVisible(driver, null);
        
    }
    public void clickToCarbonCreditButton() {
    }
    
}
