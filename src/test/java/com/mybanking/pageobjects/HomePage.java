package com.mybanking.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mybanking.testcases.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="accountno") WebElement accntno;
	@FindBy(name="ammount") WebElement ammnt;
	@FindBy(name="desc")WebElement desc;
	@FindBy(name="AccSubmit")WebElement sbm;
	@FindBy(xpath="//a[normalize-space()='Deposit']")WebElement deposit;
	
	
	public void selectDeposit() {
		deposit.click();
	}
	
	public void setaccntNo(String actn) {
		accntno.sendKeys(actn);
	}
	
	public void setammnt(String amt) {
		ammnt.sendKeys(amt);
	}
	
	public void setdesc(String des) {
		desc.sendKeys(des);
	}
	
	public void clicksubmit() {
		sbm.click();
	}
	
	
}
