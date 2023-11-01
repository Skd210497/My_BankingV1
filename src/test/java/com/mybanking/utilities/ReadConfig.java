package com.mybanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public Properties prop;

	public ReadConfig(){
	
	
	FileInputStream fis;
	try {
		fis = new FileInputStream("C:\\Users\\ASUS\\eclipse-workspace\\My_Banking\\config.properties");
	
	prop = new Properties();
	prop.load(fis);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

	public String getApplicationUrl() {
		String u = prop.getProperty("url");
		return u;
	}

	public String getuserName() {
		String usname = prop.getProperty("userName");
		return usname;
	}

	public String getuserPassword() {
		String pss = prop.getProperty("passwrd");
		return pss;
	}
	
	public String getaccountNo() {
		String actn=prop.getProperty("acctNo");
		return actn;
	}
	
	public String getammount() {
		String amt=prop.getProperty("amnt");
		return amt;
}
	
	public String getdescription() {
		String descp=prop.getProperty("desc");
		return descp;
	
	}
}
