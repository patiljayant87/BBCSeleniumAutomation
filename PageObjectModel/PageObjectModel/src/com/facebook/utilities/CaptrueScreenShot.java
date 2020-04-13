package com.facebook.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptrueScreenShot {

	public static void screenShot(WebDriver driver, String TCName) throws IOException
	{
		//JavascriptExecutor jse =(JavascriptExecutor) driver;
		TakesScreenshot ts       = (TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/"+TCName+".png"));
		
	}
}















