package pages.inventory.components;

import core.elements.Button;
import core.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BaseComponent;

public class InventoryItem extends BaseComponent {
    private final Label name = new Label(By.cssSelector(".inventory_item_name"), root);
    private final Button addToCartButton = new Button(By.cssSelector(".btn_inventory"), root);

    public InventoryItem(WebElement root) {
        super(root);
    }

    public String getItemName() {
        return name.getText();
    }

    public void addItemToCart() {
        addToCartButton.click();
    }
}
