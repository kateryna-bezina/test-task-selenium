package steps.checkout;

import data.records.CheckoutInfo;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.checkout.CheckoutCompletePage;
import pages.checkout.CheckoutOverviewPage;
import pages.checkout.CheckoutYourInformationPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutSteps {
    private final CheckoutYourInformationPage checkoutYourInformationPage;
    private final CheckoutOverviewPage checkoutOverviewPage;
    private final CheckoutCompletePage checkoutCompletePage;

    public CheckoutSteps(WebDriver driver) {
        this.checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        this.checkoutOverviewPage = new CheckoutOverviewPage(driver);
        this.checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @Step("Checkout complete page is displayed")
    public void assertCheckoutCompletePageDisplayed() {
        assertThat(checkoutCompletePage.isThankYouMessageDisplayed())
                .as("Checkout complete page should be displayed")
                .isTrue();
    }

    @Step("Fill in checkout information with first name: {firstName}, last name: {lastName}, postal code: {postalCode}")
    public CheckoutSteps fillCheckoutInformation(CheckoutInfo info) {
        checkoutYourInformationPage.fillFirstName(info.firstName());
        checkoutYourInformationPage.fillLastName(info.lastName());
        checkoutYourInformationPage.fillPostalCode(info.postalCode());
        checkoutYourInformationPage.clickContinue();
        return this;
    }

    @Step("Check total price is calculated correctly")
    public CheckoutSteps assertTotalPriceIsCorrectSumOfSubtotalAndTax(Double expectedSubtotal) {
        Double checkoutTotal = checkoutOverviewPage.getTotalPrice();
        Double expectedTotal = expectedSubtotal + checkoutOverviewPage.getTaxPrice();

        assertThat(checkoutTotal)
                .as("Total price should match the sum of subtotal and tax")
                .isEqualTo(expectedTotal);
        return this;
    }

    @Step("Complete checkout")
    public CheckoutSteps completeCheckout() {
        checkoutOverviewPage.clickFinishButton();
        return this;
    }
}
