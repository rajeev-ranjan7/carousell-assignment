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
public class ListingPage extends BasePage{
    private final AppiumDriver driver ;

    @AndroidFindBy(id = "feature_button")
    private WebElement featureButton;

    public ListingPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10,
                TimeUnit.SECONDS), this);
        this.driver = driver;
    }

    public OfferPage clickListing(String index){
        Logger.getAnonymousLogger().log(Level.INFO, String.format("click on %s index listing", index));
        WebElement listing = getPageElement("xpath", "//android.widget.LinearLayout[@resource-id='com.thecarousell.Carousell:id/view_product' and @index='%p']", index);
        waitForElementToBeVisible(listing);
        listing.click();
        return new OfferPage(driver);
    }

    public ListingPage clickFeatureButton(){
        Logger.getAnonymousLogger().log(Level.INFO, "click on Ok Got It button");
        clickFeatureButton(featureButton);
        return new ListingPage(driver);
    }
}
