package framework.pages;

import framework.utils.selenium.ByAutotestId;
import framework.utils.selenium.ByPluginId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardToolbar extends AnyPage {

    private final By BOARD_TOOLBAR = By.className("board-toolbar");
    private final By NEW_STICKER_BUTTON = new ByPluginId("STICKERS");
    private final By GREEN_COLOR_SELECTOR_CHILD = new ByAutotestId("sticker-panel__item-#93d275");

    BoardToolbar(WebDriver driver) {
        super(driver);
    }

    public boolean isRendered() {
        waitForRenderedElements(BOARD_TOOLBAR);
        return true;
    }

    public void createGreenSticker() {
        clickNewStickerButton();

        selectGreenStickerColor();
    }

    private void clickNewStickerButton() {
        waitUntilVisible(NEW_STICKER_BUTTON);
        getDriver().findElement(NEW_STICKER_BUTTON).click();
    }

    private void selectGreenStickerColor() {
        waitUntilVisible(GREEN_COLOR_SELECTOR_CHILD);
        getDriver().findElement(GREEN_COLOR_SELECTOR_CHILD).findElement(By.xpath("..")).click();
        waitUntilNotVisible(GREEN_COLOR_SELECTOR_CHILD);
    }
}
