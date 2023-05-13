package testautomation.qaengineer;
import org.testng.Assert;
import org.testng.annotations.Test;

import testautomation.qaengineer.pacakges.LoginPage;
import testautomation.qaengineer.pacakges.ProfileFactory;

/**
 * Unit test for simple App.
 */
public class AppTest2 extends BaseWebTestHeadless {
	
    @Test
    public void LoginValid()
    {
    	LoginPage loginpage = new LoginPage(driver, explicitWait);
    	ProfileFactory profilpage = new ProfileFactory(driver, explicitWait);
    	
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        
        loginpage.inputUsername(username);
        loginpage.inputPassword(password);
        loginpage.clickloginButton();
        String actualText = profilpage.getProfileText();
        String expectedText = "You logged into a secure area";
        Assert.assertTrue(actualText.contains(expectedText));
    }
    
    @Test
    public void LoginPassInvalid()
    {
    	LoginPage loginpage = new LoginPage(driver, explicitWait);
    	ProfileFactory profilpage = new ProfileFactory(driver, explicitWait);
        String username = "tomsmith";
        String password = "SuperSecretPassword";
        
        loginpage.inputUsername(username);
        loginpage.inputPassword(password);
        loginpage.clickloginButton();
        String actualText = profilpage.getProfileText();
        String expectedText = "Your password is invalid!";
        Assert.assertTrue(actualText.contains(expectedText));
    }
    
    @Test
    public void LoginUsernameNull() {
    	LoginPage loginpage = new LoginPage(driver, explicitWait);
    	ProfileFactory profilpage = new ProfileFactory(driver, explicitWait);
        String username = "";
        String password = "SuperSecretPassword";
        
        loginpage.inputUsername(username);
        loginpage.inputPassword(password);
        loginpage.clickloginButton();
        String actualText = profilpage.getProfileText();
        String expectedText = "Your username is invalid!";
        Assert.assertTrue(actualText.contains(expectedText));
    	
    }
    
    
}
