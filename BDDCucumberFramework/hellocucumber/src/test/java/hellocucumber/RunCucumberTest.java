package hellocucumber;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/hellocucumber/",
glue={"hellocucumber"},
tags="@Smoke",
monochrome=true,
plugin={"pretty","html:target/reports",
        "pretty","json:target/JSonReports/cucumber.json",
        "pretty","junit:target/JUnitReports/cucumber.xml"}
)

public class RunCucumberTest {
}
