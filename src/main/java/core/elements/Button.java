package core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class Button extends BaseElement {
    public Button(By locator) {
        super(locator);
    }

    public Button(By locator, SearchContext root) {
        super(locator, root);
    }
}
