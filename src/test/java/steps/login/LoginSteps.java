package steps.login;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.login.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
    }

    @Step("Open login page")
    public LoginSteps openLoginPage() {
        loginPage.openPage();
        return this;
    }

    @Step("Login as user with username: {username} and password: {password}")
    public void loginAsUser(String username, String password) {
        loginPage.login(username, password);
    }
}
