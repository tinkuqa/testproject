package com.qa.test;

import org.testng.Assert;
//import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.RegisterationPage;
import com.qa.testbase.TestBase;
import com.qa.util.TestUtil;

public class HomePageTest extends TestBase {
 LoginPage loginPage;
 HomePage homePage;
 RegisterationPage registeration;
 TestUtil testUtil;

	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initliazation();
		homePage=new HomePage();
		loginPage=new LoginPage();
		//testUtil=new TestUtil();
	}
	@Test(priority=1)
	public void verifyHomePageTiltetest() {
		String homeTitle=homePage.verifyTitleHomepage();
		Assert.assertEquals(homeTitle, "Rahul Shetty Academy");
		//System.out.print(homeTitle);
	}
	@Test(priority=2)
	public void verifyLoginLinkTest() {
		
		loginPage=homePage.verifyClickLoginLingHomePage();
	}
	@Test(priority=3)
	public void emailTextTest() {
				Assert.assertTrue(homePage.verifyEmailHomePage());
	}
	@Test(priority=4)
	public void clickonResistationlinkHomepage() {
		
		registeration=homePage.verifyClickRegisterationHomePage();
		//throw new SkipException("page is not avalible");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
