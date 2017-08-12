package carousell.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rajeevranjan on 11/08/17.
 */
public class OfferPage extends BasePage{

    private final AppiumDriver driver ;

    @AndroidFindBy(id = "text_buy")
    private WebElement buyOffer;

    @AndroidFindBy(id = "feature_button")
    private WebElement featureButton;

    public OfferPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10,
                TimeUnit.SECONDS), this);
        this.driver = driver;
    }

    public ConfirmOfferPage clickOffer(){
        Logger.getAnonymousLogger().log(Level.INFO, "click on buy now button");
        waitForElementToBeVisible(buyOffer);
        buyOffer.click();
        return new ConfirmOfferPage(driver);
    }

    public OfferPage clickFeatureButton(){
        Logger.getAnonymousLogger().log(Level.INFO, "click on Ok Got It button");
        clickFeatureButton(featureButton);
        return new OfferPage(driver);
    }
}
