package workout;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebListen implements WebDriverEventListener  {
	
	EventFiringWebDriver event1;
	
	// constructor for initializing the EventfiringWebDriver for this class
	public WebListen (EventFiringWebDriver event1) 
	{
		
	}
	@Override
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		WebDriverWait Wait = new WebDriverWait(driver,30);
		
		System.out.println("Web Listener Code  is called");
		
		if(driver.findElements(by.xpath("//div[@class='wrapper']//div[@id='webklipper-publisher-widget-container-notification-container']//img[1]")).size()>0)
		{
			WebElement popup50 = driver.findElement(by.xpath("//div[@class='wrapper']//div[@id='webklipper-publisher-widget-container-notification-container']//img[1]"));
			System.out.println("50%  Discount popup is displayed");
			Wait.until(ExpectedConditions.elementToBeClickable
					(driver.findElement(by.xpath("//div[@class='close']/span[@class='wewidgeticon we_close icon-large']"))));
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.findElement(by.xpath("//div[@class='close']/span[@class='wewidgeticon we_close icon-large']")).click();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			System.out.println("50%  Discount popup is Closed");
			}
		else 
		{
			System.out.println("50%  Discount popup is not displayed");
		}
		
		
		
		if(driver.findElements(by.xpath("//div[@id='reg_login_box']/div[@class='popup-box gb-modal reg_modal']")).size()>0)
			{
				WebElement popup1 = driver.findElement(by.xpath("//div[@id='reg_login_box']/div[@class='popup-box gb-modal reg_modal']"));
				System.out.println("REgistry popup is displayed");
				Wait.until(ExpectedConditions.elementToBeClickable
						(driver.findElement(by.xpath("//div[@id='regPopUp']//a[@class='popup-close']"))));
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				driver.findElement(by.xpath("//div[@id='regPopUp']//a[@class='popup-close']")).click();
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				System.out.println("REgistry popup is Closed");
				}
		else 
		{
			System.out.println("Registry popup is not displayed");
		}
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}	
	
	

}
