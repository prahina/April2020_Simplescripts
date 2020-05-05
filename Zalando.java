package workout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zalando {

	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--diable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait Wait = new WebDriverWait(driver,10);
		
		Actions action = new Actions(driver);


		//		1) Go to https://www.zalando.com/
		driver.get("https://www.zalando.com/");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

//2) Get the Alert text and print it
		try {
			WebDriverWait Wt = new WebDriverWait(driver,2);
			Wt.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String alertext = alert.getText();
			System.out.println(alertext);

//	3) Close the Alert box and click on Zalando.uk
			alert.accept();
		} catch(Exception e) 
		{}
				driver.findElementByXPath("//a[@class='nav_link nav_link-gb']").click();


//4) Click Women--> Clothing and click Coat 
		Thread.sleep(4000);
		//		driver.switchTo().frame(1);
		//		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//button[@id='uc-btn-accept-banner']")));
		//		action.moveToElement(driver.findElementByXPath("//button[@id='uc-btn-accept-banner']]")).build().perform();
		//		System.out.println("That ok is clicked");
		//		driver.switchTo().defaultContent();
		try {
			Wait.until(
					ExpectedConditions.visibilityOf(driver.findElementByXPath("//button[@id='uc-btn-accept-banner']")));
			driver.findElementByXPath("//button[@id='uc-btn-accept-banner']").click();
		} catch (Exception e) {
			System.out.println("msg not diplayed");
		}

		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@class='z-navicat-header_navContainer']//a[1]//span[text()='Women']")));
		action.moveToElement(driver.findElementByXPath("//div[@class='z-navicat-header_navContainer']//a[1]//span[text()='Women']")).build().perform();
		System.out.println("Women is MouseOvered");

		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Clothing']")));
		action.moveToElement(driver.findElementByXPath("//span[text()='Clothing']")).build().perform();
		System.out.println("Clothing is MouseOvered");

		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//a[@class='z-navicat-header_subCategoryLink']//span[text()='Coats']")));
		action.moveToElement(driver.findElementByXPath("//a[@class='z-navicat-header_subCategoryLink']//span[text()='Coats']")).click().build().perform();
		System.out.println("Coat is clicked");


		//		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Women']")));
		//		action.moveToElement(driver.findElementByXPath("//span[text()='Women']")).click().build().perform();
		//		System.out.println("Womenis clicked");
		//		

//	5) Choose Material as cotton (100%) and Length as thigh-length
				Thread.sleep(3000);
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Material']")));
		action.moveToElement(driver.findElementByXPath("//span[text()='Material']")).click().build().perform();
		System.out.println("Material is clicked");
		action.moveToElement(driver.findElementByXPath("//ul[@class='content cat_list-1KY6Z']/li[4]/span[text()='cotton (100%)']")).click().build().perform();
		System.out.println("cotton (100%) is selected");
		driver.findElementByXPath("//div[@class='cat_pane-xETbh']/button[text()='Save']").click();

		Thread.sleep(2000);
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Length']")));
		action.moveToElement(driver.findElementByXPath("//span[text()='Length']")).click().build().perform();
		System.out.println("Length is clicked");
		action.moveToElement(driver.findElementByXPath("//ul[@class='content cat_list-1KY6Z']//span[text()='thigh-length']")).click().build().perform();
		System.out.println("thigh-length is selected");
		driver.findElementByXPath("//div[@class='cat_pane-xETbh']/button[text()='Save']").click();


//	6) Click on Q/S designed by MANTEL - Parka coat
		Thread.sleep(2000);
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[text()='MANTEL - Parka - navy']")));
		action.moveToElement(driver.findElementByXPath("//div[text()='MANTEL - Parka - navy']")).click().build().perform();
		System.out.println("Q/S designed by Mantel is clicked");


