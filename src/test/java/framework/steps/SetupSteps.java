package framework.steps;

import framework.utils.TestData;
import framework.utils.Variables;

import org.jbehave.core.annotations.BeforeStories;

public class VariablesSteps {
    @BeforeStories
    public static void resetVariables() {
        Variables.reset();
        TestData.getBaseApiUri();
    }
}
