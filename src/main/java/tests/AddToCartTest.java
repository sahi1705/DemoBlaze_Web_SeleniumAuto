package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class AddToCartTest extends BaseTest {

    @Test(priority = 1)
    public void testAddSingleProductToCart() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.selectProduct();
        cartPage.addToCart();
        cartPage.openCart();

        Assert.assertTrue(cartPage.isProductInCart("Samsung galaxy s6"), "Samsung Galaxy S6 not found in cart!");
    }

    @Test(priority = 2)
    public void testAddMultipleProductsToCart() {
        CartPage cartPage = new CartPage(driver);

        cartPage.selectProduct("Samsung galaxy s6");
        cartPage.addToCart();

        cartPage.navigateToHome();
        cartPage.selectProduct("Sony vaio i5");
        cartPage.addToCart();

        cartPage.openCart();

        Assert.assertTrue(cartPage.isProductInCart("Samsung galaxy s6"), "Samsung Galaxy S6 not found in cart!");
        Assert.assertTrue(cartPage.isProductInCart("Sony vaio i5"), "Sony Vaio i5 not found in cart!");
    }

    @Test(priority = 3)
    public void testRemoveProductFromCart() {
        CartPage cartPage = new CartPage(driver);

        cartPage.selectProduct("Samsung galaxy s6");
        cartPage.addToCart();
        cartPage.openCart();

        cartPage.removeProduct("Samsung galaxy s6");

        Assert.assertFalse(cartPage.isProductInCart("Samsung galaxy s6"), "Product was not removed from cart!");
    }
}


