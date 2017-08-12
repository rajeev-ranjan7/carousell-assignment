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
public class ConfirmOfferPage extends BasePage{

    private final AppiumDriver driver ;

    @AndroidFindBy(id = "action_submit")
    private WebElement confirm;

    @AndroidFindBy(id = "button1")
    private WebElement yes;

    public ConfirmOfferPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10,
                TimeUnit.SECONDS), this);
        this.driver = driver;
    }

    public OfferChatPage confirmOffer(){
        Logger.getAnonymousLogger().log(Level.INFO, "confirm offer");
        waitForElementToBeVisible(confirm);
        confirm.click();
        yes.click();
        return new OfferChatPage(driver);
    }

}
