package core.elements;

import core.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseElement {
    protected final By locator;
    protected final SearchContext context;
    protected final Duration timeout = Duration.ofSeconds(5);

    public BaseElement(By locator) {
        this(locator, DriverManager.getDriver());
    }

    public BaseElement(By locator, SearchContext context) {
        this.locator = locator;
        this.context = context;
    }

    public void click() {
        findElement().click();
    }

    public String getText() {
        return findElement().getText();
    }

    public boolean isDisplayed() {
        try {
            WebElement element = findElement();
            return element != null && element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            return false;
        }
    }
    protected WebDriver driver() {
        return DriverManager.getDriver();
    }

    protected WebDriverWait webDriverWait() {
        return new WebDriverWait(driver(), timeout);
    }

    protected WebElement findElement() {
        if (context instanceof WebDriver) {
            return webDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        } else {
            return webDriverWait().until(driver -> {
                WebElement el = context.findElement(locator);
                return el.isDisplayed() ? el : null;
            });
        }
    }

}
