package workout;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StoreHpLaptops {

	public static void main (String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);
		Actions action = new Actions(driver);


//1) Go to https://store.hp.com/in-en/
		driver.get("https://store.hp.com/in-en/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		try {
			driver.findElementByXPath("//button[@class='optanon-allow-all accept-cookies-button']").click();
		}
		catch (NoSuchElementException exception) {
			System.out.println("Exception3 is catched");
		}

		try {
			driver.findElementByXPath("//span[@class='optly-modal-close close-icon']").click();
		}
		catch (NoSuchElementException exception) {
			System.out.println("Exception2 is catched");
		}

		

//2) Mouse over on Laptops menu and click on Pavilion
		Thread.sleep(2000);
		action.moveToElement(driver.findElementByXPath("//span[text()='Laptops']")).pause(2000).perform();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@id='ui-id-43']//span[1]").click();


		try {
			driver.findElementByXPath("//div[@class='inside_closeButton fonticon icon-hclose']").click();
		}
		catch (NoSuchElementException exception) {
			System.out.println("Exception3 is catched");
		}

		try {
			driver.findElementByXPath("//button[text()='Accept Cookies']").click();
		}
		catch (NoSuchElementException exception) {
			System.out.println("Exception2 is catched");
		}

		try {
			driver.findElementByXPath("//span[@class='optly-modal-close close-icon']").click();
		}
		catch (NoSuchElementException exception) {
			System.out.println("Exception1 is catched");
		}

		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0, 250)");
		

//3) Under SHOPPING OPTIONS -->Processor -->Select Intel Core i7
		Thread.sleep(3000);
		driver.findElementByXPath("(//span[text()='Processor'])[2]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//span[text()='Intel Core i7']").click();
		

//4) Hard Drive Capacity -->More than 1TB
		driver.findElementByXPath("//span[text()='More than 1 TB']").click();
		
//5) Select Sort By: Price: Low to High
		WebElement sortcombo = driver.findElementByXPath("(//select[@class='sorter-options option-new'])[1]");
		Select sortcomboprc = new Select(sortcombo);
		sortcomboprc.selectByValue("price_asc");
		Thread.sleep(3000);

//	6) Print the First resulting Product Name and Price
		List<WebElement> firstlap = driver.findElementsByXPath("(//img[@class='product-image-photo'])[2]");
		WebElement lpname = firstlap.get(0);
		System.out.println(lpname);
		String price = driver.findElementByXPath("(//span[@data-price-type='finalPrice']//span)[1]").getText();
		String prc=price.replaceAll("\\D", "");
		int price1 = Integer.parseInt(prc);
		System.out.println(price1);

//	7) Click on Add to Cart
		Thread.sleep(3000);
		driver.findElementByXPath("(//span[text()='Add To Cart'])[1]").click();


//8) Click on Shopping Cart icon --> Click on View and Edit Cart
		Thread.sleep(3000);
		driver.findElementByXPath("//a[@class='action showcart']").click();
		driver.findElementByXPath("(//div[@class='primary']//a)[1]").click();


//9) Check the Shipping Option --> Check availability at Pincode
		driver.findElementById("block-deliver-heading").click();
		driver.findElementByXPath("//input[@placeholder='Pincode']").sendKeys("609110");
		driver.findElementByXPath("//button[text()='check']").click();
		Thread.sleep(5000);
		

//10) Verify the order Total against the product price
		String ordervalue = driver.findElementByXPath("(//td[@class='amount']//span)[3]").getText();
		String ordval =ordervalue.replaceAll("\\D", "");
		int price2 = Integer.parseInt(ordval);

		if (price1==price2) {
			System.out.println("Order Total and Product  Price Matched");
			driver.findElementByXPath("(//span[text()='Proceed to Checkout'])[1]").click();
		}
		else
			System.out.println("Order Total and Product  Price Matched are not matchd");


//	11) Proceed to Checkout if Order Total and Product Price matches
		driver.findElementByXPath("//span[text()='Proceed to Checkout']").click();
		
		
//12) Click on Place Order
		driver.findElementByXPath("(//span[text()='Place Order'])[3]").click();
		
		
//13) Capture the Error message and Print
		String errmsg = driver.findElementByXPath("//div[@class='message notice']").getText();
		System.out.println(errmsg);
		
//	14) Close Browser
		driver.close();

	}
}


