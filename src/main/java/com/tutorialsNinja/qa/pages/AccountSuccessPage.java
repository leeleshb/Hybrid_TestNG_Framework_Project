package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

	WebDriver driver;
	
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement accountSuccessHeading;
	
	@FindBy(linkText = "Continue")
	private WebElement continueButton;
	
	public AccountSuccessPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String retrieveAccountSuccessHeadingText() {
		
		String accountSuccessHeadingText = accountSuccessHeading.getText();
		return accountSuccessHeadingText;
	}
	
	public void clickOnContinueButton() {
		
		continueButton.click();
	}
}
