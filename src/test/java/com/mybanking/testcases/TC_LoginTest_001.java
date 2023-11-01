package com.mybanking.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mybanking.pageobjects.LoginPage;
import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage();
		lp.setUserName(config.getuserName());
		log.info("Enterd Username");
		lp.setPasswrd(config.getuserPassword());
		log.info("Enterd Password");
		lp.clicklogin();
		log.info("Clicked the login button");
		Thread.sleep(3000);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			log.info("Login Test Passed");
		}else {
		
			capture();
			Assert.assertTrue(false);
			log.info("Login Test Failed");
		}
			
	}
	

	
	
	
	
}
