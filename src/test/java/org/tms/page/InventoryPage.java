package org.tms.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends Page {

    @FindBy(xpath = "//span[@class='title']")
    private WebElement nameOfMainPageSection;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement quantityOfItemsAddedToCart;

    @FindBy(xpath = "//div[@class='inventory_item'][1]//button[contains(text(), 'Add to cart')]")
    private WebElement addTheFirstItemToCartButton;

    @FindBy(xpath = "//div[@class='inventory_item'][1]//button[contains(text(), 'Remove')]")
    private WebElement removeTheFirstItemFromCartButton;

    @FindBy(xpath = "//div[@class='inventory_item'][2]//button[contains(text(), 'Add to cart')]")
    private WebElement addTheSecondItemToCartButton;

    @FindBy(xpath = "//div[@class='inventory_item'][3]//button[contains(text(), 'Add to cart')]")
    private WebElement addTheThirdItemToCartButton;

    @FindBy(xpath = "//div[@class='inventory_item'][1]//div[@class='inventory_item_price']")
    private WebElement priceOfTheFirstItem;

    public String getTextNameOfMainPageSection() {
        return nameOfMainPageSection.getText();
    }

    public void clickShoppingCartButton() {
        shoppingCartButton.click();
    }

    public String getQuantityOfItemsAddedToCart(){
        return quantityOfItemsAddedToCart.getText();
    }

    public void clickAddTheFirstItemToCartButton() {
        addTheFirstItemToCartButton.click();
    }

    public void clickRemoveTheFirstItemFromCartButton() {
        removeTheFirstItemFromCartButton.click();
    }

    public void clickAddTheSecondItemToCartButton() {
        addTheSecondItemToCartButton.click();
    }

    public void clickAddTheThirdItemToCartButton() {
        addTheThirdItemToCartButton.click();
    }

    public String getTextOfPriceOfTheFirstItem(){
        return priceOfTheFirstItem.getText();
    }

}
