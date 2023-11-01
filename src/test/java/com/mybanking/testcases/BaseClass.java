package com.mybanking.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.mybanking.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	public static WebDriver driver;
	public static Logger log;
	ReadConfig config= new ReadConfig();
	

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br){
		
		if(br.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();}
		else if(br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		
		log = Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("log4j.properties");
		
		driver.get(config.getApplicationUrl());
		log.info("URL is opened");
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		
	}
	@AfterClass
	public void teardown() {
		driver.quit();;
		log.info("Browser closed");
	}
	

    public static void capture() throws IOException {
        
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("C:\\Users\\ASUS\\eclipse-workspace\\My_Banking\\Screenshot\\Screenshot.png");
        FileUtils.copyFile(scrFile, Dest);
        
        }

	
	
	
	
	
	

}
