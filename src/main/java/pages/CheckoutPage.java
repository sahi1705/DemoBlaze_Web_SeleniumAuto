package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    By nameField = By.id("name");
    By countryField = By.id("country");
    By cityField = By.id("city");
    By cardField = By.id("card");
    By monthField = By.id("month");
    By yearField = By.id("year");
    By purchaseBtn = By.xpath("//button[text()='Purchase']");
    By closeBtn = By.xpath("//button[text()='Close']");
    By confirmationModal = By.cssSelector(".sweet-alert");
    By okBtn = By.xpath("//button[text()='OK']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }

    public void fillCheckoutDetails(String name, String country, String city, String card, String month, String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(cardField).sendKeys(card);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(yearField).sendKeys(year);
    }

    public void completePurchase() {
        driver.findElement(purchaseBtn).click();
    }

    public boolean isOrderSuccessful() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationModal));
            String confirmationText = driver.findElement(confirmationModal).getText();
            driver.findElement(okBtn).click();
            return confirmationText.contains("Thank you for your purchase!");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertMsg = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            return alertMsg != null && !alertMsg.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
}


