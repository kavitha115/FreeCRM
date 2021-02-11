package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	// Actions actions;

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//button[@type='button']")
	WebElement SignUpBtn;

	@FindBy(xpath = "//img[@class='img-responsive'and @alt='free crm logo']")
	WebElement CRMLogo;

	// intialize objet repositories

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMimage() {
		return CRMLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		// Actions actions = new Actions(driver);
		// actions.moveToElement(LoginBtn).build().perform();
		// LoginBtn.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
		//LoginBtn.click();
		return new HomePage();

	}

}
