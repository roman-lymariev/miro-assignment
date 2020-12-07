package framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

public class BoardPage extends AnyPage {
    @FindBy(id = "active_users_layer")    //canvasContainer")
    protected WebElement activeUsersCanvas;

    public BoardPage(WebDriver driver) {
        super(driver);
    }

    public BoardToolbar getLeftToolbar() {
        return new BoardToolbar(getDriver());
    }

    public void createGreenStickerWithText(final String text) {
        getLeftToolbar().createGreenSticker();
        clickCanvasCoordinates(50, 50);
        setText(text);
        clickCanvasCoordinates(100, 100);
    }

    protected void clickCanvasCoordinates(final int x_offset, final int y_offset) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(activeUsersCanvas, x_offset, y_offset).click().perform();
    }

    protected void clickCanvasCenter() {
        int x_offset = (getCanvasWidth() / 2);
        int y_offset = (getCanvasHeight() / 2);

        clickCanvasCoordinates(x_offset, y_offset);
    }

    protected void clickCanvasBottomCenter() {
        int x_offset = (getCanvasWidth() / 2);
        int y_offset = (getCanvasHeight() - 1);

        clickCanvasCoordinates(x_offset, y_offset);
    }

    protected void setText(final CharSequence... text) {
        getDriver().switchTo().activeElement().sendKeys(text);
    }

    private int getCanvasWidth() {
        return Integer.parseInt(activeUsersCanvas.getAttribute("width"));
    }

    private int getCanvasHeight() {
        return Integer.parseInt(activeUsersCanvas.getAttribute("height"));
    }
}
