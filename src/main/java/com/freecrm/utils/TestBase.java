package com.freecrm.utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public DataUtil d=new DataUtil();
	public static WebDriver driver;
	FileInputStream f=null;
	public Properties Config=null;
	
	public void openBrowser(){
		
		String browser="ff";
		if(browser.equals("ff")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/main/java/com/freecrm/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/com/freecrm/drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(Config.getProperty("Url"));
	}
	
	public TestBase(){
		try{
			f=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/freecrm/config/config.properties");
			Config=new Properties();
			Config.load(f);
			
		}catch(Exception e){
			
		}
	}
}
