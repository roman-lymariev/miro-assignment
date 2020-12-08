package framework.steps;

import framework.pages.*;

import net.serenitybdd.core.Serenity;
import org.jbehave.core.annotations.Then;

public class BrowserSteps {
    protected AnyPage anyPage;

    @Then("screenshot is taken")
    public void takeScreenshot() {
        Serenity.takeScreenshot();
    }
}
