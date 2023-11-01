package com.mybanking.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.mybanking.pageobjects.HomePage;
import com.mybanking.pageobjects.LoginPage;

public class TC_DepositTest_001 extends BaseClass{

	@Parameters("browser")
	@Test
	public void DepositTest(String br) {
		
		LoginPage lp = new LoginPage();
		lp.setUserName(config.getuserName());
		log.info("Enterd Username");
		lp.setPasswrd(config.getuserPassword());
		log.info("Enterd Password");
		lp.clicklogin();
		log.info("Clicked the login button");
		HomePage hp = new HomePage();
		hp.selectDeposit();
		hp.setaccntNo(config.getaccountNo());
		log.info("Account number Entered");
		hp.setammnt(config.getammount());
		log.info("Ammount has been Entered");
		hp.setdesc(config.getdescription());
		log.info("Entered Description");
		hp.clicksubmit();
		log.info("Clicked the Submit button");
	}
	
	
	
	
	
	
}
