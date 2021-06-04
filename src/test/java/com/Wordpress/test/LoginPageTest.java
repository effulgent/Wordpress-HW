package com.Wordpress.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.Wordpress.utils.CommonMethods;
import com.Wordpress.utils.ConfigsReader;
import com.Wordpress.pages.LoginPage;
import com.Wordpress.pages.ProfilePage;

/**
 * This test validates restricted access with invalid credentials, 
 * and allowed access with valid credentials
 * 
 * @author Yulia Melnikova
 * @since 06/03/2021
 */

public class LoginPageTest extends CommonMethods {

	LoginPage lp;
	ProfilePage pp;
	
	@BeforeMethod
	public void setup() {
		setUp();
		nav();
	}
	
	@Test
	public void _01_loginWithInvalidCredentials() throws InterruptedException {
		//unauthenticated user is redirected to a login page
		//user cannot successfully authenticate by providing invalid credentials
		//error message is displayed
		lp = new LoginPage();
		Thread.sleep(1000);
		sendText(lp.userName, "effulgent");
		lp.loginBtn.click();;
		sendText(lp.password, ConfigsReader.getProperty("password"));
		lp.loginBtn.click();;

		Thread.sleep(1000);//for demo purposes only

		AssertJUnit.assertTrue(lp.message.isDisplayed());
		String errorText = lp.message.getText().trim();
		AssertJUnit.assertEquals("Oops, that's not the right password. Please try again!", errorText);

	}

	@Test
	public void _02_loginWithValidCredentials() throws InterruptedException {
		//unauthenticated user is redirected to a login page
		//user can successfully authenticate by providing valid credentials
		//then user is taken to My Profile page
		
		lp = new LoginPage();
		Thread.sleep(1000);
		lp.userName.clear();
		sendText(lp.userName, ConfigsReader.getProperty("username"));
		lp.loginBtn.click();
		lp.password.clear();
		sendText(lp.password, ConfigsReader.getProperty("password"));
		lp.loginBtn.click();

		Thread.sleep(3000);//for demo purposes only
		pp = new ProfilePage();
		AssertJUnit.assertEquals(ConfigsReader.getProperty("username"), pp.userName.getText());
	}
	
	@AfterMethod
	public void tear_down() {
		tearDown();
	}

	

}
