package parallel;

import org.testng.annotations.DataProvider;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"@target/failed-rerun.txt"},
		glue = {"parallel"},
		plugin = {
				"pretty",
				"rerun:target/failed-rerun.txt"
				},
		monochrome = true
	)
public class FailedTestNGRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
