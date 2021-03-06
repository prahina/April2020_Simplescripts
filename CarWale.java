package workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarWale {
	
	public static void main(String args[]) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		DesiredCapabilities capabilites = new DesiredCapabilities().chrome();
		ChromeDriver driver = new ChromeDriver();
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		WebListen listen = new WebListen(edriver);
		edriver.register(listen);
		WebDriverWait wt = new WebDriverWait(driver,10);
		Actions action = new Actions(driver);
		
//1) Go to https://www.carwale.com/
		edriver.get("https://www.carwale.com/");
		System.out.println("URL Loaded");
		edriver.manage().window().maximize();
		edriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//2) Click on Used
		wt.until(ExpectedConditions.elementToBeClickable(edriver.findElement(By.xpath("//div[@id='top-navbar-list-content']//span[text()='Used Cars']"))));
		action.moveToElement(edriver.findElement(By.xpath("//div[@id='top-navbar-list-content']//span[text()='Used Cars']")))
		.click().build().perform();
		System.out.println("Used Cars is Clicked");
		
		
//3) Select the City as Chennai
		WebElement city = driver.findElementById("usedCarsList");
		city.click();
		city.sendKeys("Chennai");
		Thread.sleep(5000);
		city.sendKeys(Keys.TAB);
		System.out.println("Chennai is Selected");
		
		
//4) Select budget min (8L) and max(12L) and Click Search
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElementById("minMaxContainer")).build().perform();
		driver.findElementByXPath("//li[text()='8 Lakh']").click();
		driver.findElementByXPath("(//li[text()='12 Lakh'])[2]").click();
		driver.findElementById("btnFindCar").click();
		System.out.println("Budget  is Selected");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		
//	5) Select Cars with Photos under Only Show Cars With
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Cars with Photos']")));
		driver.findElementByXPath("//span[text()='Cars with Photos']").click();
		Thread.sleep(5000);
		System.out.println("Cars with photos is Selected");
		
		js.executeScript("window.scrollBy(0,300)");
		
//	6) Select Manufacturer as "Hyundai" --> Creta
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()=' Hyundai ']")));
		driver.findElementByXPath("//span[text()=' Hyundai ']").click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Creta']")));
		driver.findElementByXPath("//span[text()='Creta']").click();
		System.out.println("Hyndai Creat is Clicked");
		
		js.executeScript("window.scrollBy(0,400)");
//7) Select Fuel Type as Petrol
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//h3[contains(text(),'Fuel')]")));
		driver.findElementByXPath("//h3[contains(text(),'Fuel')]").click();
		driver.findElementByXPath("//li[@name=\"Petrol\"]/span").click();
		
		
//			8) Select Best Match as "KM: Low to High"
		WebElement bestmatch = driver.findElementById("sort");
		Select select = new Select(bestmatch);
		select.selectByVisibleText("KM: Low to High");
		Thread.sleep(5000);
		 
		try {
			driver.findElementByXPath("//a[text()=\"Don't show anymore tips\"]").click();
		} catch (Exception e) {
			System.out.println("NOt found");
		}
		
		
//	9) Validate the Cars are listed with KMs Low to High
		List<Integer> list = new ArrayList<Integer>();
		List<WebElement> litres = driver.findElementsByXPath("//span[@class=\"rupee-lac slprice\"]/span");
		for (int i = 1; i <= litres.size(); i++) {
			int val = Integer.parseInt(driver.findElementByXPath("(//span[@class=\"rupee-lac slprice\"]/span)["+i+"]").getText().replaceAll("\\D", ""));
			list.add(val);
		}
		List<Integer> sortedlist = new ArrayList<Integer>(list);
		Collections.sort(list);
		
		if (list.equals(sortedlist)) {
			System.out.println("Cars are listed with KMs Low to High");
		}else {
			System.out.println("Cars are not listed with KMs Low to High");
		}
		
		
//10) Add the least KM ran car to Wishlist
		
		int smallest = sortedlist.get(0);
		for (int i = 0; i <list.size();i++) {
			if (smallest == list.get(i)) {
				driver.findElementByXPath("(//span[@class=\"shortlist-icon--inactive shortlist\"])["+(i+1)+"]").click();
				break;
			}
		}
	
//			11) Go to Wishlist and Click on More Details
		Thread.sleep(5000);
		WebElement compare = driver.findElementByXPath("//li[@data-cat='UsedCarSearch']");
		js.executeScript("arguments[0].click()", compare);
		Thread.sleep(5000);
		driver.findElementByXPath("//a[text()='More details �']").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowlist = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowlist.get(1));
		
//			12) Print all the details under Overview 
		js.executeScript("window.scrollBy(0,500)");
		driver.findElementByXPath("//li[text()='Overview']").click();
		Map<String,String> map = new LinkedHashMap<String, String>();
		List<WebElement> overviewlist = driver.findElementsByXPath("//div[@class=\"overview-list padding-bottom10\"]/ul/li");
		for (int i = 1; i <=overviewlist.size(); i++) {
			String Key = driver.findElementByXPath("//div[@class=\"overview-list padding-bottom10\"]/ul/li["+i+"]/div[1]").getText();
			String Value = driver.findElementByXPath("//div[@class=\"overview-list padding-bottom10\"]/ul/li["+i+"]/div[2]").getText();
			map.put(Key, Value);
		}
		
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey()+"--->"+entry.getValue());
		}
		
//			13) Close the browser.
		driver.quit();
	}

}
