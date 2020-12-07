package framework.steps;

import framework.model.Persona;
import framework.pages.AnyPage;
import framework.pages.BoardPage;
import framework.pages.LoginPage;
import framework.utils.TestData;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertTrue;

public class UiSteps extends BrowserSteps {
    protected AnyPage anyPage;
    protected LoginPage loginPage;
    protected BoardPage board;

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
    }

    @When("the user creates a sticker from the widget toolbar")
    public void createGreenSticker() {
        board.createGreenStickerWithText("Wubba Lubba Dub Dub!");
    }

    public void closeDriver() {
        anyPage.getDriver().close();
    }
}
