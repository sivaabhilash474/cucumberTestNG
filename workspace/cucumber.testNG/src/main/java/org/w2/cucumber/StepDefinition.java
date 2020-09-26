package org.w2.cucumber;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.w2.selnium.utilities.LogUtils;
import org.w2.selnium.utilities.ScenarioHelper;
import org.w2.selnium.utilities.TakeScreenShot;
import org.w2.selnium.utilities.WebDriverUtils;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinition {
	static Logger log = Logger.getLogger(StepDefinition.class.getName());
	
	
	public static void main(String[] args) throws IOException {
		log.info("log info..");
		
		TakeScreenShot.takeScreenShot(WebDriverUtils.getWebDriver(), "\\cucumber.testNG\\target");
		
	}
	
	@Given("^Navigated to login page$")
	public void navigated_to_login_page() throws Throwable {
		CucumberSteps scenario = new CucumberSteps();
		scenario.getScenarioName();
//		WebDriverUtils.getWebDriver().get("https://www.facebook.com");
		WebDriverUtils.getWebDriver().get("https://www.google.com");
		LogUtils.logInfo("Successfully Navigated to the website", true);
//		TakeScreenShot.takeScreenShot(WebDriverUtils.getWebDriver(), "/cucumber.testNG/target");
	    System.out.println("@Given------navigated to login");
	    
	    
	}

	@When("^user entered \"([^\"]*)\" username$")
	public void user_entered_valid_username(String username) throws Throwable {
		 System.out.println("@when------entered "+username+" username");
	}

	@When("^user enetered \"([^\"]*)\" password$")
	public void user_enetered_valid_password(String password) throws Throwable {
		 System.out.println("@when------entered "+password+" password");
	}
	
	@When("^user selects the age category$")
	public void user_selects_the_age_category(DataTable table) throws Throwable {
		 List<Map<String,String>> data = table.asMaps(String.class, String.class); 
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		System.out.println("@when-------user select the age category: "+data.get(0).get("Age")+" and country: "+data.get(1).get("Country"));
	    
	}

	
	@Then("^user \"([^\"]*)\" be able to goto homepage$")
	public void user_should_be_able_to_goto_homepage(String able) throws Throwable {
		 System.out.println("@then------user "+able+" go to homepage");
		
	}

	
	
	
	
}
