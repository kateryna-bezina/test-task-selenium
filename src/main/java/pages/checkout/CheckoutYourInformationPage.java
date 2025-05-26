package pages.checkout;

import core.elements.Button;
import core.elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CheckoutYourInformationPage extends BasePage {
    private static final String CHECKOUT_INFO_PAGE_PATH = "checkout-step-one.html";

    private final Input firstNameInput = new Input(By.cssSelector("#first-name"));
    private final Input lastNameInput = new Input(By.cssSelector("#last-name"));
    private final Input postalCodeInput = new Input(By.cssSelector("#postal-code"));
    private final Button continueButton = new Button(By.cssSelector("#continue"));

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPagePath() {
        return CHECKOUT_INFO_PAGE_PATH;
    }

    public void fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void fillPostalCode(String postalCode) {
        postalCodeInput.sendKeys(postalCode);
    }

    public void clickContinue() {
        continueButton.click();
    }
}
