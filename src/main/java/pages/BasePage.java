package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    public static final String BASE_URL = "https://www.saucedemo.com";
    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract String getPagePath();

    public String getPageUrl() {
        return BASE_URL + getPagePath();
    }

    public void openPage() {
        driver.get(getPageUrl());
    }
}

