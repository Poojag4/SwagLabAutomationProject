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
import Pages.OverviewPage;

public class OverviewPageTest extends TestBase {
	
	InventroyPage inventory;// = new InventroyPage();
	LoginPage login ;//= new LoginPage();
	CartPage cart ; // = new CartPage();
	CheckOutPage checkout ;// = new CheckOutPage();
	OverviewPage overview ;//= new OverviewPage();
	
	
	
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
	}
	
	//@Test
	public void verifyfinishBtnTest() {
		
		boolean result = overview.verifyfinishBtn();
		Assert.assertEquals(result, true);
		Reporter.log(" Finish button displayed on Overview page:"+ result);
		
	}
	
	//@Test
	public void paymentInfoTest() throws Exception {
		
		 String actu = overview.paymentInfo();
		String exp="SauceCard #31337";
		Assert.assertEquals(actu, exp);
		Reporter.log("Payment information" +actu );
	}
	
	@Test
	public void verifyitemToatal() {
		
		 String actuToatal = overview.verifyitemToatal();
		 System.out.println(actuToatal);
		String expTotal="Item total: $75.97";
		Assert.assertEquals(actuToatal, expTotal);
		Reporter.log("Total without Tax: -->" +actuToatal );
		overview.shoppingDone();
		
	}

	
	

	
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();
	}
	

}
