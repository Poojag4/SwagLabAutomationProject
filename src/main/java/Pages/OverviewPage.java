package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class OverviewPage  extends TestBase{

	//object Repository
	
	@FindBy(xpath="//button[text()='Finish']") private WebElement finishBtn;
	@FindBy(xpath="//div[text()='SauceCard #31337']") private WebElement paymentInfo;
	@FindBy(xpath="//div[@class='summary_subtotal_label']") private WebElement itemToatal;
	
	public OverviewPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyfinishBtn() {
		
		
		 return finishBtn.isDisplayed();
	}
	
	public String paymentInfo() throws Exception {
		
		Thread.sleep(1000);
		 return paymentInfo.getText();
	}
	
	
	public String verifyitemToatal() {
		
		 return itemToatal.getText();
	}
	
	
	public void shoppingDone() {
		
		finishBtn.click();
	}
}
