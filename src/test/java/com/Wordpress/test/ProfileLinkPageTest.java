package com.Wordpress.test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.Wordpress.pages.LoginPage;
import com.Wordpress.pages.ProfilePage;
import com.Wordpress.utils.CommonMethods;

/**
 * This test validates 
 * 	- user can add a url link to a profile
 *  - if identical url exists, user is alerted with error message
 *  - user can delete a url from My Profile
 * 
 * 
 * @author Yulia Melnikova
 * @since 06/03/2021
 */

public class ProfileLinkPageTest extends CommonMethods {

	LoginPage lp = new LoginPage();
	ProfilePage link;
	private final String url = "http://www.test.com";
	private final String desc = "Test Website";

	@BeforeClass
	public void login() throws InterruptedException {
		setUp();
		nav();
		LoginPageTest lps = new LoginPageTest();
		lps._02_loginWithValidCredentials();
	}

	@Test
	public void _01_addLinks() throws InterruptedException {
		//user is landed on a My Profile page and is able to add 
		//a link to profile by clicking on Add button
		
		link  = new ProfilePage();	
		link.addLinkBtn.click();
		link.popoverAddURLBtn.click();
		link.enterDesc.sendKeys(desc);
		link.enterURL.sendKeys(url);
		Thread.sleep(3000);//for demo purposes
		link.addSiteBtn.click();
		
		link.linkByURL(url).click();
	}
	
	@Test
	public void _02_addExistingLink() throws InterruptedException {
		//on attempt to add a link with existing url and description, 
		//user is presented with an error message that such URL already exists in My Profile
		link  = new ProfilePage();
		link.addLinkBtn.click();
		link.popoverAddURLBtn.click();
		sendText(link.enterDesc, desc);
		sendText(link.enterURL, url);
		link.addSiteBtn.click();
		waitForElementBeVisible(link.linkExistsNotice(), 5);
		Assert.assertEquals(link.linkExistsNotice().getText(), "That link is already in your profile links. No changes were made.");
	}
	
	@Test
	public void _03_deleteAddedLink() throws InterruptedException {
		//user is able to delete a url on My Profile page 
		//by clicking on "X" next to a corresponding url record
		link  = new ProfilePage();
		link.deleteURLBtnByURL(url).click();
		List <WebElement> links = link.listOfLinks;
		
		for (WebElement l : links) {
			String linkFromList = l.getAttribute("href");
			Assert.assertFalse(linkFromList.equals(url));
		}
	}
	
	@AfterClass
	public void tear_down() {
		tearDown();
	}
}
