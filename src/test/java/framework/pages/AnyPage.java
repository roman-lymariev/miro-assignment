package framework.pages;

import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AnyPage extends PageObject {

    @Managed
    private WebDriver driver;

    private static int serenityTimeout;

    public AnyPage(final WebDriver driver) {
        super(driver);

        if (driver == null) {
            throw new NullPointerException("WebDriver is null.");
        }

        serenityTimeout = getSerenityTimeoutSec();
    }

    // --- safe fluent waits ---
    protected void waitUntilClickable(final WebElement element) {
        safeFluentWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilVisible(WebElement element) {
        safeFluentWait().until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitUntilVisible(By by) {
        waitUntilVisible(getDriver().findElement(by));
    }

    protected void waitUntilNotVisible(WebElement element) {
        safeFluentWait().until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitUntilNotVisible(By by) {
        waitUntilNotVisible(getDriver().findElement(by));
    }

    // --- page actions ---
    public void deeplinkTo(final String url) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("path is null or empty.");
        }

        getDriver().get(url);
        final String currentUrl = getDriver().getCurrentUrl();

        if (currentUrl == null || currentUrl.isEmpty()) {
            throw new IllegalStateException("The current url is null or empty.");
        }
    }

    // --- elements actions ---
    protected boolean isElementPresent(By by) {
        return !getDriver().findElements(by).isEmpty();
    }

    private int getSerenityTimeoutSec() {
        int defaultValue = 15;
        return SystemEnvironmentVariables
                .createEnvironmentVariables()
                .getPropertyAsInteger(
                        ThucydidesSystemProperty.WEBDRIVER_TIMEOUTS_IMPLICITLYWAIT, defaultValue);
    }

    public void pauseFor(int milliseconds) {
        getClock().pauseFor(milliseconds);
    }

    private FluentWait<WebDriver> safeFluentWait() {
        return new WebDriverWait(getDriver(), serenityTimeout)
                .ignoring(StaleElementReferenceException.class);
    }
}
