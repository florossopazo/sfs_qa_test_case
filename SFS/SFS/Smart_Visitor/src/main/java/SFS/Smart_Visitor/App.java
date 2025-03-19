package SFS.Smart_Visitor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class App 
{
	WebDriver driver;
	@Test(priority=1)
    void openApp()
    {
		// Adding option is not necessary in Selenium version 4.8.2
		// Resolves "Unable to establish websocket connection" Error
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		
		driver=new ChromeDriver(chromeOptions);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testclient.smartfoodsafe.com/#/auth/login");
        System.out.println( "smartfood safe page will display" );
    }
	@Test(priority=2)
    void testLogo()
    {
        // Test if logo is visible
        WebElement logo = driver.findElement(By.xpath("//img[@src='./static/media/SFSLoginLogo.5acabca30e90d1d1fb2da96f8424284b.svg']"));    
        if(logo.isDisplayed()) {
            System.out.println("Logo present");
        }
        else {
            System.out.println("Logo NOT present");
        }
        boolean logoIsDisplayed = logo.isDisplayed();
        assert(logo.isDisplayed());
    }
	@Test(priority=3)
    void testlogin()
    {
		// Test if user can log in
		WebElement username = driver.findElement(By.id("Username"));
		WebElement password = driver.findElement(By.id("Password"));
		WebElement login = driver.findElement(By.id("LoginButton"));
		username.sendKeys("intern.sfscs@gmail.com");
		password.sendKeys("Pathogenia@001");
		login.click();
		
		// Compares expected URL to actual URL after login
		String expectedUrl = "https://testclient.smartfoodsafe.com/#/dashboards/default";
		String actualUrl = driver.getCurrentUrl();
		// If URLs are not equal, throws AssertionError
		Assert.assertEquals(actualUrl, expectedUrl);
    }
	@Test(priority=4)
    void testlogout()
    {
       
    }
}
