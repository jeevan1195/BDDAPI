package step_definition;

import cucumber.api.java.Before;

public class Hooks {

    @Before("@ADDPLACE2")
    public void beforeScenario(){
        // All pre conditions can be added here
    }
}
