package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.InventroyPage;
import Pages.LoginPage;

public class CheckOutPageTest  extends TestBase{
	
	InventroyPage inventory;// = new InventroyPage();
	LoginPage login ;//= new LoginPage();
	CartPage cart ; // = new CartPage();
	CheckOutPage checkout ;// = new CheckOutPage();
	
	
	@BeforeMethod
	public void setup() throws Exception {
		
		initilazition();
		login = new LoginPage();
		login.LoginToApp();
		 inventory = new InventroyPage();
		 inventory.addProduct();
		  cart = new CartPage();
		  checkout = new CheckOutPage();
		  cart.removeProduct();
			
		
	}
	
	@Test(enabled = true)
	public void verifyCheckOutPageUrlTest() {
		
		 String  actuUrl=checkout.verifyCheckOutPageUrl();
		 String expUrl="https://www.saucedemo.com/checkout-step-one.html";
		 Assert.assertEquals(actuUrl, expUrl);
		 Reporter.log("Checkout pahe url:" + actuUrl);
		   
	}

	@Test(enabled = true)
	public void verifyContinButtonTest() {
		
		 boolean result = checkout.verifyContinButton();
		 Assert.assertEquals(result, true);
		 Reporter.log(" RedCountinue button displayed on page :" +result );
	}
	
	
	@Test(enabled = true)
	public void verifycheckoutLabelTest() {
		
		 String actLabel=checkout.verifycheckoutLabel();
		 String expLabel="CHECKOUT: YOUR INFORMATION";
		 Assert.assertEquals(actLabel, expLabel);
		 Reporter.log("Label of chechout page:" +actLabel);
	}
	
	
	
	@Test(enabled = true)
	public void personaInfoTest() throws Exception {
		
		  String actUrl=checkout.personaInfo();
		  String expUrl="https://www.saucedemo.com/checkout-step-two.html";
		  Assert.assertEquals(actUrl, expUrl);
		  Reporter.log(" OverView Page Url: "+ actUrl);
		
		
	}
	
	@Test(enabled = true)
	 public void verifyErrorMessageFirstTest() throws Exception {
	    
		 String result = checkout.verifyErrorMessageFirst();
		 Reporter.log( "Error message :"+result);
		 System.out.println(result);
		 
	 }
	
	@Test(enabled = true)
	 public void verifyErrorMessageLastTest() throws Exception {
	    
		 String result = checkout.verifyErrorMessageLast();
		 Reporter.log( "Error message :"+result);
		 System.out.println(result);
		 
	 }
	
	@Test(enabled = true)
	 public void verifyErrorMessageZipCodeTest() throws Exception {
	    
		 String result = checkout.verifyErrorMessageZipCode();
		 Reporter.log( "Error message :"+result);
		 System.out.println(result);
		 
	 }
	
	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
}
