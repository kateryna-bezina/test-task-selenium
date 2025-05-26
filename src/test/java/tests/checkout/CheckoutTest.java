package tests.checkout;

import data.records.CheckoutInfo;
import org.testng.annotations.Test;
import tests.BaseTest;

import static data.enums.Items.*;
import static data.enums.Users.STANDARD_USER;

public class CheckoutTest extends BaseTest {

    //TODO: think about using Flows level for clearer test structure
    //TODO: might want to use DataProvider for test data

    @Test(description = "Complete checkout process with valid data")
    public void testCompleteCheckout() {
        login()
                .openLoginPage()
                .loginAsUser(STANDARD_USER.getUsername(), STANDARD_USER.getPassword());
        inventory()
                .addItemToCart(SAUCE_LABS_BACKPACK.getItemName())
                .addItemToCart(SAUCE_LABS_FLEECE_JACKET.getItemName())
                .addItemToCart(SAUCE_LABS_ONESIE.getItemName())
                .navigateToCartPage();
        cart()
                .removeItemFromCart(SAUCE_LABS_ONESIE.getItemName())
                .checkItemIsNotInCart(SAUCE_LABS_ONESIE.getItemName());
        Double cartItemsTotal = cart().getItemsTotalPrice();
        cart()
                .navigateToCheckout();
        checkout()
                .fillCheckoutInformation(CheckoutInfo.defaultInfo())
                .assertTotalPriceIsCorrectSumOfSubtotalAndTax(cartItemsTotal)
                .completeCheckout()
                .assertCheckoutCompletePageDisplayed();
    }
}
