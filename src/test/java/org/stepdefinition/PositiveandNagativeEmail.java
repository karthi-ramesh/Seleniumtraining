package org.stepdefinition;

import org.basecls.BaseClass;
import org.pojo.EmailPojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PositiveandNagativeEmail extends BaseClass {
	EmailPojo e;
	@Given("To lanch the chrome browser and maximise window")
	public void to_lanch_the_chrome_browser_and_maximise_window() {
	  LanchBrowser();
	  WindowMaximize();
	}

	@When("To lanch the url of the email application")
	public void to_lanch_the_url_of_the_email_application() {
	  lanchUrl("https://webmail.au.syrahost.com/");
	}

	@When("To pass valid username name in email field")
	public void to_pass_valid_username_name_in_email_field() {
	   e = new EmailPojo();
	   passText("kasmora", e.getEmail());
	}

	@When("To pass valid password in password field")
	public void to_pass_valid_password_in_password_field() {
		e = new EmailPojo();
		passText("karthi", e.getPassword());
	}

	@When("To click the next button")
	public void to_click_the_next_button() {
		e = new EmailPojo();
		clickBtn(e.getLogin());
	}

	@When("To check whether navigate to the page or not")
	public void to_check_whether_navigate_to_the_page_or_not() {
	   System.out.println("check the credentials");
	}

	@Then("To close the Browser")
	public void to_close_the_Browser() {
	   closeEntireBrowser();
	}
}
