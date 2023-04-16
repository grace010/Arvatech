package commons;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
protected WebDriver driver;
protected final Log log;
protected BaseTest(){
    log = LogFactory.getLog(getClass());
}


String projectPath = System.getProperty("user.dir");

protected WebDriver getBrowserDriver(String browserName){

    switch (browserName){
        case"firefox":
        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        break;

        case"chrome":
        System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        break;

        case"edge":
        System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
        driver = new EdgeDriver();
        break;

        case"":
        throw new RuntimeException("Browser is not valid");
    }
    driver.get("https://arvatech.sotatek.works/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return driver;
}

    protected int fakeFandomData() {
		Random rand = new Random();
        return rand.nextInt();
	}

}
