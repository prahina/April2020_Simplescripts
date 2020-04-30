package workout;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pepperfry {
	
	public static void main(String args[]) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		DesiredCapabilities capabilites = new DesiredCapabilities().chrome();
		ChromeDriver driver = new ChromeDriver();
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		WebListen listen = new WebListen(edriver);
		edriver.register(listen);
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--diable-notifications");
		
//		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait wt = new WebDriverWait(driver,10);
		Actions action = new Actions(driver);
		
	
//1) Go to https://www.pepperfry.com/
		edriver.get("https://www.pepperfry.com/");
		System.out.println("URL Loaded");
		edriver.manage().window().maximize();
		edriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
//2) Mouseover on Furniture and click Office Chairs under Chairs
		wt.until(ExpectedConditions.elementToBeClickable(edriver.findElement(By.xpath("//a[text()='Furniture']"))));
		action.moveToElement(edriver.findElement(By.xpath("//a[text()='Furniture']"))).build().perform();
		System.out.println("Furniure is mouseovered");
		
		wt.until(ExpectedConditions.elementToBeClickable(edriver.findElement(By.xpath("//a[text()='Office Chairs']"))));
		action.moveToElement(edriver.findElement(By.xpath("//a[text()='Office Chairs']"))).click().build().perform();
		System.out.println("Chair is Clicked");
		
		
//3) click Executive Chairs
		wt.until(ExpectedConditions.elementToBeClickable(edriver.findElement(By.xpath("//img[@alt='Executive Chairs']"))));
		action.moveToElement(edriver.findElement(By.xpath("//img[@alt='Executive Chairs']"))).click().build().perform();
		System.out.println("Executive Chair is Clicked");
				
				
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		
//4) Change the minimum Height as 50 in under Dimensions
		wt.until(ExpectedConditions.visibilityOf(edriver.findElement(By.xpath("//input[@class='clipFilterDimensionHeightValue']"))));
		action.moveToElement(edriver.findElement(By.xpath("//input[@class='clipFilterDimensionHeightValue']"))).sendKeys("50",Keys.TAB);
		System.out.println("Minimum Height as 50 is clicked ");
		
//5) Add "Poise Executive Chair in Black Colour" chair to Wishlist
		wt.until(ExpectedConditions.visibilityOf(edriver.findElement(By.xpath("//img[@alt='Poise Executive Chair in Black Colour']"))));
		action.moveToElement(edriver.findElement(By.xpath("//img[@alt='Poise Executive Chair in Black Colour']"))).build().perform();
		edriver.findElement(By.xpath("//div[@class='row clip-dtl-brand']/div[@class='clip-prd-hrt pf-col xs-2']/a[@data-productname='Poise Executive Chair in Black Colour']")).click();
		System.out.println("Poise Executive Chair in Black Colour  is added in WishList ");
		
	
//6) Mouseover on Homeware and Click Pressure Cookers under Cookware
		action.moveToElement(edriver.findElement(By.xpath("(//a[text()='Homeware'])[1"))).build().perform();
		edriver.findElement(By.xpath("(//a[text()='Pressure Cookers'])[1]")).click();
//		edriver.findElement(By.xpath("(//a[text()='Pressure Cookers'])[1]")).click();
		System.out.println("Pressure Cooker is Selected");
		
		
//7) Select Prestige as Brand
		//(//a[text()='Pressure Cookers'])[1]
		//a[text()='Pressure Cookers']
		wt.until(ExpectedConditions.visibilityOf(edriver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::label)[1]"))));
		action.moveToElement(edriver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::label)[1]"))).click().build().perform();
		System.out.println("Brand is Checked");
		
//8) Select Capacity as 1-3 Ltr
		wt.until(ExpectedConditions.elementToBeClickable(edriver.findElement(By.xpath("//input[@name='capacity_db']/following-sibling::label[1]"))));
		action.moveToElement(edriver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::label)[1]"))).click().build().perform();
		System.out.println("Capacti 1-3 Ltr is checked");
			
		
//9) Add "Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr" to Wishlist
		wt.until(ExpectedConditions.elementToBeClickable(edriver.findElement(By.xpath("//input[@name='capacity_db']/following-sibling::label[1]"))));
		action.moveToElement(edriver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::label)[1]"))).click().build().perform();
		edriver.findElement(By.xpath("//div[@class='row clip-dtl-brand']/div[@class='clip-prd-hrt pf-col xs-2']/a[@data-productname='Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr']")).
		click();
		System.out.println("Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr");
		
		
//10) Verify the number of items in Wishlist
		String noofitems = edriver.findElement(By.xpath("//div[@class='wishlist_bar']/a[1]/following-sibling::span[1]")).getText();
		if(noofitems.equals("2")) 
		{
			System.out.println("No.of items in Wishlist is correct");
		}
		else
		{
			System.out.println("No.of items in Wishlist is incorrect");
		}
		
		
//11) Navigate to Wishlist
		edriver.findElement(By.xpath("//div[@class='wishlist_bar']/a[1]")).click();
		System.out.println("Navigate to WishList");
		
//12) Move Pressure Cooker only to Cart from Wishlist
		
		edriver.findElement(By.xpath("//div[@class='mini_cart capitalize active']/div[3]/div[1]/a[1]")).click();
		System.out.println("Compact view is clicked");
		
		List<WebElement> PrdList = edriver.findElements(By.xpath("//div[@class='item_details']/p[1]"));
		
		for (int i = 0; i < PrdList.size(); i++) 
		{
			if(PrdList.get(i).getText().contains("Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr")) 
			{
				edriver.findElement(By.xpath("//div[@class='action_block']/a[@class='addtocart_icon']")).click();
			}
		}
		System.out.println(" Pressure Cooker only Added to Cart");

		
//13) Check for the availability for Pincode 600128
		edriver.findElement(By.xpath("//div[@class='pin_block']/input[1]")).sendKeys("609101");
		System.out.println(" Pincode only verified");
		
		
//14) Click Proceed to Pay Securely
		edriver.findElement(By.xpath("//div[@id='minicart_footer']//a[text()='Proceed to pay securely ']")).click();
		System.out.println(" Pay Securely is clicked");
		
//15 Click Proceed to Pay
		Thread.sleep(5000);
		wt.until(ExpectedConditions.elementToBeClickable(edriver.findElement(By.xpath("//a[text()='PLACE ORDER']"))));
		action.moveToElement(edriver.findElement(By.xpath("//a[text()='PLACE ORDER']"))).click().build().perform();
		System.out.println(" Place Order is Clicked");
		
//16) Capture the screenshot of the item under Order Item
		edriver.findElement(By.xpath("//div[@id='ordersummary_accrodian']/div[1]/div[2]/span[1]")).click();
		
		WebElement cookerimage = edriver.findElement(By.xpath("//li[@class='onepge_ordersummary slick-slide slick-current slick-active']"));
		File src = cookerimage.getScreenshotAs(OutputType.FILE);
		File dest = new File("./sshots/cookerimage.png");
		FileUtils.copyFile(src, dest);
		
	
//17) Close the browser
		
		edriver.unregister(listen);
		edriver.close();
		
	}

}
