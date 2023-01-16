package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import Utility.UtilityMethod;

public class InventroyPage extends TestBase {

	
	//object repository
	@FindBy(xpath ="//span[text()='Products']") private WebElement productText;
	@FindBy(xpath ="//div[@class='peek']") private WebElement redLogoPeek;
	@FindBy(xpath ="//img[@class='footer_robot']") private WebElement footerLogo;
	@FindBy(xpath ="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(id="add-to-cart-sauce-labs-backpack") private WebElement Backpack;
	@FindBy(id="add-to-cart-sauce-labs-bike-light") private WebElement bikeLight;
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt") private WebElement boltTShirt;
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket") private WebElement  fleeceJacket;
	@FindBy(xpath ="//select[@class='product_sort_container']") private WebElement sortproductDropdown;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement countbasket;
	@FindBy(id="remove-sauce-labs-backpack") private WebElement BackpackRemove;
	
	
	
	

		public InventroyPage() {
				
				PageFactory.initElements(driver,this);
			}
		
		
		
	public String verifyInvCurrentUrl() {
		
		 return driver.getCurrentUrl();	
	}
	
	public String verifyProductText() {
		
		 return productText.getText();
		
	}
	
	public boolean verifyredLogoPeek() {
		
		 return redLogoPeek.isDisplayed();
	}
	
	
	public boolean  verifyfooterLogo() {
		
		 return footerLogo.isDisplayed();
	}
	
	
	public boolean verifytwitterLogo() {
		
		 return twitterLogo.isDisplayed();
	}
	
	
	public String addProduct() throws Exception {
		UtilityMethod.selectClassMethod(sortproductDropdown, "Name (Z to A)");
		Thread.sleep(2000);
		Backpack.click();
		 Thread.sleep(1000);
		 BackpackRemove.click();
		 Thread.sleep(1000);
		 Backpack.click();
		 Thread.sleep(1000);
		bikeLight.click();
		 Thread.sleep(1000);
		boltTShirt.click();
		 Thread.sleep(1000);
		fleeceJacket.click();
		 Thread.sleep(1000);
		//Select s = new Select(sortproductDropdown);
		
		//s.selectByVisibleText("Name (Z to A)");
		countbasket.click();
		Thread.sleep(3000);
		return countbasket.getText();
		
	}
	
	
	
}


