package org.w2.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionProduction {
	@Given("^User is on the login page$")
	public void user_is_on_the_login_page() throws Throwable {
		System.out.println("@Given----production login page");
	    
	}

	@When("^entered valid username$")
	public void entered_valid_username() throws Throwable {
	    
	}

	@When("^entered valid password$")
	public void entered_valid_password() throws Throwable {
	    
	}

	@Then("^user should visit the homepage$")
	public void user_should_visit_the_homepage() throws Throwable {
	    
	}
}
