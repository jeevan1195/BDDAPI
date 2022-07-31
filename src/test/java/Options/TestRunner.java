package Options;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/java/features",
        glue = "step_definition",
        tags = "@ADDPLACE2"
)
public class TestRunner {

}
