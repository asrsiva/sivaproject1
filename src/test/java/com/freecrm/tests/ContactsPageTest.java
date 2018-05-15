package com.freecrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.pages.ContactsPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.utils.TestBase;
import com.freecrm.utils.TestUtil;


public class ContactsPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	@BeforeMethod
	public void openApp(){
		openBrowser();
		loginpage=new LoginPage();
		homepage=new HomePage();
		contactspage=new ContactsPage();
	}
	
	@AfterMethod
	public void signout(){
		
		loginpage=homepage.logout();
		
	}
	
	@Test(dataProvider="getNewContactData")
	public void createNewContactandVerify(String fName,String lName,String newContact){
		try{
		homepage=loginpage.loginCRM(Config.getProperty("User"), Config.getProperty("pass"));
		contactspage=homepage.mouseHovertoContactsclicknewcontact();
		contactspage.createNewContact(fName,lName);
		homepage.clickOnContact();
		String actulContact=contactspage.getContactfromtable(newContact);
		Assert.assertEquals(newContact, actulContact);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	@DataProvider
	public Object[][] getNewContactData(){
		return TestUtil.getData(d, "ContactsPage", "createNewContactandVerify");
	}
	
}
