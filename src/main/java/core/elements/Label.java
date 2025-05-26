package core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class Label extends BaseElement {
    public Label(By locator) {
        super(locator);
    }

    public Label(By locator, SearchContext root) {
        super(locator, root);
    }
}
