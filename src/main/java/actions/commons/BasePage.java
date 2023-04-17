package actions.commons;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    int longTimeout = 30;

    public WebElement getWebElement(WebDriver driver, String locatorType){
        return driver.findElement(getLocatorType(locatorType));
    }

    public void clickToElement(WebDriver driver, String locatorType){
        getWebElement(driver, locatorType).click();
}

    public void hoverToElement(WebDriver driver, String locatorType){
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, locatorType)).perform();
    }

    public String getDynamicLocator(String locatorType, String...restParameter){
        if(locatorType.startsWith("xpath=")){
            locatorType = String.format(locatorType, (Object[]) restParameter);
        }
        return locatorType;
    }

    public By getLocatorType(String locatorType){
        By by = null;
        if(locatorType.startsWith("id=")){
            by = By.id(locatorType.substring(3));
        }
        else if(locatorType.startsWith("class=")){
            by = By.className(locatorType.substring(6));
        }
        else if(locatorType.startsWith("name=")){
            by= By.name(locatorType.substring(5));
        }
        else if(locatorType.startsWith("css=")){
            by = By.cssSelector(locatorType.substring(4));
        }
        else if(locatorType.startsWith("xpath=")){
            by = By.cssSelector(locatorType.substring(6));
        }
        else{
            throw new RuntimeException("locatorType is not supported");
        }

        return by;
    }

    public void waitForElementVisible(WebDriver driver, String locatorType){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorType(locatorType)));
    }
    public void waitForElementVisible(WebDriver driver, String locatorType, String...restParameter){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getLocatorType(getDynamicLocator(locatorType,restParameter))));
    }

    public void waitForElementClickable(WebDriver driver, String locatorType){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getLocatorType(locatorType)));
    }

    public void waitForElementClickable(WebDriver driver, String locatorType, String...restParameter){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getLocatorType(getDynamicLocator(locatorType,restParameter))));
    }

}
