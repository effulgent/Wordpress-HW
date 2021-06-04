package com.Wordpress.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Wordpress.utils.BaseClass;


public class LoginPage extends BaseClass{
	  @FindBy(id="usernameOrEmail")
	  public WebElement userName;
	  
	  @FindBy(className="login__form-action")
	  public WebElement loginBtn;
	  
	  @FindBy(id="password")
	  public WebElement password;
	  
	  
	  @FindBy(className="login__form-action")
	  public WebElement passBtn;
	  
	  
	  @FindBy(xpath="//div[@class=\"form-input-validation is-error\"]")
	    public WebElement message;
	  
	  public LoginPage() {
		  PageFactory.initElements(driver, this);
	  }
	  
}
