package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.testbase.TestBase;
import com.sun.media.sound.InvalidFormatException;

public class TestUtil extends TestBase {
	
	static Workbook book;
	static Sheet sheet;
	public static String path="C:\\Users\\DELL\\eclipse-workspace\\extendreport\\src\\main\\java\\com\\qa\\testdata\\TestData.xlsx";
	
	static ExtentSparkReporter reporter;
	static ExtentReports extent;
	
	//for extent report
	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Practice Report");
		reporter.config().setDocumentTitle("Test Report");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Naveen Pandey");
		return extent;
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file=null;
		try {
			file=new FileInputStream(path);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		Object[][]data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}

}
