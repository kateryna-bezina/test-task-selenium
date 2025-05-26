package core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class Input extends BaseElement {
    public Input(By locator) {
        super(locator);
    }

    public Input(By locator, SearchContext root) {
        super(locator, root);
    }

    public void sendKeys(String text) {
        WebElement element = findElement();
        element.clear();
        element.sendKeys(text);
    }
}
