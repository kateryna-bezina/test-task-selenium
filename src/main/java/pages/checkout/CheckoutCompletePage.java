package pages.checkout;

import core.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CheckoutCompletePage extends BasePage {
    private static final String CHECKOUT_COMPLETE_PAGE_PATH = "checkout-complete.html";

    private final Label thankYouMessage = new Label(By.cssSelector(".complete-header"));

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPagePath() {
        return CHECKOUT_COMPLETE_PAGE_PATH;
    }

    public boolean isThankYouMessageDisplayed() {
        return thankYouMessage.isDisplayed();
    }
}
