package workout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ajio {
	
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--diable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait Wait = new WebDriverWait(driver,10);
		Actions action = new Actions(driver);
		
//1)		//www.ajio.com/shop/sale
		driver.get("https://www.ajio.com/shop/sale");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("URL Loaded");
		
//		2) Enter Bags in the Search field and Select Bags in Women Handbags
		driver.findElementByName("searchVal").sendKeys("Bags");
		Wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//span[text()='Bags in '])[1]")));
		driver.findElementByXPath("(//span[text()='Bags in '])[1]").click();
		System.out.println("Select Bags in Women Handbags");
		Thread.sleep(5000);
		
//		3) Click on five grid and Select SORT BY as "What's New"
		driver.findElementByXPath("//div[@class=\"five-grid\"]").click();
		WebElement Searchfielddrpdwn= driver.findElementByXPath("//div[@class=\"filter-dropdown\"]/select");
		Select option = new Select(Searchfielddrpdwn);
		option.selectByVisibleText("What's New");
		System.out.println("Select Bags in Women Handbags");
		Thread.sleep(5000);
		
//		4) Enter Price Range Min as 2000 and Max as 5000
		driver.findElementByXPath("//span[text()='price']").click();
		Wait.until(ExpectedConditions.visibilityOf(driver.findElementById("minPrice")));
		driver.findElementById("minPrice").sendKeys("2000");
		driver.findElementById("maxPrice").sendKeys("5000");
		driver.findElementByXPath("//button[@class=\"rilrtl-button ic-toparw\"]").click();
		System.out.println("Min and MaxPrice is  applied");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-1000)");
//		5) Click on the product "Puma Ferrari LS Shoulder Bag".
		Wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[text()='Ferrari LS Shoulder Bag']")));
		Thread.sleep(5000);
		
		driver.findElementByXPath("//div[text()='Ferrari LS Shoulder Bag']").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		System.out.println("Puma Ferrari LS Shoulder Bag");
		
//		6) Verify the Coupon code for the price above 2690 is applicable for your product, 
//		if applicable the get the Coupon Code and Calculate the discount price for the coupon
		int actualprice = Integer.parseInt(driver.findElementByXPath("//div[@class=\"prod-sp\"]").getText().replaceAll("\\D", ""));
		String couponcode ="";
		
		String dispr = driver.findElementByClassName("promo-desc").getText();
		System.out.println(dispr);
		
		String[] prc = dispr.split("on", 2);
		
		int prs = Integer.parseInt(prc[1].replaceAll("[^0-9]", ""));
		System.out.println("Price of discount = " + prs);
		
		int per = Integer.parseInt(prc[0].replaceAll("[^0-9]", ""));
		System.out.println("Discount percentage = " + per);

		String discd = driver.findElementByXPath("//div[@class='promo-title']").getText();
		String discd1 = discd.replaceAll("Use", "");
		String discd2 = discd1.replaceAll("Code", "");
		String discd3 = discd2.replaceAll("\\s", "");

		if (actualprice > prs) {
			System.out.println("Coupon is applicable");
			System.out.println("Code is ****" + discd3 + "**");

		} else {
			System.out.println("Discount is not applicable");
		}

		System.out.println("Calculating the Discount Price");
		float pers = per / 100.0f;
		float disprc = actualprice * pers;
		long disp = Math.round(disprc);
		System.out.println("Discount price = " + disp);
		long disprce = actualprice - disp;
		System.out.println("Price after discount =" + disprce);

		Thread.sleep(2000);
		System.out.println("Coupen code verified");
		
//		7) Check the availability of the product for pincode 560043, print the expected delivery date if it is available
		//this pinc code is used 609110
		driver.findElementByCssSelector("div#edd>div>div>span:nth-of-type(2)").click();
		Thread.sleep(2000);
		driver.findElementByName("pincode").sendKeys("609110");
		driver.findElementByClassName("edd-pincode-modal-submit-btn").click();
		Thread.sleep(2000);
		System.out.println("Pin code verified");
		
		
//		8) Click on Other Informations under Product Details and Print the Customer Care address,
//		phone and emailjs.executeScript("window.scrollBy(0,500)");
		driver.findElementByXPath("//div[text()='Other information']").click();
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,500)");
		String CustCareAdd = driver.findElementByXPath("//span[text()='Customer Care Address']/following::span[2]").getText();
		System.out.println(CustCareAdd);
		Thread.sleep(5000);
		
//		9) Click on ADD TO BAG and then GO TO BAG
		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
		System.out.println("Add To Bag is done");
		Thread.sleep(5000);
		driver.findElementByXPath("//div[@class=\"ic-cart \"]").click();
		System.out.println("Go To Bag is done");
		
//		10) Check the Order Total before apply coupon
		Wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[@class=\"price-value bold-font\"]")));
		int before = Integer.parseInt(driver.findElementByXPath("//span[@class=\"price-value bold-font\"]").getText().replaceAll("\\D", "").substring(0,4));
		if (actualprice == before) {
			System.out.println("Order Total before apply coupon are equal");
		}else {
			System.out.println("Order Total before apply coupon are not equal");
		}
		
//		11) Enter Coupon Code and Click Apply
		driver.findElementById("couponCodeInput").sendKeys(discd3);
		driver.findElementByXPath("//button[text()='Apply']").click();
		Thread.sleep(2000);
		
//		12) Verify the Coupon Savings amount(round off if it in decimal) 
//		?under Order Summary and the matches the amount calculated in Product details
		String saamt = driver.findElementByCssSelector("section#couponDiscount>span:nth-of-type(2)").getText();
		String[] amtt = saamt.split("Rs.", 2);
		float smt = Float.parseFloat(amtt[1]);
		long samt = Math.round(smt);
		System.out.println("Coupon savings amount = " + samt);

		if (samt == disp) {
			System.out.println("Discount price matches");
		} else {
			System.out.println("Discount price does not match");
		}
		Thread.sleep(2000);
		
//		13) Click on Delete and Delete the item from Bag
		driver.findElementByClassName("delete-btn").click();
		driver.findElementByXPath("//div[text()='DELETE']").click();
		String empmg = driver.findElementByClassName("empty-msg").getText();
		System.out.println(empmg);

		
//		14) Close all the browsers
		driver.quit();
		
	}

}
