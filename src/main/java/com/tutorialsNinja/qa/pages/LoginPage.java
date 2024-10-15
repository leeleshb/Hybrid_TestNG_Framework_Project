package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//div[@id='content']/div[1]/div[1]/div/h2")
	private WebElement newCustomerHeadingText;

	@FindBy(id = "input-email")
	private WebElement emailAddressField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordNotMatchingWarning;

	@FindBy(linkText = "Continue")
	private WebElement continueButton;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(linkText = "Forgotten Password")
	private WebElement forgottenPasswordLink;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String retrieveNewCustomerHeadingText() {

		String expectedText = newCustomerHeadingText.getText();
		return expectedText;
	}

	public void enterEmailAddress(String emailText) {

		emailAddressField.sendKeys(emailText);
	}

	public void enterPassword(String password) {

		passwordField.sendKeys(password);
	}

	public void clickOnLoginButton() {

		loginButton.click();
	}

	public boolean getDisplayStatusOfEmailPasswordNotMatchingWarning() {

		boolean displayStatus = emailPasswordNotMatchingWarning.isDisplayed();
		return displayStatus;
	}

	public void clickOnContinueButton() {

		continueButton.click();
	}

	public void clickOnRegisterOption() {

		registerOption.click();
	}

	public boolean displayStatusOfForgottenPasswordLink() {

		boolean displayStatus = forgottenPasswordLink.isDisplayed();
		return displayStatus;
	}

	public void clickOnForgottenPasswordLink() {

		forgottenPasswordLink.click();
	}

	public String getEmailAddressAttributePlaceholder() {

		String emailAddressPlaceholder = emailAddressField.getAttribute("placeholder");
		return emailAddressPlaceholder;
	}

	public String getPasswordAttributePlaceholder() {

		String passwordPlaceholder = passwordField.getAttribute("placeholder");
		return passwordPlaceholder;
	}
}
