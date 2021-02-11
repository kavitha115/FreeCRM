package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;

	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		intialization();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		testutil = new TestUtil();
        homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
        testutil.swithToFrame();
        contactspage = homepage.clickOnContactslink();

	}
	@Test(priority=1)
	public void VerifyContactslabelTest(){
		Assert.assertTrue(contactspage.verifyContactslabel(), "contacts label is not displayed");
	
		}
	@Test(priority=2)
	public void SelectContactsByNameTest(){
		contactspage.selectContactsByName("david duck");
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
		
	}

}