package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.AssetTokenDetail;
import pageObjects.AssetTokenGidView;
import pageObjects.CarbonCreditDetail;
import pageObjects.CarbonCreditGridView;
import pageObjects.HomePageObject;

public class PageGeneratorManager {
    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);

    }

    public static CarbonCreditGridView getCarbonCreditGridViewPage(WebDriver driver){
        return new CarbonCreditGridView(driver);

    }

    public static CarbonCreditDetail getCarbonCreditDetailPage(WebDriver driver){
        return new CarbonCreditDetail(driver);

    }

    public static AssetTokenGidView getAssetTokenGridViewPage(WebDriver driver){
        return new AssetTokenGidView(driver);

    }

    public static AssetTokenDetail getAssetTokenDetailPage(WebDriver driver){
        return new AssetTokenDetail(driver);

    }

}