//	7) Check the availability for Color as Olive and Size as 'M'
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Choose your size']")));
		action.moveToElement(driver.findElementByXPath("//span[text()='Choose your size']")).click().build().perform();
		System.out.println("Choose ur Size is clicked");

		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//img[@alt='olive'])[2]")));
		action.moveToElement(driver.findElementByXPath("(//img[@alt='olive'])[2]")).click().build().perform();
		System.out.println("Olive color is selected");

		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//ul[@role='listbox']/li[3]/div/span[text()='M']")));
		action.moveToElement(driver.findElementByXPath("//ul[@role='listbox']/li[3]/div/span[text()='M']")).click().build().perform();
		System.out.println("Medium Size is clicked");


		//h2[text()='Out of stock']

		String availability = driver.findElementByXPath("[@class='Wqd6Qu']//h2[1]").getText();
		if(availability.contains("Out of stock"))
		{
			System.out.println("The Availability of Olive Color is :"+availability);
		}
		else
			System.out.println("The Availability of Olive Color is : Available");

		//div[@class='Wqd6Qu']//h2[1]
		
		
//8) If the previous preference is not available, check  availability for Color Navy and Size 'M'
		driver.findElementByXPath("(//img[@alt='navy'])[2]").click();
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//ul[@role='listbox']/li[3]/div/span[text()='M']")));
		action.moveToElement(driver.findElementByXPath("//ul[@role='listbox']/li[3]/div/span[text()='M']")).click().build().perform();
		System.out.println("Medium Size is clicked");
		
//9) Add to bag only if Standard Delivery is free
		Thread.sleep(2000);
		String stddelvstatus = driver.findElementByXPath("(//span[text()='Standard delivery'])[1]").getText();
		if(stddelvstatus.contains("Free"))
		{
			driver.findElementByXPath("//span[text()='Add to bag']").click();
		}
		System.out.println("Add to Bag is done");
		
//10) Mouse over on Your Bag and Click on "Go to Bag"
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Your bag']//span[text()='Your bag']")));
		action.moveToElement(driver.findElementByXPath("//span[text()='Your bag']")).build().perform();
		System.out.println("Mouse overed to Your Bag is done");
		
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("div[text()='Go to bag']")));
		action.moveToElement(driver.findElementByXPath("div[text()='Go to bag']")).click().build().perform();
		System.out.println("Go To Bag is Clicked");
		
//11) Capture the Estimated Deliver Date and print
		String dateandtime = driver.findElementByXPath("(//span[contains(@class,'z-2-text z-2-text-body')])[1]").getText();
		System.out.println("Estimated Deliver Date is :"+dateandtime);
		
//12) Mouse over on FREE DELIVERY & RETURNS*, get the tool tip text and print
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//span[@class='z-navicat-header-uspBar_message-split_styled']//a)[2]")));
		action.moveToElement(driver.findElementByXPath("(//span[@class='z-navicat-header-uspBar_message-split_styled']//a)[2]")).click().build().perform();
		String tooltip = driver.findElementByXPath("(//span[@class='z-navicat-header-uspBar_message-split_styled']//a)[2]").getAttribute("title");
		System.out.println(tooltip);
		
//13) Click on Start chat in the Start chat and go to the new window
		driver.findElementByXPath("//a[contains(@href,'Do-delivery-and-returns')]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='Start chat']").click();
		Set<String> set = driver.getWindowHandles();
		List<String> ls = new ArrayList<String>(set);
		driver.switchTo().window(ls.get(1));
		
//14) Enter you first name and a dummy email and click Start Chat
		Thread.sleep(2000);
		driver.findElementById("prechat_customer_name_id").sendKeys("dmmy");
		driver.findElementById("prechat_customer_email_id").sendKeys("dummy@gmail.com");
		driver.findElementByXPath("//span[text()='Start Chat']").click();
		System.out.println("Start Chat  is done");
		Thread.sleep(4000);
		
//15) Type Hi, click Send and print thr reply message and close the chat window.
		driver.findElementById("liveAgentChatTextArea").sendKeys("Hi");
		driver.findElementByXPath("//button[text()='Send']").click();
		Thread.sleep(2000);
		System.out.println(driver.findElementByXPath("(//span[@class='operator']//span[@class='messageText'])[3]").getText());
		driver.close();
	}

}
