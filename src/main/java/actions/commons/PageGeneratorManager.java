package actions.commons;

import org.openqa.selenium.WebDriver;

import actions.pageObjects.AssetTokenDetail;
import actions.pageObjects.AssetTokenGidView;
import actions.pageObjects.CarbonCreditDetail;
import actions.pageObjects.CarbonCreditGridView;
import actions.pageObjects.CarbonCreditPayment;
import actions.pageObjects.HomePageObject;
import actions.pageObjects.Register;


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

    public static Register getRegisterPage(WebDriver driver){
        return new Register(driver);

    }

    public static CarbonCreditPayment getCarbonCreditPaymentPage(WebDriver driver){
        return new CarbonCreditPayment(driver);

    }

}
