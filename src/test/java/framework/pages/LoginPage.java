package framework.pages;

import framework.model.Persona;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AnyPage {

    @FindBy(id = "email")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    private final By LOGIN_BUTTON_BY = By.xpath("//button[@type='submit']");

    private static final String SCRIPT_WITH_USER_INFO_XPATH_TEMPLATE = "//script[contains(., '%s')]";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return isElementPresent(LOGIN_BUTTON_BY);
    }

    public void enterCredentials(Persona persona) {
        enterCredentials(persona.getLogin(), persona.getPassword());
    }

    private void enterCredentials(final String login, final String password) {
        waitFor(loginInput);
        typeInto(loginInput, login);
        typeInto(passwordInput, password);
    }

    public void submitCredentials() {
        getLoginButton().click();
    }

    public boolean isPersonaLogged(Persona persona) {
        String email = persona.getLogin();
        return isElementPresent(
                By.xpath(
                        String.format(SCRIPT_WITH_USER_INFO_XPATH_TEMPLATE, email)
                )
        );
    }

    private WebElement getLoginButton() {
        return getDriver().findElement(LOGIN_BUTTON_BY);
    }
}
