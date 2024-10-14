package com.tutorialsNinja.qa.testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.qa.base.BaseTest;
import com.tutorialsNinja.qa.pages.AccountPage;
import com.tutorialsNinja.qa.pages.AccountSuccessPage;
import com.tutorialsNinja.qa.pages.HomePage;
import com.tutorialsNinja.qa.pages.LoginPage;
import com.tutorialsNinja.qa.pages.NewsletterPage;
import com.tutorialsNinja.qa.pages.RegisterPage;
import com.tutorialsNinja.qa.utils.Utilities;

public class RegisterTest extends BaseTest {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {

		readConfigPropertiesFile();
		readTestdataPropertiesFile();
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));

		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		homePage.clickOnRegisterOption();
	}

	@Test(priority = 1, enabled = false)
	public void verifyRegisteringAnAccountByProvidingOnlyMandatoryFields() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstname(dataprop.getProperty("firstName"));
		registerPage.enterLastname(dataprop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateRandomEmail());
		registerPage.enterTelephoneNumber(dataprop.getProperty("telephone"));
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerPage.clickOnPrivacyPolicyCheckbox();
		registerPage.clickOnContinueButton();
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessHeadingText(),
				dataprop.getProperty("accountSuccessfullyCreatedHeading"));
		accountSuccessPage.clickOnContinueButton();
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationText());

	}

	@Test(priority = 2, enabled = false)
	public void verifyRegisteringAnAccountByProvidingAllFields() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstname(dataprop.getProperty("firstName"));
		registerPage.enterLastname(dataprop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateRandomEmail());
		registerPage.enterTelephoneNumber(dataprop.getProperty("telephone"));
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerPage.clickOnNewsletterNoRadioButton();
		registerPage.clickOnPrivacyPolicyCheckbox();
		registerPage.clickOnContinueButton();
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessHeadingText(),
				dataprop.getProperty("accountSuccessfullyCreatedHeading"));
		accountSuccessPage.clickOnContinueButton();
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationText());

	}

	@Test(priority = 3, enabled = false)
	public void verifyRegisteringAnAccountWithoutProvidingAnyDetails() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.retrieveFirstNameWarningMessageText(),
				dataprop.getProperty("firstNameWarningMessage"));
		Assert.assertEquals(registerPage.retrieveLastNameWarningMessageText(),
				dataprop.getProperty("lastNameWarningMessage"));
		Assert.assertEquals(registerPage.retrieveEmailWarningMessageText(),
				dataprop.getProperty("emailWarningMessage"));
		Assert.assertEquals(registerPage.retrieveTelephoneWarningMessageText(),
				dataprop.getProperty("telephoneWarningMessage"));
		Assert.assertEquals(registerPage.retrievePasswordWarningMessageText(),
				dataprop.getProperty("passwordWarningMessage"));
		Assert.assertEquals(registerPage.retrievePrivacyPolicyWarningMessageText(),
				dataprop.getProperty("privacyPolicyWarningMessage"));
	}

	@Test(priority = 4, enabled = false)
	public void verifyRegisteringAnAccountWhenYesOptionIsSelectedForNewsletterField() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstname(dataprop.getProperty("firstName"));
		registerPage.enterLastname(dataprop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateRandomEmail());
		registerPage.enterTelephoneNumber(dataprop.getProperty("telephone"));
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerPage.clickOnPrivacyPolicyCheckbox();
		registerPage.clickOnNewsletterYesRadioButton();
		registerPage.clickOnContinueButton();
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessHeadingText(),
				dataprop.getProperty("accountSuccessfullyCreatedHeading"));
		accountSuccessPage.clickOnContinueButton();
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationText());
		accountPage.clickOnSubscribeUnsubscribeToNewsletterOption();
		NewsletterPage newsletterPage = new NewsletterPage(driver);
		assertTrue(newsletterPage.selectionStatusOfNewsletterSubscriptionYesRadioButton());
	}

	@Test(priority = 5, enabled = false)
	public void verifyRegisteringAnAccountWhenNoOptionIsSelectedForNewsletterField() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstname(dataprop.getProperty("firstName"));
		registerPage.enterLastname(dataprop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateRandomEmail());
		registerPage.enterTelephoneNumber(dataprop.getProperty("telephone"));
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerPage.clickOnPrivacyPolicyCheckbox();
		registerPage.clickOnNewsletterNoRadioButton();
		registerPage.clickOnContinueButton();
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessHeadingText(),
				dataprop.getProperty("accountSuccessfullyCreatedHeading"));
		accountSuccessPage.clickOnContinueButton();
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationText());
		accountPage.clickOnSubscribeUnsubscribeToNewsletterOption();
		NewsletterPage newsletterPage = new NewsletterPage(driver);
		assertTrue(newsletterPage.selectionStatusOfNewsletterSubscriptionNoRadioButton());
	}

	@Test(priority = 6, enabled = false)
	public void verifyDifferentWaysOfNavigatingToRegisterAccountPage() {

		RegisterPage registerPage = new RegisterPage(driver);
		Assert.assertTrue(registerPage.displayStatusOfRegisterAccountHeading());
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		homePage.clickOnLoginOption();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnContinueButton();
		Assert.assertTrue(registerPage.displayStatusOfRegisterAccountHeading());
		homePage.clickOnMyAccountDropMenu();
		homePage.clickOnLoginOption();
		loginPage.clickOnRegisterOption();
		Assert.assertTrue(registerPage.displayStatusOfRegisterAccountHeading());
	}

	@Test(priority = 7, enabled = false)
	public void verifyRegisteringAnAccountByEnteringDifferentPasswordsIntoPasswordAndPasswordConfirmField() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstname(dataprop.getProperty("firstName"));
		registerPage.enterLastname(dataprop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateRandomEmail());
		registerPage.enterTelephoneNumber(dataprop.getProperty("telephone"));
		registerPage.clickOnNewsletterNoRadioButton();
		registerPage.clickOnPrivacyPolicyCheckbox();
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("invalidConfirmPassword"));
		registerPage.clickOnContinueButton();
		Assert.assertTrue(registerPage.displayStatusOfConfirmPasswordWarningMessage());
	}

	@Test(priority = 8, enabled = false)
	public void verifyRegisteringAnAccountByProvidingExistingAccountDetails() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstname(dataprop.getProperty("FirstName"));
		registerPage.enterLastname(dataprop.getProperty("LastName"));
		registerPage.enterEmailAddress(dataprop.getProperty("Email"));
		registerPage.enterTelephoneNumber(dataprop.getProperty("Telephone"));
		registerPage.enterPassword(dataprop.getProperty("Password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("PasswordConfirm"));
		registerPage.clickOnNewsletterNoRadioButton();
		registerPage.clickOnPrivacyPolicyCheckbox();
		registerPage.clickOnContinueButton();
		Assert.assertTrue(registerPage.displayStatusOfExistingEmailWarningMessage());
	}

	@Test(priority = 9)
	public void verifyRegisteringAnAccountByProvidingAnInvalidEmailAddressIntoEmailField() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstname(dataprop.getProperty("firstName"));
		registerPage.enterLastname(dataprop.getProperty("lastName"));
		registerPage.enterTelephoneNumber(dataprop.getProperty("telephone"));
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerPage.clickOnNewsletterNoRadioButton();
		registerPage.clickOnPrivacyPolicyCheckbox();
		registerPage.enterEmailAddress(dataprop.getProperty("invalidEmail1"));
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.retrieveEmailValidationWarningMessage(),
				dataprop.getProperty("validationMessage1"));
		registerPage.clearEmailAddressField();
		registerPage.enterEmailAddress(dataprop.getProperty("invalidEmail2"));
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.retrieveEmailValidationWarningMessage(),
				dataprop.getProperty("validationMessage2"));
		registerPage.clearEmailAddressField();
		registerPage.enterEmailAddress(dataprop.getProperty("invalidEmail3"));
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.retreiveInvalidEmailWarningMessage(),
				dataprop.getProperty("validationMessage3"));
		registerPage.clearEmailAddressField();
		registerPage.enterEmailAddress(dataprop.getProperty("invalidEmail4"));
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.retrieveEmailValidationWarningMessage(),
				dataprop.getProperty("validationMessage4"));
	}

	@Test(priority = 10)
	public void verifyRegisteringAnAccountByProvidingAnInvalidPhoneNumber() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstname(dataprop.getProperty("firstName"));
		registerPage.enterLastname(dataprop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateRandomEmail());
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerPage.clickOnNewsletterNoRadioButton();
		registerPage.clickOnPrivacyPolicyCheckbox();
		registerPage.enterTelephoneNumber(dataprop.getProperty("invalidTelephoneNumber1"));
		registerPage.clickOnContinueButton();
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertNotEquals(accountSuccessPage.retrieveAccountSuccessHeadingText(),
				dataprop.getProperty("accountSuccessfullyCreatedHeading"));
	}

	@Test(priority = 11)
	public void verifyRegisteringAnAccountByUsingKeyboardKeys() {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterRegistrationDetailsUsingKeyboardKeys(dataprop.getProperty("firstName"),
				dataprop.getProperty("lastName"), Utilities.generateRandomEmail(), dataprop.getProperty("telephone"),
				dataprop.getProperty("password"), dataprop.getProperty("confirmPassword"));
		registerPage.clickOnContinueButton();
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessHeadingText(),
				dataprop.getProperty("accountSuccessfullyCreatedHeading"));
	}
	
	@Test(priority = 12)
	public void verifyAllFieldsIntheRegisterAccountPageHaveProperPlaceholders() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		Assert.assertEquals(registerPage.retrieveFirstNameFieldPlaceholder(), dataprop.getProperty("firstNamePlaceholder"));
		Assert.assertEquals(registerPage.retrieveLastNameFieldPlaceholder(), dataprop.getProperty("lastNamePlaceholder"));
		Assert.assertEquals(registerPage.retrieveEmailFieldPlaceholder(), dataprop.getProperty("emailPlaceholder"));
		Assert.assertEquals(registerPage.retrieveTelephoneFieldPlaceholder(), dataprop.getProperty("telephonePlaceholder"));
		Assert.assertEquals(registerPage.retrievePasswordFieldPlaceholder(), dataprop.getProperty("passwordPlaceholder"));
		Assert.assertEquals(registerPage.retrievePasswordConfirmFieldPlaceholder(), dataprop.getProperty("confirmPasswordplaceholder"));
	}
}
