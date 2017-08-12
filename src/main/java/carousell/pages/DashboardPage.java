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
public class DashboardPage extends BasePage{

    private AppiumDriver driver ;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cars']")
    private WebElement carListingType;

    public DashboardPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10,
                TimeUnit.SECONDS), this);
        this.driver = driver;
    }

    public ListingPage clickCarListingType(){
        Logger.getAnonymousLogger().log(Level.INFO, "click on car listing");
        waitForElementToBeVisible(carListingType);
        carListingType.click();
        return new ListingPage(driver);
    }
}
