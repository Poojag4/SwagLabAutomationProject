package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckoutComplete  extends TestBase{

	
	@FindBy(xpath=" //h2[@class='complete-header']") private WebElement palcedorderText;
	@FindBy(xpath="//img[@class='pony_express']") private WebElement ponySwagLogo;
	@FindBy(xpath="//button[@id='back-to-products']") private WebElement backHomebtn;
	
	
	public CheckoutComplete() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifypalcedorderText() throws Exception {
		
		Thread.sleep(3000);
		 return palcedorderText.getText();
	}
	
	
	public boolean verifyponySwagLogo() throws Exception {
		Thread.sleep(3000);
		 return ponySwagLogo.isDisplayed();
		
	}
	
	
	public String verifybackHomebtn() {
		
		backHomebtn.click();
		 return driver.getCurrentUrl();
	}
}
