package workout;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	private static final String If = null;

	public static void main (String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--diable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//1. Load the URL
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		Actions action = new Actions(driver);

		//2.Mouse over on WOMEN (Actions -> moveToElement
		action.moveToElement(driver.findElementByXPath("(//a[text()='Women'])[1]")).perform();

		//3) Click Jackets & Coats
		driver.findElementByXPath("(//a[text()='Jackets & Coats'])[1]").click();

		//4) Find the total count of item (top) -> getText -> String	
		String jackcnt = driver.findElementByClassName("title-count").getText();
		String jcnt=jackcnt.replaceAll("\\D", "");
		int totalcount = Integer.parseInt(jcnt);
		System.out.println(jcnt);

		String jack1 = driver.findElementByClassName("categories-num").getText();
		String jocketkcnt=jack1.replaceAll("\\D", "");
		Integer.parseInt(jocketkcnt);
		System.out.println("Jackets"+jocketkcnt);

		String coats = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
		String coat = coats.replaceAll("\\D", "");
		Integer.parseInt(coat);
		System.out.println("Coats"+coat);

		//5) Validate the sum of categories count matches
		Integer catgcount = Integer.parseInt(jocketkcnt)+Integer.parseInt(coat);

		if(catgcount==totalcount) {

			System.out.println("Count is Matched : "+"\n"+"Coats and Jacket is :"+catgcount+"\n"+"Total CategoryCount is"+totalcount);
		}
		else		
			System.out.println("CountNotMatched"+"Catgcount"+catgcount+"Totalcount"+totalcount);	

		//Alert alert = driver.switchTo().alert();
		//alert.accept();

		//6) Check Coats
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();


		//	driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[1]").click();

		//7) Click + More option under BRAND	
		driver.findElementByXPath("//div[@class='brand-more']").click();

		//8) Type MANGO and click checkbox
		driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']").sendKeys("MANGO");
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[11]").click();

		//9) Close the pop-up x
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();

		Thread.sleep(2000);
		//10) Confirm all the Coats are of brand MANGO
		String bname = driver.findElementByXPath("//span[@class='title-count']").getText();
		System.out.println(bname);
		
		List<WebElement> countofmangobrand = driver.findElementsByXPath("//h3[@class='product-brand']");
		
		for (WebElement eachBrand : countofmangobrand) {
			String brand=eachBrand.getText();
			System.out.println("Brand Name"+brand);
		}

		//11) Sort by Better Discount
		action.moveToElement(driver.findElementByXPath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']")).perform();
		driver.findElementByXPath("//label[text()='Better Discount']").click();
		
		Thread.sleep(3000);
		//12) Find the price of first displayed item
		String bestdiscout = driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]").getText();
		System.out.println("The price of first displayed item"+bestdiscout);
				
		//13) Mouse over on size of the first item
		action.moveToElement(driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]")).perform();
		
		//14) Click on WishList Now
		driver.findElementByXPath("//span[@class='product-actionsButton product-wishlist product-prelaunchBtn']").click();
		
		//15) Close Browser
		driver.close();

	}

}
