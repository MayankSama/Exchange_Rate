
package runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "functionalTests/End2End_Testing.feature",
        glue = {"stepDefinitions/TestStep"},
        monochrome = true,
        strict = true)
public class TestRunner {
	
}