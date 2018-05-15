package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.utils.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[@class='headertext'][@align='left']")
	public WebElement HomePageUserx;
	
	@FindBy(xpath="//a[@title='Contacts']")
	public WebElement ContactsLinkx;
	
	@FindBy(xpath="//a[@title='New Contact']")
	public WebElement NewContactx;
	
	@FindBy(xpath="//a[@href='https://www.freecrm.com/index.cfm?logout=1']")
	public WebElement LogOutx;
	

	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getUSer(){
		driver.switchTo().frame("mainpanel");
		String userName= HomePageUserx.getText();
		driver.switchTo().defaultContent();
		return userName;
		
		
	}
	
	public void clickOnContact(){
		driver.switchTo().frame("mainpanel");
		ContactsLinkx.click();
		driver.switchTo().defaultContent();
		
	}
	
	public ContactsPage mouseHovertoContactsclicknewcontact(){
		driver.switchTo().frame("mainpanel");
		Actions a=new Actions(driver);
		a.moveToElement(ContactsLinkx).build().perform();
		NewContactx.click();
		driver.switchTo().defaultContent();
		return new ContactsPage();
		
	}
	
	public LoginPage logout(){
		driver.switchTo().frame("mainpanel");
		LogOutx.click();
		driver.switchTo().defaultContent();
		return new LoginPage();
	}
	
}
