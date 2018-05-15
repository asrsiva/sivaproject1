package com.freecrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.utils.TestBase;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void openApp(){
		openBrowser();
		loginpage=new LoginPage();
		homepage=new HomePage();
	}
	
	@AfterMethod
	public void signout(){
		loginpage=homepage.logout();
	}
	
	@Test
	public void verifyHomePageUser() throws InterruptedException{
		
		homepage=loginpage.loginCRM(Config.getProperty("User"), Config.getProperty("pass"));
		String actUser=homepage.getUSer();
		System.out.println("actUser is: "+actUser);
		Assert.assertTrue(actUser.contains(Config.getProperty("UserName")));

	}
	
	

}
