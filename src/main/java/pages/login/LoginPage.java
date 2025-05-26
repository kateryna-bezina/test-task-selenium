package pages.login;

import core.elements.Button;
import core.elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class LoginPage extends BasePage {
    private static final String LOGIN_PAGE_PATH = "";

    private final Input userNameInput = new Input(By.cssSelector("#user-name"));
    private final Input passwordInput = new Input(By.cssSelector("#password"));
    private final Button loginButton = new Button(By.cssSelector("#login-button"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPagePath() {
        return LOGIN_PAGE_PATH;
    }

    public void login(String name, String password) {
        userNameInput.sendKeys(name);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}

