package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
	@CacheLookup
	WebElement UserNameLabel;

	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement Contactslink;

	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	WebElement Dealslink;

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public String verifyHomePageTitle() {
		return driver.getTitle();

	}

	public boolean verifyUsernamelabel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", UserNameLabel);
		return UserNameLabel.isDisplayed();

	}

	public ContactsPage clickOnContactslink() {
		Contactslink.click();
		return new ContactsPage();

	}

	public DealsPage clickOnDealslink() {
		Dealslink.click();
		return new DealsPage();
	}

}
