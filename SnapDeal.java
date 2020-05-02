package workout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapDeal {
	
	public static void main(String args[]) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--diable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait Wait = new WebDriverWait(driver,10);
		Actions action = new Actions(driver);
	
//	1) Go to https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
//		‎2) Mouse over on Toys, Kids' Fashion & more and click on Toys
		Thread.sleep(5000);
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[contains(text(),'Toys, Kids')]")));
		action.moveToElement(driver.findElementByXPath("//span[contains(text(),'Toys, Kids')]")).build().perform();
		System.out.println("Mouse overed on Toys, Kids' Fashion & more is clicked");
		
//		3) Click Educational Toys in Toys & Games
		driver.findElementByXPath("//span[text()='Educational Toys']").click();
		System.out.println("Educational Toys in Toys & Games is clicked");
		Thread.sleep(3000);
		
//		‎4) Click the Customer Rating 4 star and Up 
//		driver.findElementByXPath("//div[@class='comp-left-filter']/div[7]/div[1]//span[1]").click();
		driver.findElementByXPath("//label[@for='avgRating-4.0']").click();
		Thread.sleep(3000);
//		System.out.println("Customer Rating 4 star and Up is Clicked");
//		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//label[@for='avgRating-4.0']")));
//		driver.findElementByXPath("//label[@for='avgRating-4.0']").click();
//		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@class='filters-top-selected']//a[text()='4.0']")));
//		if(driver.findElementByXPath("//div[@class='filters-top-selected']//a[text()='4.0']").isDisplayed()==true)
//		{
//			System.out.println("Applied Filter -> customer rating 4 star and Up");
//		}
//		else
//		{
//			System.out.println("Filter Not applied -> customer rating 4 star and Up");
//		}
		
		
//		5) Click the offer as 40-50
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//label[@for='discount-40 - 50']")));
		action.moveToElement(driver.findElementByXPath("//label[@for='discount-40 - 50']")).click().build().perform();
		Thread.sleep(1000);
		if(driver.findElementByXPath("//div[@class='filters-top-selected']//a[text()='40 - 50']").isDisplayed()==true)
		{
			System.out.println("Discount 40 to 50 is checked%");
		}
		else
		{
			System.out.println("Discount 40 to 50 is not checked");
		}
	
		
//		6) Check the availability for the pincode
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@class='pincode-enter js-pincode-enter']/input[1]")));
		action.moveToElement(driver.findElementByXPath("//div[@class='pincode-enter js-pincode-enter']/input[1]")).sendKeys("6090110").perform();
		System.out.println("Pin code Value is Passed");
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@class='pincode-enter js-pincode-enter']/button[1]")));
		action.moveToElement(driver.findElementByXPath("//div[@class='pincode-enter js-pincode-enter']/button[1]")).click().build().perform();
		System.out.println("CheckButton is clicked");
		
//		7) Click the Quick View of the first product
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//div[@class='product-tuple-description ']/div[1]//p[1])[1]")));
		action.moveToElement(driver.findElementByXPath("//div[@class='pincode-enter js-pincode-enter']/input[1]")).sendKeys("6090110").perform();
		System.out.println("Pin code Value is Passed");
		//driver.findElementByXPath("(//div[contains(text(),'Quick View')])[1]").click();
		driver.findElementByXPath("(//div[contains(@class,'center quick-view-bar')])[1]").click();
	
		
//		8) Click on View Details
		Thread.sleep(4000);
		driver.findElementByXPath("//a[@class=' btn btn-theme-secondary prodDetailBtn']").click();
		
//		9) Capture the Price of the Product and Delivery Charge
		Thread.sleep(2000);
		String price = driver.findElementByXPath("//div[@class='col-xs-14 reset-padding padL8']/div[1]//span[1]/span").getText();
		double cnprice = Double.parseDouble(price);
		System.out.println(price);
		System.out.println(cnprice);
		
		
		String shipping = driver.findElementByXPath("//div[@id='deliveryOptionsTooltip']/div[1]/div[1]/span[2]/span[2]").getText();
		String sshipping=shipping.replaceAll("\\D", "");
		double cnshipping = Double.parseDouble(sshipping);
		System.out.println(shipping);
		System.out.println(cnshipping);
	
		double pop = cnprice+cnshipping;
		System.out.println(pop);
		
		driver.findElementByXPath("//span[text()='add to cart']").click();
		
//		10) Validate the You Pay amount matches the sum of (price+deliver charge)
		
		String ypamt = driver.findElementByXPath("//div[@class='you-pay']/span[1]").getText();
		String YouPayAmt = ypamt.replaceAll("\\D", "");
		double YPA = Double.parseDouble(YouPayAmt);
		System.out.println(YouPayAmt);
		System.out.println(YPA);
		
		if(YPA==pop) 
		{
			System.out.println("You Pay Amount Matches with Sum of Price and DeliveryCharges");	
		}
		else
			System.out.println("You Pay Amount Matches with Sum of Price and DeliveryCharges");
		
		
//		11) Search for Sanitizer
		driver.findElementByXPath("//div[@class='overlap']/following-sibling::input[1]").sendKeys("Sanitizer");
		
//		12) Click on Product "BioAyurveda Neem Power Hand Sanitizer"
		driver.findElementByXPath("//p[text()='BioAyurveda Neem Power  Hand Sanitizer 500 mL Pack of 1']").click();
		
		Set<String> winSet = driver.getWindowHandles();
		List<String> Sanwind = new ArrayList<>(winSet);
		driver.switchTo().window(Sanwind.get(1));
		
		double sanipri = Double.parseDouble(driver.findElementByXPath("//span[@itemprop='price']").getText());
		double delicha = Double.parseDouble(driver.findElementByXPath("(//span[@class='availCharges'])[2]").getText().replaceAll("\\D", ""));
		double SantiPrice = sanipri+delicha;
		
		
//		14) Click on Add to Cart
		driver.findElementByXPath("//span[text()='ADD TO CART']").click();
//		15) Click on Cart 
		Thread.sleep(3000);
		driver.findElementByXPath("//span[@class='cartTextSpan']//following-sibling::i").click();
//		16) Validate the Proceed to Pay matches the total amount of both the products
		double totalprice = Double.parseDouble(driver.findElementByXPath("//input[@type='button']").getAttribute("value").replaceAll("\\D", ""));
		System.out.println("Final Total: "+totalprice);
		System.out.println("Total of two products: "+(YPA+SantiPrice));
		if((YPA+SantiPrice)==totalprice) 
		{
			System.out.println("Valiadated the total amount");
		}
}
}