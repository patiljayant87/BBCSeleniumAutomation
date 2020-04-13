package com.bbc.regression;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public static Object[][] readUserData(String SheetName) throws IOException
	{
		FileInputStream ip = new FileInputStream("E:\\Selenium Study\\PageObjectModel\\src\\com\\facebook\\testData\\TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ip);
		XSSFSheet sh = wb.getSheet("TestData");
		
		//rows
		int totalRows=sh.getPhysicalNumberOfRows();
		//columns
		int totalColumns=sh.getRow(0).getPhysicalNumberOfCells();
		
		//int arr[][] = new int[totalRows][totalColumns];
		Object arr[][]= new Object[totalRows][totalColumns];
		
		
		for(int i=0;i<totalRows;i++)//rows
		{
			for(int j=0;j<totalColumns;j++)//columns
			{
			//sh.getRow(i).getCell(j).getStringCellValue();
				arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
			}
		}

		return arr;
	}

}
