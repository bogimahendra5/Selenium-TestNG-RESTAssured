package testautomation.qaengineer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseWebTestHeadless {
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	
	@BeforeMethod
	public void createChromeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*","--headless","--disable-gpu","--window-size=1280,720");
		
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver(options));
		explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(60)));
		driver.get().get("https://the-internet.herokuapp.com/login");
	}

	@AfterMethod
	public void quitChromeDriver() {
		driver.get().quit();
		
	}
	

}
