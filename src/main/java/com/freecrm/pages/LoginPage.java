package com.freecrm.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.utils.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="username")
	public WebElement Ele_Uname;
	
	@FindBy(name="password")
	public WebElement Ele_Pword;

	@FindBy(xpath="//input[@value='Login']")
	public WebElement Ele_Loginbtn;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	public WebElement Ele_loginCRMLOGO;
	
	public LoginPage(){
		//super();
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginpagetitle(){
		
		return driver.getTitle();
	}
	
	public boolean crmLogoElementPresent(){
		return Ele_loginCRMLOGO.isDisplayed();
		
	}
	
	public HomePage loginCRM(String UserName,String Password) throws InterruptedException{
		Ele_Uname.sendKeys(UserName);
		Ele_Pword.sendKeys(Password);
		Thread.sleep(3000);
		Ele_Loginbtn.click();
		
		return new HomePage();
		
	}
}
