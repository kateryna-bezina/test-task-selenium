package pages.inventory;

import core.elements.Button;
import core.elements.ElementsContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.inventory.components.InventoryItem;

import java.util.List;
import java.util.NoSuchElementException;

public class InventoryPage extends BasePage {
    private static final String INVENTORY_PAGE_PATH = "inventory.html";
    //TODO: move to the common component - Header
    private final Button cartButton = new Button(By.cssSelector(".shopping_cart_container"));

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPagePath() {
        return INVENTORY_PAGE_PATH;
    }

    public void addItemToCart(String itemName) {
        getItemByName(itemName).addItemToCart();
    }

    public void clickOnCartButton() {
        cartButton.click();
    }

    private InventoryItem getItemByName(String itemName) {
        return getItems().stream()
                .filter(item -> item.getItemName().equals(itemName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("There is no item with title: " + itemName));
    }

    private List<InventoryItem> getItems() {
        return new ElementsContext(driver).list(By.cssSelector(".inventory_item"), InventoryItem::new);
    }
}
