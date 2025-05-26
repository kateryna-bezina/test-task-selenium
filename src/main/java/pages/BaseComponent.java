package pages;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class BaseComponent {
    protected final SearchContext root;

    public BaseComponent(WebElement root) {
        this.root = root;
    }
}