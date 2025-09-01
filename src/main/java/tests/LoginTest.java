package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginValid("validUser", "validPassword"); // replace with real creds
        boolean isLoggedIn = driver.getPageSource().contains("Log out");
        Assert.assertTrue(isLoggedIn, "Valid login failed!");
    }

    @Test(priority = 2)
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        String actualMsg = loginPage.loginInvalid("wrongUser", "wrongPass");

        // DemoBlaze usually says "User does not exist."
        Assert.assertEquals(actualMsg, "User does not exist.", 
            "Unexpected error message for invalid login!");
    }
}


