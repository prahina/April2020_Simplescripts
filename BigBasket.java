package workout;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigBasket {
	
	public static void main(String args[]) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--diable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait Wait = new WebDriverWait(driver,10);
		Actions action = new Actions(driver);
				
		
//	1) Go to https://www.bigbasket.com/
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
//	2) mouse over on  Shop by Category 
		action.moveToElement(driver.findElementByXPath("//a[@class='dropdown-toggle meganav-shop']")).build().perform();
		
				
//	3)Go to FOODGRAINS, OIL & MASALA --> RICE & RICE PRODUCTS 
		Thread.sleep(4000);
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]")));
		action.moveToElement(driver.findElementByXPath("(//a[text()='Foodgrains, Oil & Masala'])[2]")).build().perform();
		System.out.println("FoodGrains,Oil and Masala is selected");
	
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//a[text()='Rice & Rice Products'])[2]")));
		action.moveToElement(driver.findElementByXPath("(//a[text()='Rice & Rice Products'])[2]")).click().build().perform();
		System.out.println("Rice and Rice Products is Clicked");
		

		Thread.sleep(5000);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
				
			
	
//	4) Click on Boiled & Steam Rice
		
		Thread.sleep(3000);
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//div//span[text()='Boiled & Steam Rice'])[1]")));
		action.moveToElement(driver.findElementByXPath("(//div//span[text()='Boiled & Steam Rice'])[1]")).click().build().perform();
		System.out.println("Boiled & Steam Ricet is selected from Category");
		Thread.sleep(5000);
		
		
//	5) Choose the Brand as bb Royal
			//Wait1.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//i[contains(@class,'cr-icon fa')])[3]"))).click();
		//(//span[text()='bb Royal'])[5]
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//label//span[text()='bb Royal'])[1]")));
		action.moveToElement(driver.findElementByXPath("(//label//span[text()='bb Royal'])[1]")).click().build().perform();
		System.out.println("Brand BB Royal is clicked");
		
//	6) Go to Ponni Boiled Rice - Super Premium and select 5kg bag from Dropdown
		
		Thread.sleep(3000);
		Wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//a[text()='Ponni Boiled Rice - Super Premium']")));
		action.moveToElement(driver.findElementByXPath("//a[text()='Ponni Boiled Rice - Super Premium']")).build().perform();
		String ProductName = driver.findElementByXPath("//a[text()='Ponni Boiled Rice - Super Premium']").getText();
		System.out.println(ProductName);
		
		

		Thread.sleep(3000);
		Wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[text()='Ponni Boiled Rice - Super Premium']/ancestor::div[@class='item prod-deck row ng-scope']//button[@class='btn btn-default dropdown-toggle form-control']")));
		driver.findElementByXPath("//a[text()='Ponni Boiled Rice - Super Premium']/ancestor::div[@class='item prod-deck row ng-scope']//button[@class='btn btn-default dropdown-toggle form-control']").click();
		Thread.sleep(2000);
		Wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[text()='Ponni Boiled Rice - Super Premium']/ancestor::div[@class='item prod-deck row ng-scope']//ul[@class='dropdown-menu drop-select']//span[text()='5 kg']")));
		driver.findElementByXPath("//a[text()='Ponni Boiled Rice - Super Premium']/ancestor::div[@class='item prod-deck row ng-scope']//ul[@class='dropdown-menu drop-select']//span[text()='5 kg']").click();

		
//7) print the price of Rice

		String Price = driver.findElementByXPath("//a[text()='Ponni Boiled Rice - Super Premium']/ancestor::div[@class='item prod-deck row ng-scope']//span[@class='discnt-price']").getText();
		String Priceof2kgRice = Price.replaceAll("\\D", " ");
		Double.parseDouble(Priceof2kgRice);
		System.out.println("The Price of 2kg Rice is : "+Priceof2kgRice);
		
		
//8) Click Add button
		WebElement Addbtn = driver.findElementByXPath("//a[text()='Ponni Boiled Rice - Super Premium']/ancestor::div[@class='item prod-deck row ng-scope']//button[@class='btn btn-add col-xs-9']");
		Wait.until(ExpectedConditions.visibilityOf(Addbtn));
		action.moveToElement(Addbtn).click().build().perform();
		Thread.sleep(2000);
	
		driver.findElementByXPath("//a[@qa='continueBtn']").click();
		System.out.println("Continue button is clicked");
		
//		driver.findElementByXPath("//span[@class='login-icon login-icon-close']").click();
//		System.out.println("close button is clicked");
//		driver.findElementByXPath("(//a[text()='Continue'])[1]").click();
		Thread.sleep(2000);
	

//9) Verify the success message displayed
		String Labelmsg = driver.findElementById("site_msg_label").getText();
		System.out.println(Labelmsg);
	
