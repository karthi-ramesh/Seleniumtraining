package org.pojo;


import java.sql.Driver;

import org.basecls.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPojo extends BaseClass {


	public EmailPojo() {
	PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="login")
	private WebElement log;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement mail;
	
	
	public WebElement getEmail() {
		return log;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return mail;
	}
	
	
}

