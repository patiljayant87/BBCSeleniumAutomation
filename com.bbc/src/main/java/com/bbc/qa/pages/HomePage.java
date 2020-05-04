package com.bbc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bbc.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(id="idcta-statusbar")
	WebElement signInLnk;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void signIn() {
		signInLnk.click();
	}

}
