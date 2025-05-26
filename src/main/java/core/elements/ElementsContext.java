package core.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Function;

public final class ElementsContext {

    private final SearchContext context;

    public ElementsContext(SearchContext context) {
        this.context = context;
    }

    public <T> List<T> list(By locator, Function<WebElement, T> wrapper) {
        return context.findElements(locator).stream()
                .map(wrapper)
                .toList();
    }
}
