package org.tms.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.page.CartPage;
import org.tms.page.InventoryPage;
import org.tms.service.LoginPageService;

public class CartPageItemInfoTest extends BaseTest {

    private InventoryPage inventoryPage;
    private LoginPageService loginPageService;
    private CartPage cartPage;
    private static int firstItem;

    @BeforeClass
    public void login() {
        inventoryPage = new InventoryPage();
        loginPageService = new LoginPageService();
        cartPage = new CartPage();
        firstItem = 0;
        loginPageService.login();
    }

    @Test
    public void verifyCorrectPriceDisplayedOnCartPageTest() {
        inventoryPage.clickAddItemToCartButtonByIndex(firstItem);
        String expectedPriceOfItem = inventoryPage.getTextOfPriceOfItemByIndex(firstItem);
        inventoryPage.clickShoppingCartButton();
        String actualPriceOfItem = cartPage.getTextOfPriceOfAnItemInCart();
        Assert.assertEquals(actualPriceOfItem, expectedPriceOfItem, "The price of the first item in the cart doesn't match the expected one!");
    }

}
