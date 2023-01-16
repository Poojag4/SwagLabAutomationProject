package Pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;
import Utility.UtilityMethod;

public class LoginPage  extends TestBase{
	
	
	//Object 
	@FindBy(xpath = "//div[@class='login_logo']") private WebElement loginLogo;
	@FindBy(xpath  = "//div[@class='bot_column']") private WebElement bottomLogo;
	//driver.findElement --> will not work here because if you write next class element in same class then it will throw error nosuchelement execption
	  // so use findby
	
	@FindBy(xpath =" //input[@id='user-name']") private WebElement userName;//username
	@FindBy(xpath ="//input[@id='password']")  private WebElement password;//passsword
	@FindBy(xpath ="//input[@id='login-button']")  private WebElement loginButton;//Loginbutoon
	@FindBy(xpath ="//span[text()='Products']") private WebElement productText;
	@FindBy(xpath="//h3[text()='Epic sadface: Password is required']") private WebElement errorMsgPassword;
	@FindBy(xpath="//h3[text()='Epic sadface: Username is required']") private WebElement errorMsgUsername;
	
	
	
	
	
	//constructor to initialize element of pages
	public LoginPage() {
		
		PageFactory.initElements(driver,this);
	}
	
	
	public String verifyerrorMsgUsername() throws Exception {
		
		password.sendKeys(ReadData.readPropertyFile("password")); // read from config file
		//password.sendKeys(ReadData.readExcelFile(1, 1));// read from excel file
		Thread.sleep(3000);
		loginButton.click();
		Thread.sleep(3000);
		 return errorMsgUsername.getText();
	}
	
  public String verifyerrorMsgPassword() throws Exception {
		
	  userName.sendKeys(ReadData.readPropertyFile("username"));// read from config file
		Thread.sleep(3000);
		loginButton.click();
		Thread.sleep(3000);
		 return errorMsgPassword.getText();
	}
	
  public String LoginToApp() throws Exception {
		
		Thread.sleep(1000);
		//userName.sendKeys("standard_user");
	  // userName.sendKeys(ReadData.readExcelFile(0, 1));// read from excel file
		userName.sendKeys(ReadData.readPropertyFile("username"));// read from config file
		Thread.sleep(1000);
		//password.sendKeys("secret_sauce");
		password.sendKeys(ReadData.readPropertyFile("password")); // read from config file
		//password.sendKeys(ReadData.readExcelFile(1, 1));// read from excel file
		Thread.sleep(1000);
		loginButton.click();
		Thread.sleep(1000);
		return  driver.getCurrentUrl();
		
	}
	
  public String verifyProductText() throws Exception {
	  
	  LoginToApp();
	 return productText.getText();
  }
  
 
  
  
	
	public boolean verifyLoginLogo() {
		
		
		return loginLogo.isDisplayed();
		
	}
	
	public boolean verifyBottomLogo() {
		
		  return bottomLogo.isDisplayed();
		
	}
	
	
	public String verifyTitle() throws Exception
		{
		   Thread.sleep(2000);
			return driver.getTitle();//return String 
		}
	
	
	public String verifyCurrentUrl() throws Exception 
		{
		    Thread.sleep(2000);
			return driver.getCurrentUrl();
		}	
	
	
	
}
