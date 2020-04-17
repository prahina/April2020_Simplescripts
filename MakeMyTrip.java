package workout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTrip {

	public static void main(String args[]) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--diable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver,10);
		

		//	1) Go to https://www.makemytrip.com/
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//	2) Click Hotels
		driver.findElementByXPath("//span[@class='chNavIcon appendBottom2 chSprite chHotels']").click();

		//	3) Enter city as Goa, and choose Goa, India
		driver.findElementByXPath("//span[text()='City / Hotel / Area / Building']").click();
		driver.findElementByXPath("//input[@class='react-autosuggest__input react-autosuggest__input--open']").sendKeys("Goa");
		driver.findElementByXPath("//p[@class='locusLabel appendBottom5']").click();
		

		//	4) Enter Check in date as Next month 15th (May 15) and Check out as start date+5
		driver.findElementById("checkin").click();
		driver.findElementByXPath("(//div[text()='15'])[2]").click();
		String checkin = driver.findElementByXPath("(//div[text()='15'])[2]").getText();
		int a = Integer.parseInt(checkin);
		System.out.println("CheckIn Date :"+a);
		int b=a+5;
		System.out.println(b);
		driver.findElementByXPath("(//div[text()='20'])[2]").click();
		
		
		//	5) Click on ROOMS & GUESTS and click 2 Adults and one Children(age 12). Click Apply Button.
		driver.findElementById("guest").click();
		driver.findElementByXPath("(//li[text()='2'])[1]").click();
		driver.findElementByXPath("(//li[text()='1'])[2]").click();
		WebElement age = driver.findElementByXPath("//select[@class='ageSelectBox']");
		Select Age=new Select(age);
		Age.selectByVisibleText("12");
		driver.findElementByXPath("//button[@class='primaryBtn btnApply']").click();
		
		//	6) Click Search button
		driver.findElementById("hsw_search_button").click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,850)");
		
		Thread.sleep(3000);
		//	7) Select locality as Baga
		//driver.findElementByXPath("//label[text()='Baga']").click();
		driver.findElement(By.xpath("//div[@class='mmBackdrop wholeBlack']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='mmLocality_checkbox_35']")).click();
		
		//	8) Select 5 start in Star Category under Select Filters
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='chk_Shampoo_undefined']/span"))).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='5 Star']")));
		Thread.sleep(8000);
		driver.findElementByXPath("//label[text()='5 Star']").click();
		
		// 9) Click on the first resulting hotel and go to the new window
		driver.findElementByXPath("//span[text()='Taj Fort Aguada Resort & Spa, Candolim,Goa']").click();
	
		Set<String> noofwindowsSet = driver.getWindowHandles();
		List<String> windowHandleList =new ArrayList<String>(noofwindowsSet);
		driver.switchTo().window(windowHandleList.get(1));
		driver.getTitle();

		//	10) Print the Hotel Name 
		String HotelName = driver.findElementById("detpg_hotel_name").getText();
		System.out.println(HotelName);
		
		//	11) Click MORE OPTIONS link and Select 3Months plan and close
		driver.findElementByXPath("//span[text()='MORE OPTIONS']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//span[text()='SELECT'][1]").click();
		Thread.sleep(3000);
		driver.findElementByClassName("close").click();
		Thread.sleep(3000);
				
		// 12) Click on BOOK THIS NOW
		driver.findElementById("detpg_headerright_book_now").click();
		
		// 13) Print the Total Payable amount
		String Total =  driver.findElementById("revpg_total_payable_amt").getText();
		System.out.println(Total);
		
		//			14) Close the browser
		driver.quit();
	}
}
