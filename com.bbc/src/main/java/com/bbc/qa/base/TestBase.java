package com.bbc.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bbc.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
		prop=new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("C:\\Users\\jayant.patil\\git\\BBCSeleniumAutomation\\com.bbc\\src\\main\\java\\"
				+"com\\bbc\\qa\\config\\config.properties"));
		prop.load(ip);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browsername = prop.getProperty("browser");
		if(browsername.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\jayant.patil\\Desktop\\Test\\Softwares\\chromedriver_win32");
			driver = new ChromeDriver();
		}
		else if(browsername.contentEquals("firefox")){
			System.setProperty("webdriver.gecko.driver", "IE Path");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
