package com.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;

public class LoginPage extends TestBase {
	
	//page factory
@FindBy(name="email")
WebElement email;

@FindBy(id="password")
WebElement password;

@FindBy(name="commit")
WebElement loginBtn;

@FindBy(xpath="//a[contains(text(),'Forgot Password')]")
WebElement forgotlink;

//initilization page object
public LoginPage() {
	PageFactory.initElements(driver, this);
}

//action
public String verifyTitleLoginPage() {
	return driver.getTitle();
}
public ForgotPage clickonForgotLing() {
	forgotlink.click();
	return new ForgotPage();
}

public HomePage login(String user, String pass) {
	email.sendKeys(user);
	password.sendKeys(pass);
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	loginBtn.click();
	return new HomePage();
}
}
