package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Cucumber_Project\\CUCUMBER_POC\\src\\main\\java\\FeatureFile\\feat.feature", glue = {
		"Stepdefination"},tags={"@Test2"})
//tags= {"@Test1"}
public class RunnerClass {

}
