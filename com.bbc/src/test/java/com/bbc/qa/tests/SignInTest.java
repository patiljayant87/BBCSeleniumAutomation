package com.bbc.qa.tests;

import com.bbc.qa.base.TestBase;
import com.bbc.qa.pages.LoginPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest extends TestBase {
	LoginPage loginPage;
	
	public SignInTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void signIn() {
		loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
