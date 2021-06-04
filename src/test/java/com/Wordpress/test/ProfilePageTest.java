package com.Wordpress.test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.Wordpress.utils.CommonMethods;
import org.testng.Assert;
import com.Wordpress.pages.ProfilePage;

/**
 * This test validates that a user can modify first and last name on My Profile page, 
 * and is presented with a message of successful save
 * 
 * @author Yulia Melnikova
 * @since 06/03/2021
 */

public class ProfilePageTest extends CommonMethods {

	private ProfilePage prof;
	private String newFirstName;
	private String newLastName;
	private String oldFirstName;
	private String oldLastName;

	@BeforeClass
	public void login() throws InterruptedException {
		setUp();
		nav();
		LoginPageTest lps = new LoginPageTest();
		lps._02_loginWithValidCredentials();
	
	}

	@Test(priority=1)
	public void _01_ModifyFirstLastName() throws InterruptedException {
		//as a user, I am able to change my First and last name
		//using corresponding input field on My Profile page
		prof = new ProfilePage();
		waitForElementBeVisible(prof.firstName, 5);
		oldFirstName = prof.firstName.getAttribute("value");
		waitForElementBeVisible(prof.lastName, 5);
		oldLastName = prof.lastName.getAttribute("value");
		newFirstName = oldFirstName + " modified";
		newLastName= oldLastName + " modified";
		Thread.sleep(3000);//for demo purposes only
		sendText(prof.firstName, newFirstName);
		
		sendText(prof.lastName, newLastName);
		prof.saveBtn.click();
		Thread.sleep(3000);//for demo purposes only

		Assert.assertTrue(prof.message.isDisplayed());
		String messageText = prof.message.getText().trim();
		Assert.assertEquals("Settings saved successfully!", messageText);
	}
	
	@Test(priority=2)
	public void _02_ValidateSavedChanges() throws InterruptedException {
		//Validate that first and last name were saved properly
		//and appear on My Profile Page as valid values after reloading the page 
		prof = new ProfilePage();
		waitForElementBeVisible(prof.firstName, 5);
		waitForElementBeVisible(prof.lastName, 5);
		Assert.assertEquals(prof.firstName.getAttribute("value"), newFirstName);
		Assert.assertEquals(prof.lastName.getAttribute("value"), newLastName);
		
	}
	
	@Test(priority=3)
	public void _03_ResetToOriginalValues() throws InterruptedException {
		//as a user, I am able to change my First and last name
		//using corresponding input field on My Profile page
		prof = new ProfilePage();
		sendText(prof.firstName, oldFirstName);
		sendText(prof.lastName, oldLastName);
		prof.saveBtn.click();
		Thread.sleep(3000);//for demo purposes only

		Assert.assertTrue(prof.message.isDisplayed());
		String messageText = prof.message.getText().trim();
		Assert.assertEquals("Settings saved successfully!", messageText);
	}
	
	@AfterClass
	public void tear_down() {
		tearDown();
	}
	
}
