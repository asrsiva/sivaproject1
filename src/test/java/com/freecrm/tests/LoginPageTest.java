package com.freecrm.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.utils.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void openApp(){
		openBrowser();
		loginpage=new LoginPage();
		homepage=new HomePage();
	}
	
	//@Test
	public void verifyLoginPagetitle(){
		String actTitle=loginpage.getLoginpagetitle();
		Assert.assertEquals(actTitle, "Free CRM software in the cloud powers sales and customer service");
	}
	
//	@Test
	public void verifyCRMLOGOinloginpage(){
		boolean actvalue=loginpage.crmLogoElementPresent();
		Assert.assertEquals(actvalue, true);
	}
	
	@Test
	public void verifyLogin() throws InterruptedException{
		homepage=loginpage.loginCRM(Config.getProperty("User"), Config.getProperty("pass"));
	}
}
