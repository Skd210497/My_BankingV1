package com.mybanking.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mybanking.testcases.BaseClass;

public class LoginPage extends BaseClass{

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="uid") WebElement txtusername;
	@FindBy(name="password") WebElement txtpasswrd;
	@FindBy(name="btnLogin")WebElement btnlogin;
	
	
	public void setUserName(String uname) {
		txtusername.sendKeys(uname);
	}
	
	public void setPasswrd(String pwd) {
		txtpasswrd.sendKeys(pwd);
	}
	
	public void clicklogin() {
		btnlogin.click();
	}
	
	
	
}
