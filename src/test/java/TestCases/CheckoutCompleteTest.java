package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.CheckoutComplete;
import Pages.InventroyPage;
import Pages.LoginPage;
import Pages.OverviewPage;

public class CheckoutCompleteTest extends TestBase {

	

	InventroyPage inventory;// = new InventroyPage();
	LoginPage login ;//= new LoginPage();
	CartPage cart ; // = new CartPage();
	CheckOutPage checkout ;// = new CheckOutPage();
	OverviewPage overview ;//= new OverviewPage();
	CheckoutComplete orderDone ; //= new CheckoutComplete();
	
	
	@BeforeMethod
	public void setup() throws Exception {

		initilazition();
		login = new LoginPage();
		login.LoginToApp();
		 inventory = new InventroyPage();
		 inventory.addProduct();
		  cart = new CartPage();
		  cart.removeProduct();
		  checkout = new CheckOutPage();
		  checkout.personaInfo();
		  overview = new OverviewPage();
		  overview.shoppingDone();
		  orderDone= new CheckoutComplete();
	}
	
	//@Test
	public void verifypalcedorderTextTest() throws Exception {
		
	   String actText = orderDone.verifypalcedorderText();
	   String expText="THANK YOU FOR YOUR ORDER";
	   Assert.assertEquals(actText, expText);
	   Reporter.log(" Order Palced Text:" + actText);
	   
	}
	
	
	//@Test
	public void verifyponySwagLogoTest() throws Exception {
		boolean actLogo=orderDone.verifyponySwagLogo();
		Assert.assertEquals(actLogo, true);
		Reporter.log(" Pony logo displayed on last page:" + actLogo);
		
	}
	
	
	//@Test
	public void verifybackHomebtnTest() {
		String acturl=orderDone.verifybackHomebtn();
		String exep = "https://www.saucedemo.com/";
		Assert.assertEquals(acturl, exep);
		Reporter.log(" URL of web application:" + acturl);
		
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	
}
