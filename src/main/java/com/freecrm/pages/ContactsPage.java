package com.freecrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.utils.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//*[@id='first_name']")
	public WebElement FirstName;
	
	@FindBy(xpath="//*[@id='surname']")
	public WebElement SurName;
	
	
	@FindBy(xpath="//input[@value='Save']")
	public WebElement SaveBtn;
	
	@FindBy(xpath="//*[@id='vContactsForm']/table/tbody")
	public WebElement contactsTable;
	
	//*[@id='vContactsForm']/table/tbody
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void createNewContact(String firstName,String surName){
		driver.switchTo().frame("mainpanel");
		FirstName.sendKeys(firstName);
		SurName.sendKeys(surName);
		SaveBtn.click();
		driver.switchTo().defaultContent();
		
	}
	
	public String getContactfromtable(String contactname){
		driver.switchTo().frame("mainpanel");
		String actContact=driver.findElement(By.xpath("//a[@_name='"+contactname+"']")).getText();
		driver.switchTo().defaultContent();
		return actContact;
		
	}
	
}
