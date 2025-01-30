package mobileTestng;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class TodayTestngMobileApp {

	public AndroidDriver driver;
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setDevice() throws MalformedURLException {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("appium:deviceName", "Pixel9");
		desiredCapabilities.setCapability("platformName", "android");
		desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
		desiredCapabilities.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.rn");
		desiredCapabilities.setCapability("appium:appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
		desiredCapabilities.setCapability("appium:udid", "emulator-5554");
		URL remoteUrl = new URL("http://127.0.0.1:4723");
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test
	public void test_app_one() throws InterruptedException {
		System.out.println("Enter the shopping apps");
		
		driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[1]/android.view.ViewGroup[1]/android.widget.ImageView")).click();
		System.out.println("Select first product");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Add To Cart\"]")).click();
		System.out.println("add to card one product");

		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")).click();
		System.out.println("click to card stay my card");
		Thread.sleep(5000);

		// click three line 
		
		/*driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView")).click();
		System.out.println("Click to three line");
		
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView")).click();
		System.out.println("Click to Catalog");
		
		driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])[3]/android.view.ViewGroup[1]/android.widget.ImageView")).click();
		System.out.println("Click to bolt t-shirt");
		
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Add To Cart button\"]")).click();
		System.out.println("Click to bolt t-shirt then add to card");
	
		// click card 
		*/
		
		WebElement check = driver.findElement(By.xpath("//android.widget.TextView[@text=\"My Cart\"]"));
		String checkone = check.getText();		
		System.out.println("This Page titile is" + checkone);
			
		Assert.assertEquals(checkone, "My Cart");	
		System.out.println("This Page title is verfied by hard assertion");

		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Proceed To Checkout\"]")).click();
		System.out.println("Process for checkout");
		
		
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]")).sendKeys("bob@example.com");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]")).sendKeys("10203040");
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]")).click();
		System.out.println("Login Completed");

		
		WebElement checkOut = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Checkout\"]"));
		String checkTwo = checkOut.getText();		
		System.out.println("This Page is " + checkTwo + " Page");
			
		Assert.assertEquals(checkTwo, "Checkout");	
		System.out.println("This Page title is verfied by hard assertion");
		
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]")).sendKeys("Mehedi hasan");
		
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]")).sendKeys("Hazaribag");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Address Line 2 input field\"]")).sendKeys("jawcher");

		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"City* input field\"]")).sendKeys("Dhaka");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"State/Region input field\"]")).sendKeys("Hazaribag");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Zip Code* input field\"]")).sendKeys("1209");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Country* input field\"]")).sendKeys("Bangladesh");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"To Payment\"]")).click();
		System.out.println("Secound checkout complate"); 
		
		
		WebElement checkOut2 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Checkout\"]"));
		String checkThree = checkOut2.getText();		
		System.out.println("This Page is " + checkThree + " Page");
			
		Assert.assertEquals(checkThree, "Checkout");	
		System.out.println("This Page title is verfied by hard assertion 00");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//android.widget.EditText[@content-desc=\"Full Name* input field\"])[1]")).sendKeys("Mehedi hasan");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Card Number* input field\"]")).sendKeys("3258 2580 3214 123");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Expiration Date* input field\"]")).sendKeys("05/25");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Security Code* input field\"]")).sendKeys("789");
		
		
		//driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"checkbox for My billing address is the same as my shipping address.\"]")).click();
		
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Review Order button\"]")).click();
		System.out.println("Therd checkout complate"); 
		
		
		WebElement checkOut3 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Checkout\"]"));
		String checkFore = checkOut3.getText();		
		System.out.println("This Page is " + checkFore + "Page");
			
		Assert.assertEquals(checkFore, "Checkout");	
		System.out.println("This Page title is verfied by hard assertion");
		
		Thread.sleep(5000);

		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Place Order\"]")).click();
		System.out.println("click Place Order button"); 
		
		Thread.sleep(6000);
		WebElement checkOut4 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Checkout Complete\"]"));
		String checkFive = checkOut4.getText();		
		System.out.println("Here checkout complete");
			
		Assert.assertEquals(checkFive, "Checkout Complete");	
		System.out.println("This Page title is verfied by hard assertion");

		Thread.sleep(6000);
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Continue Shopping button\"]")).click();
		System.out.println("Click Continue Shopping"); 
		
}
	@AfterTest
	public void closeApp() {
		//driver.quit();
	}
}

