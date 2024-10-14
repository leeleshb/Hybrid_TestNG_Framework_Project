package com.tutorialsNinja.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailAddressField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;

	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckbox;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@name='newsletter'and@value='0']")
	private WebElement newsletterNoRadioButton;

	@FindBy(xpath = "//fieldset[@id='account']/div[2]/div/div")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath = "//fieldset[@id='account']/div[3]/div/div")
	private WebElement lastNameWarningMessage;

	@FindBy(xpath = "//fieldset[@id='account']/div[4]/div/div")
	private WebElement emailWarningMessage;

	@FindBy(xpath = "//fieldset[@id='account']/div[5]/div/div")
	private WebElement telephoneWarningMessage;

	@FindBy(xpath = "//div[@id='content']/form/fieldset[2]/div/div/div")
	private WebElement passwordWarningMessage;

	@FindBy(xpath = "//div[@id='account-register']/div[1]")
	private WebElement privacyPolicyWarningMessage;

	@FindBy(xpath = "//input[@name='newsletter' and @value='1']")
	private WebElement newsletterYesRadioButton;

	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement registerAccountHeading;

	@FindBy(xpath = "//div[text()='Password confirmation does not match password!']")
	private WebElement confirmPasswordWarningMessage;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement existingEmailWarning;

	@FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement invalidEmailWarning;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFirstname(String firstNameText) {

		firstNameField.sendKeys(firstNameText);
	}

	public void enterLastname(String lastNameText) {

		lastNameField.sendKeys(lastNameText);
	}

	public void enterEmailAddress(String emailText) {

		emailAddressField.sendKeys(emailText);
	}

	public void enterTelephoneNumber(String telephoneNumber) {

		telephoneField.sendKeys(telephoneNumber);
	}

	public void clickOnNewsletterNoRadioButton() {

		newsletterNoRadioButton.click();
	}

	public void enterPassword(String password) {

		passwordField.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword) {

		confirmPasswordField.sendKeys(confirmPassword);
	}

	public void clickOnPrivacyPolicyCheckbox() {

		privacyPolicyCheckbox.click();
	}

	public void clickOnContinueButton() {

		continueButton.click();
	}

	public String retrieveFirstNameWarningMessageText() {

		String firstNameWarning = firstNameWarningMessage.getText();
		return firstNameWarning;
	}

	public String retrieveLastNameWarningMessageText() {

		String lastNameWarning = lastNameWarningMessage.getText();
		return lastNameWarning;
	}

	public String retrieveEmailWarningMessageText() {

		String emailWarning = emailWarningMessage.getText();
		return emailWarning;
	}

	public String retrieveTelephoneWarningMessageText() {

		String telephoneWarning = telephoneWarningMessage.getText();
		return telephoneWarning;
	}

	public String retrievePasswordWarningMessageText() {

		String passwordWarning = passwordWarningMessage.getText();
		return passwordWarning;
	}

	public String retrievePrivacyPolicyWarningMessageText() {

		String privacyPolicyWarning = privacyPolicyWarningMessage.getText();
		return privacyPolicyWarning;
	}

	public void clickOnNewsletterYesRadioButton() {

		newsletterYesRadioButton.click();
	}

	public boolean displayStatusOfRegisterAccountHeading() {

		boolean displayStatus = registerAccountHeading.isDisplayed();
		return displayStatus;
	}

	public boolean displayStatusOfConfirmPasswordWarningMessage() {

		boolean displayStatus = confirmPasswordWarningMessage.isDisplayed();
		return displayStatus;
	}

	public boolean displayStatusOfExistingEmailWarningMessage() {

		boolean displayStatus = existingEmailWarning.isDisplayed();
		return displayStatus;
	}

	public String retrieveEmailValidationWarningMessage() {

		String emailValidationwarning = emailAddressField.getAttribute("validationMessage");
		return emailValidationwarning;
	}

	public void clearEmailAddressField() {

		emailAddressField.clear();
	}

	public String retreiveInvalidEmailWarningMessage() {

		String invalidEmailWarningValidation = invalidEmailWarning.getText();
		return invalidEmailWarningValidation;
	}

	public void enterRegistrationDetailsUsingKeyboardKeys(String firstName, String lastName, String email,
			String telephoneNumber, String password, String confirmPassword) {

		Actions action = new Actions(driver);
		action.moveToElement(firstNameField).sendKeys(firstNameField, firstName).sendKeys(Keys.TAB)
				.sendKeys(lastNameField, lastName).sendKeys(Keys.TAB).sendKeys(emailAddressField, email)
				.sendKeys(Keys.TAB).sendKeys(telephoneField, telephoneNumber).sendKeys(Keys.TAB)
				.sendKeys(passwordField, password).sendKeys(Keys.TAB).sendKeys(confirmPasswordField, confirmPassword)
				.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).build().perform();
	}

	public String retrieveFirstNameFieldPlaceholder() {

		String firstNamePlaceholder = firstNameField.getAttribute("placeholder");
		return firstNamePlaceholder;
	}

	public String retrieveLastNameFieldPlaceholder() {

		String lastNamePlaceholder = lastNameField.getAttribute("placeholder");
		return lastNamePlaceholder;
	}

	public String retrieveEmailFieldPlaceholder() {

		String emailPlaceholder = emailAddressField.getAttribute("placeholder");
		return emailPlaceholder;
	}

	public String retrieveTelephoneFieldPlaceholder() {

		String telephonePlaceholder = telephoneField.getAttribute("placeholder");
		return telephonePlaceholder;
	}

	public String retrievePasswordFieldPlaceholder() {

		String passwordPlaceholder = passwordField.getAttribute("placeholder");
		return passwordPlaceholder;
	}

	public String retrievePasswordConfirmFieldPlaceholder() {

		String passwordConfirmPlaceholder = confirmPasswordField.getAttribute("placeholder");
		return passwordConfirmPlaceholder;
	}
}
