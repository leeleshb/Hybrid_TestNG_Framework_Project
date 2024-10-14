package com.tutorialsNinja.qa.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsNinja.qa.base.BaseTest;
import com.tutorialsNinja.qa.pages.AccountPage;
import com.tutorialsNinja.qa.pages.ForgottenPasswordPage;
import com.tutorialsNinja.qa.pages.HomePage;
import com.tutorialsNinja.qa.pages.LoginPage;
import com.tutorialsNinja.qa.utils.Utilities;

import junit.framework.Assert;

public class LoginTest extends BaseTest{
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		readConfigPropertiesFile();
		readTestdataPropertiesFile();
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		homePage.clickOnLoginOption();
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertEquals(loginPage.retrieveNewCustomerHeadingText(), dataprop.getProperty("successfullyNavigatedToLoginPageAssertion"));
	}
	
	@Test(priority = 1, dataProvider = "supplyData")
	public void verifyLoginIntoTheApplicationUsingValidCredentials(String email, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationText());
		
	}
	
	@DataProvider(name = "supplyData")
	public Object[][] dataSupplier() {
		
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;

	}
	
	@Test(priority = 2)
	public void verifyloggingIntoTheApplicationUsingInvalidCredentials() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(dataprop.getProperty("invalidEmail"));
		loginPage.enterPassword(dataprop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.getDisplayStatusOfEmailPasswordNotMatchingWarning());
	}
	
	@Test(priority = 3)
	public void verifyloggingIntoTheApplicationUsingInvalidEmailAndValidPassword() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(dataprop.getProperty("invalidEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.getDisplayStatusOfEmailPasswordNotMatchingWarning());
		
	}
	
	@Test(priority = 4)
	public void verifyloggingIntoTheApplicationUsingValidEmailAndInvalidPassword() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(dataprop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.getDisplayStatusOfEmailPasswordNotMatchingWarning());
		
	}
	
	@Test(priority = 5)
	public void verifyloggingIntoTheApplicationWithoutProvidingAnyCredentials() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.getDisplayStatusOfEmailPasswordNotMatchingWarning());
		
	}
	
	@Test(priority = 6)
	public void verifyForgottenPasswordLinkIsAvailableInTheLoginPageAndIsWorking() {
		
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.displayStatusOfForgottenPasswordLink());
		loginPage.clickOnForgottenPasswordLink();
		ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage(driver);
		Assert.assertEquals(forgottenPasswordPage.retrieveForgotPasswordHeadingText(), dataprop.getProperty("actualHeading"));
	}
	
	@Test(priority = 7)
	public void verifyLoginIntoTheApplicationUsingKeyboardKeys() {
		
		//I will create this test case later
	}
}
