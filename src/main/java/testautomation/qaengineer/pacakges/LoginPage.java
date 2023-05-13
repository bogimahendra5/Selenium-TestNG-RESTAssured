package testautomation.qaengineer.pacakges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePageFactory {
	
	@FindBy(xpath ="//input[@id='username']")
	private WebElement emailtelepon;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement loginBtn;
	
	public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}
	
	public void inputUsername(String user) {
		emailtelepon.sendKeys(user);
	}
	
	public void inputPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickloginButton() {
		loginBtn.click();
	}
	
	
}
