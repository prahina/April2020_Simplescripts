package workout;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Azure {
	
	public static void main(String args[]) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--diable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait Wait = new WebDriverWait(driver,10);
		Actions action = new Actions(driver);
		
//		1) Go to https://azure.microsoft.com/en-in/
		driver.get("https://azure.microsoft.com/en-in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("URL Loaded");
		
//			2) Click on Pricing
		Thread.sleep(3000);
		driver.findElementByXPath("//a[text()='Pricing']").click();
		System.out.println("Pricing is clicked");
		
//			3) Click on Pricing Calculator
		Thread.sleep(3000);
		driver.findElementByXPath("//nav[@id='global-subnav']/ul[1]/li[2]/a[1]").click();
		System.out.println("Pricing Calculator is clicked");
		
//			4) Click on Containers
		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='Containers']").click();
		System.out.println("Containers is clicked");
		
//			5) Select Container Instances
		Thread.sleep(3000);
		driver.findElementByXPath("(//span[text()='Container Instances'])[3]").click();
		System.out.println("Container Instance is clicked");
		
//			6) Click on Container Instance Added View
		Thread.sleep(5000);
		driver.findElementById("new-module-loc").click();
		System.out.println("Container Instance Added View is clicked");
		
//			7) Select Region as "South India"
		Thread.sleep(2000);
		WebElement Regiondropdwn = driver.findElementByXPath("//select[@aria-label='Region']");
		Select Region = new Select(Regiondropdwn);
		Region.selectByVisibleText("South India");
		System.out.println("South India is Selected");
		
//			8) Set the Duration as 180000 seconds
		driver.findElementByXPath("//input[@aria-label='Seconds']").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("//input[@aria-label='Seconds']").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("//input[@aria-label='Seconds']").sendKeys("180000");
		System.out.println("Duration as 180000 is given");
		
//			9) Select the Memory as 4GB
		WebElement Memory = driver.findElementByXPath("//select[@aria-label='Memory']");
		Select Mem = new Select(Memory);
		Mem.selectByValue("4");
		System.out.println("Memory 4GB is Selected");
		
//			10) Enable SHOW DEV/TEST PRICING
		Thread.sleep(4000);
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@class='toggler-slide ']")));
		action.moveToElement(driver.findElementByXPath("//div[@class='toggler-slide ']")).click().build().perform();;
		System.out.println("SHOW DEV/TEST PRICING is Selected");
		
//			11) Select Indian Rupee  as currency
		WebElement currency = driver.findElementByXPath("(//select[@aria-label='Currency'])[1]");
		Select curr = new Select(currency);
		curr.selectByValue("INR");
		System.out.println("Indian Rupee  is Selected");
	
		
//			12) Print the Estimated monthly price
		String mprice = driver.findElementByXPath("(//div[@class='row row-size1 column estimate-total']//span[@class='numeric'])[2]").getText();
		System.out.println("Estimated monthly Price"+mprice);
		
//			13) Click on Export to download the estimate as excel
		
		driver.findElementByXPath("//button[text()='Export']").click();
		Thread.sleep(4000);
		
//			14) Verify the downloded file in the local folder
		
		File DownlaodedFile = new File("C:\\Users\\ADMIN\\Downloads\\ExportedEstimate.xlsx");
		if(DownlaodedFile.exists()) 
		{
			System.out.println("File available in local folder");
		}
		else
		{
			System.out.println("File not available");
		}
			
		
//			15) Navigate to Example Scenarios and Select CI/CD for Containers
		Thread.sleep(4000);
		action.moveToElement(driver.findElementByXPath("//a[text()='Example Scenarios']")).click().build().perform();
		System.out.println("Example Scenarios is Clicked");
			
		driver.findElementByXPath("//button[@title='CI/CD for Azure Web Apps']").click();
		System.out.println("CI/CD for containers clicked");
		Thread.sleep(3000);
		
		// To close start window chat button
		if(driver.findElementsByXPath("(//div[@class='lp_close-icon lp_icon-white'])[2]").size()>0)
		{
			driver.findElementByXPath("(//div[@class='lp_close-icon lp_icon-white'])[2]").click();
		}
		
		
//			16) Click Add to Estimate
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//button[text()='Add to estimate']")));
		action.moveToElement(driver.findElementByXPath("//button[text()='Add to estimate']")).click().build().perform();;
		System.out.println("Add to Estimate is done");
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()='Estimate added!']")));
		System.out.println("Estimate Added! is shown");
		Thread.sleep(43000);
		
//			17) Change the Currency as Indian Rupee
		WebElement currency1 = driver.findElementByXPath("(//select[@aria-label='Currency'])[1]");
		Select curr1 = new Select(currency);
		curr1.selectByValue("INR");
		System.out.println("Indian Rupee  is Selected");
		
//			18) Enable SHOW DEV/TEST PRICING
		driver.findElementByXPath("//div[@class='toggler-slide ']").click();
		Thread.sleep(4000);
		System.out.println("SHOW DEV/TEST PRICING is Selected");
		
//			19) Export the Estimate
		driver.findElementByXPath("//button[text()='Export']").click();
		Thread.sleep(4000);
		
//			20) Verify the downloded file in the local folder
		File DownlaodedFile2 = new File("C:\\Users\\ADMIN\\Downloads\\ExportedEstimate (1).xlsx");
		
		if(DownlaodedFile2.exists()) 
		{
			System.out.println("File2 available in local folder");
		}
		else
		{
			System.out.println("File2 not available");
		}
			

}
}
