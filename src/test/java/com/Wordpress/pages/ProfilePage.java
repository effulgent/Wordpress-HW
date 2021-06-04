package com.Wordpress.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Wordpress.utils.BaseClass;

public class ProfilePage extends BaseClass {

	@FindBy(xpath = "//button[@class=\"button form-button is-primary\"]")
	public WebElement saveBtn;

	@FindBy(id = "first_name")
	public WebElement firstName;

	@FindBy(id = "last_name")
	public WebElement lastName;

	@FindBy(className = "notice__text")
	public WebElement message;
	
	@FindBy(className="profile-gravatar__user-display-name")
	public WebElement userName;
	
	@FindBy(xpath = "//span[text()='Add']")
	public WebElement addLinkBtn;

	@FindBy(xpath = "//button[@class='popover__menu-item' and text()='Add WordPress Site']")
	public WebElement popoverAddWordpressBtn;
	
	@FindBy(xpath = "//button[@class='popover__menu-item' and text()='Add URL']")
	public WebElement popoverAddURLBtn;

	@FindBy(xpath = "//input[@placeholder='Enter a URL']")
	public WebElement enterURL;

	@FindBy(xpath = "//input[@placeholder='Enter a description']")
	public WebElement enterDesc;
	
	@FindBy(xpath = "//button[text()='Add Site']")
	public WebElement addSiteBtn;

	
	@FindBy(className="profile-link__image-link")
	public List<WebElement> listOfLinks;
	
	public WebElement linkByURL(String url) {
		return driver.findElement(By.xpath("//a[@class='profile-link__image-link' and @href='"+url+"']/parent::li"));
	}
	
	public WebElement deleteURLBtnByURL(String url) {
		return linkByURL(url).findElement(By.xpath("//button[contains(@class, 'profile-link__remove')]"));
	}
	
	public WebElement linkExistsNotice() {
		return driver.findElement(By.xpath("//span[@class='notice__text']"));
	}

	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}
}
