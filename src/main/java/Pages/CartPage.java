package Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.UtilityMethod;

public class CartPage  extends TestBase{

	@FindBy(xpath="//span[@class='title']") private WebElement yourCartText;
	@FindBy(xpath="//div[text()='QTY']") private WebElement qtyLabel;
	@FindBy(xpath="//div[text()='DESCRIPTION']") private WebElement descriptionLabel;
	@FindBy(id="remove-sauce-labs-backpack") private WebElement removeBagpack;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath="//button[text()='Checkout']") private WebElement checkOutBtn;
	
	
	public CartPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyyourCartText() {
		
		 return yourCartText.getText();
	}
	
	public String  verifyqtyLabel() {
		
		 return qtyLabel.getText();
		
	}
	
	public String verifydescriptionLabel() {
		
		 return descriptionLabel.getText();
	}
	
	
   public String removeProduct() throws Exception {
	   
	   removeBagpack.click();
	   Thread.sleep(2000);
	   checkOutBtn.click();
	   Thread.sleep(2000);
	  return cartCount.getText();
   }
	
 
   
   
   
   public  void Screenshot() throws Exception {
	   
       File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       File dest= new File("C:\\Users\\ADMIN\\eclipse-workspace\\AutomationProg\\Screenshot/Photo5.jpeg");
       FileHandler.copy(source, dest);
}
  
	
}
