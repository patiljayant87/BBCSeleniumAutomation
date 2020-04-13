package com.bbc.regression;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test
	public void login() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jayant.patil\\Desktop\\Test\\Softwares\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.bbc.co.uk/");
		
		driver.findElement(By.id("idcta-username")).click();
		driver.findElement(By.xpath("//input[@id='user-identifier-input']")).sendKeys("patiljayant87@gmail.com");
		driver.findElement(By.id("password-input")).sendKeys("Amir123rdb");
		driver.findElement(By.id("submit-button")).click();
		driver.findElement(By.id("submit-button")).isSelected();
		boolean condition=true;
		Assert.assertTrue(condition);
		driver.close();
	}

}
