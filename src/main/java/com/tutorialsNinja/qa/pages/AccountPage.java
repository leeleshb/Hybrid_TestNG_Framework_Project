package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;
	
	@FindBy(linkText = "Edit your account information")
	private WebElement editYourAccountinformationText;
	
	@FindBy(linkText = "Subscribe / unsubscribe to newsletter")
	private WebElement subscribeUnsubscribeToNewsletterOption;
	
	public AccountPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayStatusOfEditYourAccountInformationText() {
		
		boolean displayStatus = editYourAccountinformationText.isDisplayed();
		return displayStatus;
	}
	
	public void clickOnSubscribeUnsubscribeToNewsletterOption() {
		
		subscribeUnsubscribeToNewsletterOption.click();
	}
}
