package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\extendreport\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(ip);
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
	public void initliazation() {
		String browserName=prop.getProperty("Browser");
		if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\eclipse-workspace\\practice\\driver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "");
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnits.SECOND);
		driver.get(prop.getProperty("url"));
	}

}
