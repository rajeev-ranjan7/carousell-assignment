package carousell;

import carousell.pages.AppPage;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

/**
 * Created by rajeevranjan on 11/08/17.
 */
public class CarOfferTest extends AbstractTest{

    AppiumDriver driver ;

    @BeforeTest
    public void setup() throws MalformedURLException {
        driver = getDriver();
    }

    @Test
    @Parameters({"username", "password", "purchaseIndex"})
    public void testCarListtingOfferTest(String username, String password, String index){
        AppPage app = new AppPage(driver);
        app
                .clickEmailLogin()
                .loginTab()
                .userName(username)
                .passWord(password)
                .clickLogin()
                .clickCarListingType()
                .clickFeatureButton()
                .clickListing(index)
                .clickFeatureButton()
                .clickFeatureButton()
                .clickOffer()
                .confirmOffer()
                .verify().cancelOfferAvailable(true)
                .verify().editOfferAvailable(true)
                .cancelOffer()
                .confirmCancelOffer();
    }

}
