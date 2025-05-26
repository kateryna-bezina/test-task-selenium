package pages.checkout;

import core.elements.Button;
import core.elements.Label;
import core.utils.PriceParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CheckoutOverviewPage extends BasePage {
    private static final String CHECKOUT_OVERVIEW_PAGE_PATH = "checkout-step-two.html";

    private final Button finishButton = new Button(By.cssSelector(".cart_button"));
    private final Label taxPrice = new Label(By.cssSelector(".summary_tax_label"));
    private final Label totalPrice = new Label(By.cssSelector(".summary_total_label"));

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPagePath() {
        return CHECKOUT_OVERVIEW_PAGE_PATH;
    }

    public Double getTaxPrice() {
        return PriceParser.parse(taxPrice.getText());
    }

    public Double getTotalPrice() {
        return PriceParser.parse(totalPrice.getText());
    }

    public void clickFinishButton() {
        finishButton.click();
    }
}
