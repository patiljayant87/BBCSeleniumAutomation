package com.facebook.Pages;

import java.io.IOException;

import com.facebook.Page.MasterPage;

public class LoginPage extends MasterPage{
	//login, signUp, forgotPassword, languageChange etc.
	
	public LoginPage() throws IOException {
		super();
	}

	public boolean doLogin(String uname, String passwd)
	{
		
		//userName
		sendKeys("userNameTxtBox",uname );
		//password
		sendKeys("passwdTxtBox",passwd);
		
		//click on login
		click("loginBtn");
	return(isLinkPresent("FindFriendsHprLnk"));
		/*Boolean result=isLinkPresent("FindFriendsHprLnk");
		return result;*/
	}

	public void signUp()
	{
		
		System.out.println("this method will create new account");
	}
}





















