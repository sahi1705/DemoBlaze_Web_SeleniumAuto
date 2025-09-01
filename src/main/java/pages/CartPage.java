package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    By addToCartBtn = By.xpath("//a[text()='Add to cart']");
    By cartLink = By.id("cartur");
    By homeLink = By.cssSelector("a.nav-link[href='index.html']");
    By deleteBtn = By.xpath("//a[text()='Delete']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectProduct(String productName) {
        driver.findElement(By.linkText(productName)).click();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void navigateToHome() {
        wait.until(ExpectedConditions.elementToBeClickable(homeLink)).click();
    }


    public void openCart() {
        driver.findElement(cartLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page-wrapper")));
    }

    public boolean isProductInCart(String productName) {
        try {
            WebElement product = driver.findElement(By.xpath("//td[text()='" + productName + "']"));
            return product.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void removeProduct(String productName) {
        WebElement deleteLink = driver.findElement(
                By.xpath("//td[text()='" + productName + "']/following-sibling::td/a[text()='Delete']")
        );
        deleteLink.click();
        // wait for product to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[text()='" + productName + "']")));
    }
}



