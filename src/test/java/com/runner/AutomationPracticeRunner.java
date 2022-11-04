package com.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/AutomationPractice.feature", glue = "com.stepDefinition",
monochrome = true, dryRun = false, tags = "@WebTable", strict = true, plugin = {
		/*"html:target/HTMLRepsort"*/ "json:target/BDD-Report/cucumber.json", "pretty", "html:target/BDD-Report/cucumber.html","com.cucumber.listener.ExtentCucumberFormatter:target/BDD-Report/HTML-DashboardReport.html"})
 
public class AutomationPracticeRunner { 	 

}
 