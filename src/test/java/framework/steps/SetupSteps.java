package framework.steps;

import framework.utils.TestData;
import framework.utils.Variables;

import io.restassured.RestAssured;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.ScenarioType;

public class SetupSteps {
    @BeforeScenario(uponType = ScenarioType.ANY)
    public static void resetVariables() {
        initTestData();
        initRestClient(TestData.getBaseApiUri());
    }

    private static void initTestData() {
        Variables.reset();
    }

    private static void initRestClient(final String baseUri) {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = baseUri;
    }
}
