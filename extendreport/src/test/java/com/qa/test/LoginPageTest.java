package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testbase.TestBase;
import com.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	
	HomePage homepage;
	TestUtil testUtil;
	LoginPage loginpage;
	String sheetName="logindata";
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initliazation();
		homepage=new HomePage();
		testUtil=new TestUtil();
		loginpage=homepage.verifyClickLoginLingHomePage();
	}
	
	@Test(priority=1)
	public void verifyTitlelogin() {
		String loginTitle=loginpage.verifyTitleLoginPage();
		Assert.assertEquals(loginTitle, "Rahul Shetty Academy");
	}
	
	@DataProvider
	public Object[][] getExtentData(String sheetName){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	//dataProvider="getExtentData"
	@Test(priority=2,dataProvider="getExtentData")
	public void verifylogin(String userName,String passw) {
		loginpage.login(userName,passw);
		
		//loginpage.login();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
