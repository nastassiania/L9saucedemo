package org.tms.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.page.InventoryPage;
import org.tms.service.LoginPageService;

public class InventoryPageTest extends BaseTest {

    private InventoryPage inventoryPage = new InventoryPage();
    private LoginPageService loginPageService= new LoginPageService();

    @BeforeClass
    private void login() {
        loginPageService.login();
    }

    @Test(priority = 1)
    public void verifyTheRightQuantityOfAddedToCartItemsOnCartLogoTest() {
        inventoryPage.clickAddTheFirstItemToCartButton();
        inventoryPage.clickAddTheSecondItemToCartButton();
        inventoryPage.clickAddTheThirdItemToCartButton();
        String expectedQuantityOfItemsOnCartLogo = "3";
        String actualQuantityOfItemsOnCartLogo = inventoryPage.getQuantityOfItemsAddedToCart();
        Assert.assertEquals(actualQuantityOfItemsOnCartLogo, expectedQuantityOfItemsOnCartLogo, "The actual quantity of items added to the cart doesn't match the number on the cart logo");
    }

    @Test(priority = 2)
    public void verifyNumberOfItemsOnCartLogoDecreasesWhenClickingRemoveButtonTest() {
        inventoryPage.clickRemoveTheFirstItemFromCartButton();
        String expectedQuantityOfItemsOnCartLogo = "2";
        String actualQuantityOfItemsOnCartLogo = inventoryPage.getQuantityOfItemsAddedToCart();
        Assert.assertEquals(actualQuantityOfItemsOnCartLogo, expectedQuantityOfItemsOnCartLogo, "The actual quantity of items added to the cart doesn't match the number on the cart logo");
    }

}
