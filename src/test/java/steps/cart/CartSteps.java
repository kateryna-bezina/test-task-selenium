package steps.cart;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.cart.CartPage;

public class CartSteps {
    private final CartPage cartPage;

    public CartSteps(WebDriver driver) {
        this.cartPage = new CartPage(driver);
    }

    @Step("Proceed to checkout")
    public void navigateToCheckout() {
        cartPage.clickCheckoutButton();
    }

    @Step("Get items total price")
    public Double getItemsTotalPrice() {
        return cartPage.getCartItemsPrice();
    }

    @Step("Remove item from cart with name: {itemName}")
    public CartSteps removeItemFromCart(String itemName) {
        cartPage.removeItemFromCart(itemName);
        return this;
    }

    @Step("Check item is not present in cart with name: {itemName}")
    public CartSteps checkItemIsNotInCart(String itemName) {
        Assertions.assertThat(cartPage.isItemPresentInCart(itemName))
                .as("Item with name '%s' should not be present in the cart", itemName)
                .isFalse();
        return this;
    }
}
