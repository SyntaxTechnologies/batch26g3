package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features/",
        glue="steps",
        dryRun=false,
        tags = "@create_employee_login or @edit-personal-details",
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/jsonReports/cucumber.json"}

)
public class Testrunner {
}
