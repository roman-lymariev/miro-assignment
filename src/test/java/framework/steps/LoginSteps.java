package framework.steps;

import framework.model.Persona;
import framework.pages.AnyPage;
import framework.pages.LoginPage;
import framework.utils.TestData;
import org.jbehave.core.annotations.Given;

import static org.junit.Assert.assertTrue;

public class LoginSteps extends BrowserSteps {
    protected AnyPage anyPage;
    protected LoginPage loginPage;

    @Given("user $personaId logs in")
    public void loginAs(final String personaId) {
        Persona persona = TestData.getPersonaById(personaId);

        anyPage.deeplinkTo(TestData.getLoginUrl());
        assertTrue("Login page is not opened!", loginPage.isOpened());

        loginPage.enterCredentials(persona);
        loginPage.submitCredentials();

        assertTrue("Persona is not logged: ".concat(personaId), loginPage.isPersonaLogged(persona));
    }
}
