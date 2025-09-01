package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By productLink = By.linkText("Samsung galaxy s6");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProduct() {
        driver.findElement(productLink).click();
    }
}

