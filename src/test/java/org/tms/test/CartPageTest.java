package org.tms.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.page.CartPage;
import org.tms.page.InventoryPage;
import org.tms.service.LoginPageService;

public class CartPageTest extends BaseTest{

    private InventoryPage inventoryPage = new InventoryPage();
    private LoginPageService loginPageService = new LoginPageService();
    private CartPage cartPage = new CartPage();

    @BeforeClass
    public void login(){
        loginPageService.login();
    }

    @Test(priority = 1)
    public void verifyCorrectPriceDisplayedOnCartPageTest(){
        inventoryPage.clickAddTheFirstItemToCartButton();
        String expectedPriceOfItem = inventoryPage.getTextOfPriceOfTheFirstItem();
        inventoryPage.clickShoppingCartButton();
        String actualPriceOfItem = cartPage.getTextOfPriceOfAnItemInCart();
        Assert.assertEquals(actualPriceOfItem, expectedPriceOfItem, "The price of the first item in the cart doesn't match the expected one!");
    }

    @Test(priority = 2)
    public void verifyItemRemovedFromCartWhenClickingRemoveButtonTest(){
        cartPage.clickRemoveButton();
        Boolean actualCartListDisplayed = cartPage.verifyTheCartListIsEmpty();
        Boolean expectedCartListDisplayed = false;
        Assert.assertEquals( (boolean) actualCartListDisplayed, (boolean) expectedCartListDisplayed, "The cart isn't empty");
    }

    @Test(priority = 3)
    public void verifyTransferToInventoryPageWhenClickingContinueShoppingButtonTest(){
        cartPage.clickContinueShoppingButton();
        String actualTextOfInventoryPage = inventoryPage.getTextNameOfMainPageSection();
        String expectedPageText = "PRODUCTS";
        Assert.assertEquals(actualTextOfInventoryPage, expectedPageText, "Actual text doesn't match expected one!");
    }

}
