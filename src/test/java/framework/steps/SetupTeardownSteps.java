package framework.steps;

import framework.utils.TestData;
import framework.utils.Variables;

import io.restassured.RestAssured;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.ScenarioType;

public class SetupTeardownSteps {
    @BeforeScenario(uponType = ScenarioType.ANY)
    public static void setup() {
        initTestData();
        initRestClient(TestData.getBaseApiUri());
    }

    @AfterStories
    public static void teardown() {
    }

    private static void initTestData() {
        Variables.reset();
    }

    private static void initRestClient(final String baseUri) {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = baseUri;
    }
}
