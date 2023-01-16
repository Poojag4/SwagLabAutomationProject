package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.org.apache.bcel.internal.classfile.Utility;

import Base.TestBase;
import Utility.ReadData;

public class CheckOutPage extends TestBase {


	//Object Repository
	
   @FindBy(xpath="//input[@id='continue']") private WebElement ContinButton;
   @FindBy(xpath="//span[text()='Checkout: Your Information']") private WebElement checkoutLabel;
   @FindBy(xpath="//input[@id='first-name']") private WebElement firstName;
   @FindBy(name="lastName") private WebElement lastName ;
   @FindBy(xpath="//input[@id='postal-code']") private WebElement zipcode;
   @FindBy(xpath="//h3[text()='Error: First Name is required']") private WebElement ErrorMessageFirst;
   @FindBy(xpath="//h3[text()='Error: Last Name is required']") private WebElement ErrorMessageLast;
   @FindBy(xpath="//h3[text()='Error: Postal Code is required']") private WebElement  ErrorMessageZipCode;
	
	
	public CheckOutPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public  String verifyCheckOutPageUrl() {
		
		 return driver.getCurrentUrl();
		
	}
	
	public boolean verifyContinButton() {
		
		 return ContinButton.isDisplayed();	
	}
	
	
	public String verifycheckoutLabel() {
		 return checkoutLabel.getText();
	}
	
	public String personaInfo() throws Exception {
		Thread.sleep(1000);
		//firstName.sendKeys("harry");
		firstName.sendKeys(ReadData.readExcelFile(2, 1));
		Thread.sleep(1000);
		//lastName.sendKeys("potter");
		lastName.sendKeys(ReadData.readExcelFile(3, 1));
		Thread.sleep(1000);
		//zipcode.sendKeys("123456");
		zipcode.sendKeys(ReadData.readExcelFile(4, 1));
		ContinButton.click();
		Thread.sleep(1000);
		return driver.getCurrentUrl();
		
	}
	
	public String verifyErrorMessageFirst() throws Exception {
		lastName.sendKeys(ReadData.readExcelFile(3, 1));
		Thread.sleep(1000);
		//zipcode.sendKeys("123456");
		zipcode.sendKeys(ReadData.readExcelFile(4, 1));
		ContinButton.click();
		 return ErrorMessageFirst.getText();
	}
	
	public String verifyErrorMessageLast() throws Exception {
		firstName.sendKeys(ReadData.readExcelFile(2, 1));
		Thread.sleep(1000);
		zipcode.sendKeys(ReadData.readExcelFile(4, 1));
		Thread.sleep(1000);
		ContinButton.click();
		  return ErrorMessageLast.getText();
	}
	
	
	public String verifyErrorMessageZipCode() throws Exception {
		firstName.sendKeys(ReadData.readExcelFile(2, 1));
		Thread.sleep(1000);
		lastName.sendKeys(ReadData.readExcelFile(3, 1));
		Thread.sleep(1000);
		ContinButton.click();
		  return ErrorMessageZipCode.getText();
	}
	
	
}
