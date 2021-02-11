package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TestUtil testutil;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		intialization();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		dealspage = new DealsPage();
		testutil = new TestUtil();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "Homepage title not mathced");
	}

	@Test(priority = 2)
	public void verifyUsernamelabelTest() {
		testutil.swithToFrame();
		Assert.assertTrue(homepage.verifyUsernamelabel());
	}

	@Test(priority = 3)
	public void verifyContactslinkTest() {
		testutil.swithToFrame();
		contactspage = homepage.clickOnContactslink();

	}

	@Test(priority=4)
	public void verifyDealsPageTest() {
		testutil.swithToFrame();
		dealspage = homepage.clickOnDealslink();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();

	}
}
