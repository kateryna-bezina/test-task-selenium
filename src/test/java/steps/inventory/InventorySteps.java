package steps.inventory;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.inventory.InventoryPage;

public class InventorySteps {
    private final InventoryPage inventoryPage;

    public InventorySteps(WebDriver driver) {
        this.inventoryPage = new InventoryPage(driver);
    }

    @Step("Add item to cart with name: {itemName}")
    public InventorySteps addItemToCart(String itemName) {
        inventoryPage.addItemToCart(itemName);
        return this;
    }

    @Step("Navigate to Cart page")
    public void navigateToCartPage() {
        inventoryPage.clickOnCartButton();
    }
}
