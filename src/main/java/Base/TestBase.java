package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.ReadData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	
	public static WebDriver driver;
	//This method will open the browser and enter the URL
	public void initilazition() throws Exception
	 {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(ReadData.readPropertyFile("url"));
		System.out.println(" Chrome browser will open and url enter");
		//driver.get("https://www.saucedemo.com/");
		
		
   }

	
	
}
