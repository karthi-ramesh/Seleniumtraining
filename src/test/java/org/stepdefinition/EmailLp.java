package org.stepdefinition;

import org.basecls.BaseClass;
import org.pojo.EmailPojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmailLp extends BaseClass {
	EmailPojo e;

	@Given("user has to launch the browser and maximise window")
	public void user_has_to_launch_the_browser_and_maximise_window() {
	   LanchBrowser();
	   WindowMaximize();
	}

	@When("User has to hit the email url")
	public void user_has_to_hit_the_email_url() {
	  lanchUrl("https://webmail.au.syrahost.com/");
	}

	@When("User has to Pass the data{string} in email field")
	public void user_has_to_Pass_the_data_in_email_field(String em) {
	    e = new EmailPojo();
	    passText(em, e.getEmail());
	}

	@When("User has to pass the data {string}in password field")
	public void user_has_to_pass_the_data_in_password_field(String pass) {
		 e = new EmailPojo();
		 passText(pass, e.getPassword());
	}

	@When("User has to login button")
	public void user_has_to_login_button() {
		 e = new EmailPojo();
		 clickBtn(e.getLogin());
	}

	@Then("User has to close the browser")
	public void user_has_to_close_the_browser() {
	   closeEntireBrowser();
	}


}
