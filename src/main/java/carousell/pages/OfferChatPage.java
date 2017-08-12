package carousell.pages;

import carousell.checker.OfferChatPageChecker;
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
public class OfferChatPage extends BasePage{
    private final AppiumDriver driver ;
    private final OfferChatPageChecker checker;

    @AndroidFindBy(id = "button_chat_left")
    public WebElement cancelOffer;

    @AndroidFindBy(id = "button_chat_right")
    public WebElement editOffer;

    @AndroidFindBy(id = "button1")
    public WebElement confirmCancelOffer;

    public OfferChatPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10,
                TimeUnit.SECONDS), this);
        checker = new OfferChatPageChecker(this);
        this.driver = driver;
    }

    public OfferChatPage cancelOffer(){
        Logger.getAnonymousLogger().log(Level.INFO, "cancel offer");
        cancelOffer.click();
        return this;
    }

    public OfferChatPage confirmCancelOffer(){
        Logger.getAnonymousLogger().log(Level.INFO, "confirm cancel offer");
        waitForElementToBeVisible(confirmCancelOffer);
        confirmCancelOffer.click();
        return this;
    }

    public OfferChatPageChecker verify() {
        return checker;
    }
}
