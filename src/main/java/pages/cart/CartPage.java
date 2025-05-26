package pages.cart;

import core.elements.Button;
import core.elements.ElementsContext;
import core.utils.PriceParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.cart.components.CartItem;

import java.util.List;
import java.util.NoSuchElementException;

public class CartPage extends BasePage {
    private static final String CART_PAGE_PATH = "cart.html";

    private final Button checkoutButton = new Button(By.cssSelector(".checkout_button"));

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPagePath() {
        return CART_PAGE_PATH;
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public Double getCartItemsPrice() {
        return getItems().stream()
                .map(CartItem::getItemPrice)
                .map(PriceParser::parse)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public void removeItemFromCart(String itemName) {
        getItemByName(itemName).removeItemFromCart();
    }

    public boolean isItemPresentInCart(String itemName) {
        return getItems().stream()
                .map(CartItem::getItemName)
                .toList()
                .contains(itemName);
    }

    private CartItem getItemByName(String itemName) {
        return getItems().stream()
                .filter(item -> item.getItemName().equals(itemName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("There is no item with title: " + itemName));
    }

    private List<CartItem> getItems() {
        return new ElementsContext(driver).list(By.cssSelector(".cart_item"), CartItem::new);
    }
}
