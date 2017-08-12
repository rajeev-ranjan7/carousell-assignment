package carousell.checker;

import carousell.pages.OfferChatPage;
import org.testng.Assert;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rajeevranjan on 11/08/17.
 */
public class OfferChatPageChecker {

    private OfferChatPage page;

    public OfferChatPageChecker(OfferChatPage page){
        this.page = page;
    }

    public OfferChatPage getPage(){
        return page;
    }

    public OfferChatPage editOfferAvailable(boolean isAvailable){
        Logger.getAnonymousLogger().log(Level.INFO, "verifing edit offer button is present");
        Assert.assertEquals(isAvailable, getPage().editOffer.isDisplayed());
        return getPage();
    }

    public OfferChatPage cancelOfferAvailable(boolean isAvailable){
        Logger.getAnonymousLogger().log(Level.INFO, "verifing cancel offer button is present");
        Assert.assertEquals(isAvailable, getPage().cancelOffer.isDisplayed());
        return getPage();
    }
}
