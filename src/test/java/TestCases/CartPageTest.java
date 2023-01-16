package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.InventroyPage;
import Pages.LoginPage;

public class CartPageTest extends TestBase {

	InventroyPage inventory;// = new InventroyPage();
	LoginPage login ;//= new LoginPage();
	CartPage cart ; // = new CartPage();
	
	@BeforeMethod //pre requist
	
	public void setup() throws Exception {
		
		initilazition();
		login = new LoginPage();
		login.LoginToApp();
		 inventory = new InventroyPage();
		 inventory.addProduct();
		  cart = new CartPage();
		
	}
	
	
	 @Test(enabled= false)
	public void verifyyourCartTextTest() {
		
		   String actText = cart.verifyyourCartText();
		   String expText="YOUR CART";
		   Assert.assertEquals(actText, expText);
		  Reporter.log("Cart Page Label :" + actText);
	}
	
	
     @Test(enabled= false)
    public void verifyqtyLabelTest() {
    	
    	 String actText = cart.verifyqtyLabel();
		   String expText="QTY";
		   Assert.assertEquals(actText, expText);
		  Reporter.log(" Qty Label :" + actText);
    	
    }
	    
	 @Test(enabled= false)
	   public void verifydescriptionLabelTest() {
		   String actText = cart.verifydescriptionLabel();
		   String expText="DESCRIPTION";
		   Assert.assertEquals(actText, expText);
		  Reporter.log(" DESCRIPTION Label :" + actText);
		   
	   }
	
	@Test(enabled= true)
	public void removeProductTest() throws Exception {
		
		String result =cart.removeProduct();
		Assert.assertEquals(result, "3");
		Reporter.log(" Total Count of product : "  +result );
		//cart.checkOutBtnClick();
		//cart.Screenshot();
		Thread.sleep(2000);
	    
	}
	
	@Test(enabled= true)
	public void ScreenshotTest() throws Exception {
		
		cart.Screenshot();
	}
	   
	
	   
	@AfterMethod
	
	public void closeBrowser() {
		
		driver.close();
	}
	
	
	
}
