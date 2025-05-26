package pages.cart.components;

import core.elements.Button;
import core.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseComponent;

public class CartItem extends BaseComponent {
    private final Label name = new Label(By.cssSelector(".cart_item_label a"), root);
    private final Label price = new Label(By.cssSelector(".item_pricebar"), root);
    private final Button removeFromCartButton = new Button(By.cssSelector(".cart_button"), root);

    public CartItem(WebElement root) {
        super(root);
    }

    public String getItemName() {
        return name.getText();
    }

    public String getItemPrice() {
        return price.getText();
    }

    public void removeItemFromCart() {
        removeFromCartButton.click();
    }
}
