package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\dev01\\eclipse-workspace\\Poc\\src\\main\\java\\FeatureFile\\feat.feature", glue = {
		"Stepdefination" })
public class RunnerClass {

}
