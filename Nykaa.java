package workout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--diable-notifications");
		Actions action = new Actions(driver);

		//1) Go to URL
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().maximize();

		//2) Mouseover on Brands and Mouseover on Popular
		action.moveToElement(driver.findElementByXPath("//a[text()='brands']")).perform();
		action.moveToElement(driver.findElementByXPath("//a[text()='Popular']")).perform();

		//3) Click L'Oreal Paris
		action.moveToElement(driver.findElementByXPath("(//li[@class='brand-logo menu-links']//img)[5]")).click().build().perform();

		//4) Go to the newly opened window and check the title contains L'Oreal Paris
		//4.a Get no of windows by using getWindowHandles in Set 
		Set<String> windowHandlesSet = driver.getWindowHandles();
		//4.b Convert Set into list to get current window
		List<String> windowHandleList =new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(windowHandleList.get(1));
		String windtitle = driver.getTitle();
		//4.c check the title contains L'Oreal Paris
		if(windtitle.contains("L'Oreal")) 
		{
			System.out.println(windtitle);
		}
		else
		{
			System.out.println("Not Matched");
		}
		Thread.sleep(5000);
		//5) Click sort By and select customer top rated 
		driver.findElementByXPath("//span[@class='pull-right']").click(); 
		driver.findElementByXPath("//span[text()='customer top rated']").click();


		//6) Click Category and click Shampoo
		driver.findElementByXPath("//div[text()='Category']").click();
		//driver.findElementByXPath("(//div[@class='control__indicator'])[30]").click();
		//driver.findElementByXPath("(//div[@class='control__indicator'])[36]").click();
		driver.findElementByXPath("//label[@for='chk_Shampoo_undefined']/span").click(); 

		//7) check whether the Filter is applied with Shampoo
		String shampooSelected = driver.findElementByXPath("//li[text()='Shampoo']").getText();

		if(shampooSelected.contains("Shampoo")) {
			System.out.println("Shampoo is seected");


		}
		else
		{
			System.out.println("Shampoo is not selected");
		}


		//8) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.xpath("//span[text()=\"L'Oreal Paris Colour Protect Shampoo\"]")).click();

		//9) GO to the new window and select size as 175ml
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List<String> windowHandlesList1= new ArrayList<String>(windowHandlesSet1);
		driver.switchTo().window(windowHandlesList1.get(2));
		driver.findElementByXPath("(//span[@class='size-pallets'])[2]").click();

		//10) Print the MRP of the product
		String mrp = driver.findElementByXPath("(//span[@class='post-card__content-price-offer'])[1]").getText();
		System.out.println("MRP of the product"+mrp);

		//11) Click on ADD to BAG
		driver.findElementByXPath("(//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-configurable m-content__product-list__cart-btn btn-disabled '])[1]").click();
		//12) Go to Shopping Bag
		driver.findElementByXPath("//div[@class='AddBagIcon']").click();

		//13) Print the Grand Total amount
		String Gtotal = driver.findElementByXPath("//div[@class='value medium-strong']").getText();
		System.out.println(Gtotal);

		//14) Click Proceed
		driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();
		//driver.findElementByXPath("(//button[contains(@class,'btn full')])[2]").click(); 

		// 		15) Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

		//16) Print the warning message (delay in shipment)
		String wmsg = driver.findElement(By.className("message")).getText();
		System.out.println(wmsg);

		//17) Close all windows
		driver.quit();	
		driver.close();














	}

}
