package com.facebook.Page;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MasterPage {
	public static WebDriver driver;
	public Properties prop;

	public MasterPage() throws IOException//constructor
	{
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\facebook\\Property\\OR.properties");
		prop = new Properties();
		prop.load(ip);
		if(prop.getProperty("browserName").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium Java - Assignments\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(prop.getProperty("browserName").equalsIgnoreCase("IE"))
		{
			System.out.println("open IE");
		}
		else
		{
	driver = new FirefoxDriver();
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.facebook.com");
	}
	
public void sendKeys(String xpathKey,String userData)
{
	driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(userData);
}

public void click(String xpathKey)
{
	driver.findElement(By.xpath(prop.getProperty(xpathKey))).click();
}

public boolean isLinkPresent(String xpathKey)
{
	try
	{
		driver.findElement(By.xpath(prop.getProperty(xpathKey)));
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
}

}
































