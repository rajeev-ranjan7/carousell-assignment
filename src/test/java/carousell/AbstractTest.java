package carousell;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rajeevranjan on 11/08/17.
 */
public class AbstractTest {

    AppiumDriver driver ;

    AppiumDriver getDriver() throws MalformedURLException {
        Logger.getAnonymousLogger().log(Level.INFO, "Setting up driver capabilites");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        /* Here we specify the capabilities required by the Appium server.
             * We have already manually specified most of these through the
             * Appium server interface (apk path etc.). */
        capabilities.setCapability("deviceName", "note");
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
