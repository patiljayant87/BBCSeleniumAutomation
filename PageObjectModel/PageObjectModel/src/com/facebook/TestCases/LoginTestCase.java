package com.facebook.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.facebook.Page.MasterPage;
import com.facebook.Pages.LoginPage;
import com.facebook.utilities.CaptrueScreenShot;
import com.facebook.utilities.ReadingExcel;

public class LoginTestCase {

	
	@Test(dataProvider="sendData")
	public void login(String UserName, String Password) throws IOException
	{
		if(	ReadingExcel.isTCrunnable("LoginTestCase") )
		{
			LoginPage lp = new LoginPage();
			Assert.assertTrue(lp.doLogin(UserName,Password));	
			
		}
	}

@DataProvider(parallel=true)
public Object[][] sendData() throws IOException
{
	return (ReadingExcel.readUserData("TestData"));
}

@AfterMethod
public void postmaterm(ITestResult result) throws IOException
{
	if(ITestResult.FAILURE==result.getStatus())
	{
		CaptrueScreenShot.screenShot(MasterPage.driver, result.getName());
	}
}


}


























