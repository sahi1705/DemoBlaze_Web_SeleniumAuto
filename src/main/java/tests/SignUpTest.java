package tests;

import org.testng.annotations.Test;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {

    @Test
    public void testSignUp() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUp("newuser123", "NewPass@123");
    }
}

