package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"src/test/resources/features/AccountPage.feature"},
			glue = {"stepDefinitions", "appHooks"},
			plugin = {"pretty"},
			monochrome = true
		)

public class MyTestRunner {

}
