package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterPage {

	WebDriver driver;
	
	@FindBy(xpath = "//input[@name='newsletter' and @value='1']")
	private WebElement newsletterSubscriptionYesRadioButton;
	
	@FindBy(xpath = "//input[@name='newsletter' and @value='0']")
	private WebElement newsletterSubscriptionNoRadioButton;
	
	public NewsletterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean selectionStatusOfNewsletterSubscriptionYesRadioButton() {
		
		boolean selectionStatus = newsletterSubscriptionYesRadioButton.isSelected();
		return selectionStatus;
	}
	
	public boolean selectionStatusOfNewsletterSubscriptionNoRadioButton() {
		
		boolean selectionStatus = newsletterSubscriptionNoRadioButton.isSelected();
		return selectionStatus;
	}
	
}
