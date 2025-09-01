package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void validateCheckoutProcess() {
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        cart.selectProduct("Samsung galaxy s6");
        cart.addToCart();
        cart.openCart();

        checkout.clickPlaceOrder();
        checkout.fillCheckoutDetails("John Doe", "USA", "New York", "1234567812345678", "12", "2025");
        checkout.completePurchase();

        Assert.assertTrue(checkout.isOrderSuccessful(), "Order was not completed successfully!");
    }

    @Test
    public void validateCheckoutWithoutDetails() {
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        cart.selectProduct("Samsung galaxy s6");
        cart.addToCart();
        cart.openCart();

        checkout.clickPlaceOrder();
        checkout.completePurchase();   // No details entered

        // In Demoblaze, it shows an alert if fields are missing
        Assert.assertTrue(checkout.isErrorMessageDisplayed(), "Error message not displayed when trying to checkout without details!");
    }

    @Test
    public void validateCheckoutWithMultipleProducts() {
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        // Add multiple products
        cart.selectProduct("Samsung galaxy s6");
        cart.addToCart();

        cart.navigateToHome();
        cart.selectProduct("Sony vaio i5");
        cart.addToCart();

        cart.openCart();

        checkout.clickPlaceOrder();
        checkout.fillCheckoutDetails("Emma Johnson", "Germany", "Berlin", "9876543210987654", "11", "2027");
        checkout.completePurchase();

        Assert.assertTrue(checkout.isOrderSuccessful(), "Order was not completed successfully with multiple products!");
    }
}


