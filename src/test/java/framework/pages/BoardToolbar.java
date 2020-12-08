package framework.pages;

import framework.utils.selenium.ByAutotestId;
import framework.utils.selenium.ByPluginId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardToolbar extends AnyPage {

    private By boardToolbar = By.className("board-toolbar");
    private By newStickerButton = new ByPluginId("STICKERS");
    private By greenColorSelectorChild = new ByAutotestId("sticker-panel__item-#93d275");

    BoardToolbar(WebDriver driver) {
        super(driver);
    }

    public boolean isRendered() {
        waitForRenderedElements(boardToolbar);
        return true;
    }

    public void createGreenSticker() {
        clickNewStickerButton();

        selectGreenStickerColor();
    }

    private void clickNewStickerButton() {
        waitUntilVisible(newStickerButton);
        getDriver().findElement(newStickerButton).click();
    }

    private void selectGreenStickerColor() {
        waitUntilVisible(greenColorSelectorChild);
        getDriver().findElement(greenColorSelectorChild).findElement(By.xpath("..")).click();
        waitUntilNotVisible(greenColorSelectorChild);
    }
}
