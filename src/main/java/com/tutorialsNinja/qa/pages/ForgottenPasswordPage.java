package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottenPasswordPage {

	WebDriver driver;
	
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement forgotPasswordHeading;
	
	public ForgottenPasswordPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String retrieveForgotPasswordHeadingText() {
		
		String expectedHeading = forgotPasswordHeading.getText();
		return expectedHeading;
	}
}
