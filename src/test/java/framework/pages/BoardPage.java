package framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import java.awt.image.BufferedImage;

public class BoardPage extends AnyPage {
    @FindBy(id = "active_users_layer")
    private WebElement activeUsersCanvas;

    private final int A_SEC = 1000;

    private final int POINT_1_X = 50;
    private final int POINT_1_Y = 50;
    private final int POINT_2_X = 200;
    private final int POINT_2_Y = 200;

    public BoardPage(WebDriver driver) {
        super(driver);
    }

    public BoardToolbar getLeftToolbar() {
        return new BoardToolbar(getDriver());
    }

    public boolean isRendered() {
        return getLeftToolbar().isRendered();
    }

    public BufferedImage getCanvasImage() {
        return new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(getDriver())
                .getImage();
    }

    public void createGreenStickerWithText(final String text) {
        getLeftToolbar().createGreenSticker();
        pauseFor(A_SEC);
        clickCanvasCoordinates(POINT_1_X, POINT_1_Y);
        setText(text);
        pauseFor(A_SEC);
        clickCanvasCoordinates(POINT_2_X, POINT_2_Y);
    }

    protected void clickCanvasCoordinates(final int xOffset, final int yOffset) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(activeUsersCanvas, xOffset, yOffset).click().perform();
    }

    protected void setText(final CharSequence... text) {
        getDriver().switchTo().activeElement().sendKeys(text);
    }
}
