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

    protected void waitUntilClickable(final By by) {
        waitUntilClickable(getDriver().findElement(by));
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

    // --- clicks ---
    protected void clickWithAction(final WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).click().perform();
    }

    protected void doubleClick(final WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).doubleClick().perform();
    }

    protected void clickWithJS(final WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    // --- sending keys and scrolling ---
    protected void sendEnterToElement(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    protected void sendSpaceToElement(WebElement element) {
        element.sendKeys(Keys.SPACE);
    }

    public void pageDown() {
        getDriver().findElement(By.xpath("/*")).sendKeys(Keys.PAGE_DOWN);
    }

    protected void scrollElementIntoMiddle(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        ((JavascriptExecutor) getDriver()).executeScript(scrollElementIntoMiddle, element);
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

    public void waitForPageToLoad() {
        new WebDriverWait(getDriver(), getSerenityTimeoutSec()).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForPageUrl(final String uriFraction) {
        waitForCondition().until(ExpectedConditions.urlContains(uriFraction));
    }

    public boolean currentUrlEndsWith(final String uriFraction) {
        return getDriver().getCurrentUrl().endsWith(uriFraction);
    }

    public boolean currentUrlContains(final String uriFraction) {
        return getDriver().getCurrentUrl().contains(uriFraction);
    }

    // --- elements actions ---
    protected boolean isElementPresent(By by) {
        return !getDriver().findElements(by).isEmpty();
    }

    protected Select getSelectBy(By by) {
        return new Select(getDriver().findElement(by));
    }

    protected boolean isCheckboxSet(WebElement checkbox) {
        return checkbox.isSelected();
    }

    protected String getAngularElementText(WebElement element) {
        return element.getAttribute("value");
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
