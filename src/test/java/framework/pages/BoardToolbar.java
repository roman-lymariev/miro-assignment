package framework.pages;

import framework.utils.selenium.ByAutotestId;
import framework.utils.selenium.ByPluginId;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardToolbar extends PageObject {

    private By newStickerButton = new ByPluginId("STICKERS");
    private By greenColorSelectorChild = new ByAutotestId("sticker-panel__item-#93d275");

    BoardToolbar(WebDriver driver) {
        super(driver);
    }

    public void createGreenSticker() {
        clickNewStickerButton();

        selectGreenStickerColor();
    }

    private void clickNewStickerButton() {
        waitForRenderedElements(newStickerButton);
        getDriver().findElement(newStickerButton).click();
    }

    private void selectGreenStickerColor() {
        waitForRenderedElements(greenColorSelectorChild);
        getDriver().findElement(greenColorSelectorChild).findElement(By.xpath("..")).click();
        waitForRenderedElementsToDisappear(greenColorSelectorChild);
    }
}
