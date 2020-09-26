package org.w2.cucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty" , "html:target/cucumber.html"},
features="src/main/resources/features/facebooklogin.feature",
glue="org.w2.cucumber",
monochrome = true,
dryRun = false)
public class TestRunner {
}


