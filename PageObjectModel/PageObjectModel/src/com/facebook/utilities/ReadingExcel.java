package com.facebook.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public  static boolean isTCrunnable(String TCName) throws IOException
	{
		FileInputStream ip = new FileInputStream("E:\\Selenium Study\\PageObjectModel\\src\\com\\facebook\\testData\\TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(ip);
		XSSFSheet sh = wb.getSheet("AllTestCases");
		
		//total rows
		int totalRows=sh.getPhysicalNumberOfRows();
		
		//total columns
		int totalColumns=sh.getRow(0).getPhysicalNumberOfCells();
		for(int i=1;i<totalRows;i++)
		{
			if(sh.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(TCName))
			{
				if(sh.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase("Y"))
						{
			
					return true;
						}
			}
		}
	return false;
	
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



 































