package org.tms.test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.page.InventoryPage;
import org.tms.service.LoginPageService;

public class InventoryPageCartLogoTest extends BaseTest {

    private InventoryPage inventoryPage = new InventoryPage();
    private LoginPageService loginPageService = new LoginPageService();
    private static int firstItem = 0;
    private static int itemsInCartStart;

    @BeforeClass
    private void login() {
        loginPageService.login();
    }

    @Test
    public void verifyTheRightQuantityOfAddedToCartItemsOnCartLogoTest() {
        itemsInCartStart();
        inventoryPage.clickAddItemToCartButtonByIndex(firstItem);
        itemsInCartStart++;
        inventoryPage.clickAddItemToCartButtonByIndex(firstItem);
        itemsInCartStart++;
        inventoryPage.clickAddItemToCartButtonByIndex(firstItem);
        itemsInCartStart++;
        int expectedQuantityOfItemsOnCartLogo = itemsInCartStart;
        int actualQuantityOfItemsOnCartLogo = inventoryPage.getQuantityOfItemsAddedToCart();
        Assert.assertEquals(actualQuantityOfItemsOnCartLogo, expectedQuantityOfItemsOnCartLogo, "The actual quantity of items added to the cart doesn't match the number on the cart logo");
    }

    @Test(dependsOnMethods = "verifyTheRightQuantityOfAddedToCartItemsOnCartLogoTest")
    public void verifyNumberOfItemsOnCartLogoDecreasesAfterRemovalTest() {
        System.out.println(itemsInCartStart);
        inventoryPage.clickRemoveItemFromCartButtonByIndex(firstItem);
        itemsInCartStart=itemsInCartStart-1;
        int expectedQuantityOfItemsOnCartLogo = itemsInCartStart;
        int actualQuantityOfItemsOnCartLogo = inventoryPage.getQuantityOfItemsAddedToCart();
        Assert.assertEquals(actualQuantityOfItemsOnCartLogo, expectedQuantityOfItemsOnCartLogo, "The actual quantity of items added to the cart doesn't match the number on the cart logo");
    }

    private int itemsInCartStart() {
        try {
            itemsInCartStart = inventoryPage.getQuantityOfItemsAddedToCart();
            return itemsInCartStart;
        } catch (NoSuchElementException Ex) {
            return 0;
        }
    }

}
