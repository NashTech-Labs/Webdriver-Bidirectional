package stepDefintions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
        //path of feature file
        features = "src/test/resources",
        //path of step definition file
        glue = "stepDefintions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        }
//        monochrome = true
)
public class TestRunner {
}
