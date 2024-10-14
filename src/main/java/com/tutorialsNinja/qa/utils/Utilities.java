package com.tutorialsNinja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static final int implicitWait = 10;
	
	public static String generateRandomEmail() {

		Date date = new Date();
		String timestamp = date.toString().replace(" ", "_").replace(":", "_");
		return "linda" + timestamp + "@gmail.com";
		
	}
	
	public static Object[][] getTestDataFromExcel(String sheetName) {
		
		File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsNinja\\qa\\testdata\\TutorialsNinjaTestData.xlsx");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		XSSFWorkbook wb = null;
		
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		XSSFSheet sheet = wb.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for(int i=0; i<rows; i++) {
			XSSFRow row = sheet.getRow(i+1);
			for(int j=0; j<cols; j++) {
				XSSFCell cell = row.getCell(j);
				
				CellType cellType = cell.getCellType();
				
				switch (cellType) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
					
				case NUMERIC:
					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
					break;
					
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;
	}
	
	public static String captureScreenshot(WebDriver driver,String testName) {
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		try {
			FileHandler.copy(screenshot, new File(destinationScreenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationScreenshotPath;
	}
}
