package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;

public class HomePage extends TestBase {
	
	//page factory
	@FindBy(xpath="//header/div[2]/div[1]/div[1]/div[2]/div[2]/a[1]")
	WebElement loginlink;
	
	@FindBy(xpath="//header/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]")
	WebElement registerationlink;
	
	@FindBy(xpath="//header/div[3]/div[1]/div[1]/div[2]/nav[1]/div[2]/ul[1]/li[2]/a[1]")
	WebElement courselink;
	
	@FindBy(xpath="//header/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]")
	WebElement emailText;
	//initialization page object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//action
	public String verifyTitleHomepage() {
		return driver.getTitle();
	}
	
	public boolean verifyEmailHomePage() {
		return emailText.isDisplayed();
	}
	public LoginPage verifyClickLoginLingHomePage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginlink.click();
		return new LoginPage();
	}
	public RegisterationPage verifyClickRegisterationHomePage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		registerationlink.click();
		return new RegisterationPage();
	}

}
