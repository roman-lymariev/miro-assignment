package framework.steps;

import framework.model.Persona;
import framework.pages.AnyPage;
import framework.pages.BoardPage;
import framework.pages.LoginPage;
import framework.utils.TestData;
import net.serenitybdd.core.Serenity;
import org.hamcrest.MatcherAssert;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.awt.image.BufferedImage;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertTrue;

public class UiSteps extends BrowserSteps {
    protected AnyPage anyPage;
    protected LoginPage loginPage;
    protected BoardPage board;

    private static final int ACCEPTABLE_SHADOWS_DIFF = 3000;

    @Given("user $personaId logs in")
    public void loginAs(final String personaId) {
        Persona persona = TestData.getPersonaByName(personaId);

        anyPage.deeplinkTo(TestData.getLoginUri());
        assertTrue("Login page is not opened!", loginPage.isOpened());

        loginPage.enterCredentials(persona);
        loginPage.submitCredentials();

        assertTrue("Login failed for: ".concat(personaId), loginPage.isPersonaLogged(persona));
    }

    @Given("the board is opened by View Link")
    @When("the user opens the board via View Link")
    public void deeplinkToViewBoard() {
        anyPage.deeplinkTo(TestData.getBoardViewLink());

        assertTrue("Board failed to render correctly", board.isRendered());
    }

    @When("the user creates a sticker from the widget toolbar")
    public void createGreenSticker() {
        board.createGreenStickerWithText("Wubba Lubba Dub Dub!");
    }

    @Then("the sticker is displayed")
    public void takeCanvasScreenshotAndCompareWithPrevious() {
        Serenity.takeScreenshot();

        BufferedImage actualImage = board.getCanvasImage();
        BufferedImage expectedImage = TestData.getExpectedImage("sticker_is_displayed.png");

        ImageDiff imageDifference = new ImageDiffer().makeDiff(expectedImage, actualImage);

        //Compare images with allowed level of difference
        MatcherAssert.assertThat(imageDifference.getDiffSize(), is(lessThan(ACCEPTABLE_SHADOWS_DIFF)));
    }
}