//10) Type Dal in Search field and enter
		Thread.sleep(2000);
		Wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//input[@qa='searchBar']")));
		action.moveToElement(driver.findElementByXPath("//input[@qa='searchBar']")).sendKeys("Dhal",Keys.ENTER);
	
//12) Go to Toor/Arhar Dal and select 2kg & set Qty 2
		Thread.sleep(3000);
		Wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']")));
		action.moveToElement(driver.findElementByXPath("//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']")).click().build().perform();
		
				
//	13) Print the price of Dal
		String Dalprice = driver.findElementByXPath("//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']//parent::div/following-sibling::div[2]/div/div/h4/span[2]/span").getText();
		double Dalp = Double.parseDouble(Dalprice);
		System.out.println("DalPrice"+Dalprice);
		System.out.println("Price"+Dalp);
		
	
		
//	14) Click Add button
		 driver.findElement(By.xpath("//a[text()='Toor/Arhar Dal/Thuvaram Paruppu']//parent::div//following-sibling::div[2]/div/div[3]/div[2]/div[2]/button")).click();
	        Thread.sleep(3000);
		
//15) Mouse hover on My Basket 
	        Thread.sleep(3000);
	        Wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[@class='hidden-xs hidden-sm'][1]")));
	        driver.findElementByXPath("//span[@class='hidden-xs hidden-sm'][1]").click();
		
//16) Validate the Sub Total displayed for the selected items
	        
	        String qtyandpriceofRice = driver.findElementByXPath("(//div[@ng-bind='cartItem.quantity_mrp'])[1]").getText();
	        String qtyandpriceofdhal = driver.findElementByXPath("(//div[@ng-bind='cartItem.quantity_mrp'])[2]").getText();
	        System.out.println(qtyandpriceofRice);
	        System.out.println(qtyandpriceofdhal);
	        
	        double qtyofRice = Double.parseDouble(qtyandpriceofRice.substring(0,1));
	        double prcofRice = Double.parseDouble(qtyandpriceofRice.substring(4));
	        System.out.println("Qty of Rice Selected " +qtyofRice);
	        System.out.println("Price of Rice single unit"+prcofRice);
	        
	        double qtyofDhal = Double.parseDouble(qtyandpriceofdhal.substring(0, 1));
	        double prcofDhal = Double.parseDouble(qtyandpriceofdhal.substring(4));
	        System.out.println("Qty of Dhal Selected " +qtyofDhal);
	        System.out.println("Price of Rice single unit"+prcofDhal);
	        
	        double subtot = (qtyofRice*prcofRice) + (qtyofDhal*prcofDhal);
	        System.out.println("Price of selected items "+subtot);
      
	        
//17) Reduce the Quantity of Dal as 1 
	      Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='My Basket']")));
	        action.moveToElement(driver.findElement(By.xpath("//span[text()='My Basket']"))).click().build().perform();
	        Thread.sleep(3000);
	        
	        
//18) Validate the Sub Total for the current items
	        
	        Wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//div[@class='row mrp']//span)[2]")));
		      String Dhal = driver.findElementByXPath("(//div[@class='row mrp']//span)[2]").getText();
		      double Dhalprice = Double.parseDouble(Dhal);
		      System.out.println(Dhalprice);
		      	    		  
		      String Rice = driver.findElementByXPath("(//div[@class='row mrp']//span)[1]").getText();
		      double RicePrice = Double.parseDouble(Rice);
		      System.out.println(RicePrice);
		      
		           
		      String updQqtyandpriceofdhal = driver.findElementByXPath("(//div[@ng-bind='cartItem.quantity_mrp'])[2]").getText();
		      double updQtyofDhal = Double.parseDouble(updQqtyandpriceofdhal.substring(0, 1));
		      double updPrcofDhal = Double.parseDouble(updQqtyandpriceofdhal.substring(4));
		      
		      double CurrTotal = (updQtyofDhal*updPrcofDhal) + (qtyofRice*prcofRice);
		      System.out.println("Qty of Dhal Selected " +updQtyofDhal);
		      System.out.println("Price of Rice single unit"+updPrcofDhal);
		      System.out.println("Price of selected items updated"+CurrTotal);
		      		        
		      String Tprice = driver.findElement(By.xpath("(//div[contains(@class,'row sub-cost')]//span)[2]")).getText();
		      double CurTprice = Double.parseDouble(Tprice);
		      
		      if(CurrTotal==CurTprice) 
		      {
		    	  System.out.println("Price is Macthing");
		      }
		      else 
		      {
		    	  System.out.println("Price Not  Macthing");
		      } 
	        	     
		      
		      Thread.sleep(5000);    	     
	        
//	19) Close the Browser
		driver.close();
	}
	}


