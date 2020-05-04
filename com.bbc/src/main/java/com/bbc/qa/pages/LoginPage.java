package com.bbc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bbc.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="submit-button")
	WebElement signInBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void signIn(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		signInBtn.click();
	}

}
