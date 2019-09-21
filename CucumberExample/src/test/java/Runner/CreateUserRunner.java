package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features/OracleCreateUser.feature", glue="StepDefinition")
public class CreateUserRunner {

}
