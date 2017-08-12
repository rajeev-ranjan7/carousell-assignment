package carousell.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by rajeevranjan on 11/08/17.
 */
public class BasePage {

    private static final String PARAMETERS_PATTERN = "%p";
    private AppiumDriver driver ;

    protected  BasePage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10,
                TimeUnit.SECONDS), this);
        this.driver = driver;
    }


    public void waitForElementToBeVisible(WebElement element, int timeToWaitInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickFeatureButton(WebElement element){
        if(element.isDisplayed()){
            element.click();
        }
    }

    public void waitForElementToBeVisible(WebElement element){
        waitForElementToBeVisible(element, 10);
    }

    public WebElement getPageElement(String selector, String locator, String... params){
      WebElement element = driver.findElement(selector, replaceParameters(locator, params));
      return element;
    }

    public static String replaceParameters(String in, String... params) {
        if (params == null || params.length == 0) {
            return in;
        }
        for (String replaceBy : params) {
            if (in.contains(PARAMETERS_PATTERN)) {
                if (replaceBy == null) {
                    throw new IllegalArgumentException("Parameter is null");
                }
                if (replaceBy != null) {
                    in = in.replaceFirst(PARAMETERS_PATTERN, replaceBy);
                }
            }
        }
        return in;
    }
}
