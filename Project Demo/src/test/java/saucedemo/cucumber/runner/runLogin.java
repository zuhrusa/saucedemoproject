package saucedemo.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/saucedemo/java/cucumber/feature",
        glue = "saucedemo.cucumber.stepDev",
        pulgin = {"html:target/HTML_report.html"}
)

public class runLogin {
}
