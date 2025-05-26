package tests;

import core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.StepRegistry;
import steps.cart.CartSteps;
import steps.checkout.CheckoutSteps;
import steps.inventory.InventorySteps;
import steps.login.LoginSteps;
import utils.ScreenshotUtils;

public class BaseTest {
    protected WebDriver driver;
    private StepRegistry stepRegistry;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        //TODO: might be refactored to WebDriverFactory approach later
        driver = new ChromeDriver();
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();

        stepRegistry = new StepRegistry(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtils.takeScreenshot();
        }
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            driver.quit();
            DriverManager.removeDriver();
        }
    }

    protected LoginSteps login() {
        return stepRegistry.get(LoginSteps.class);
    }

    protected InventorySteps inventory() {
        return stepRegistry.get(InventorySteps.class);
    }

    protected CartSteps cart() {
        return stepRegistry.get(CartSteps.class);
    }

    protected CheckoutSteps checkout() {
        return stepRegistry.get(CheckoutSteps.class);
    }
}
