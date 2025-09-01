package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By loginBtn       = By.id("login2");
    private final By loginModal     = By.id("logInModal");
    private final By usernameInput  = By.id("loginusername");
    private final By passwordInput  = By.id("loginpassword");
    private final By submitBtn      = By.xpath("//div[@id='logInModal']//button[text()='Log in']");
    private final By logoutLink     = By.id("logout2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    private void openLoginModal() {
        driver.findElement(loginBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginModal));
        wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
    }

    /** For valid login */
    public void loginValid(String username, String password) {
        openLoginModal();
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitBtn).click();
        // Wait until logout link shows
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
    }

    /** For invalid login */
    public String loginInvalid(String username, String password) {
        openLoginModal();
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(submitBtn).click();

        // Wait for alert and handle immediately
        WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alertWait.until(ExpectedConditions.alertIsPresent());
        String alertMsg = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertMsg;
    }
}



