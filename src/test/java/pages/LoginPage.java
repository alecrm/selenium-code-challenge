package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//http://localhost:3000/signin
@Log4j2
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver, "signin");
    }

    private final String usernameLocator = "input[data-cy='signin-username-input']";
    @FindBy(css = usernameLocator)
    WebElement usernameElement;

    private final String passwordLocator = "input[data-cy='signin-password-input']";
    @FindBy(css = passwordLocator)
    public WebElement passwordElement;

    private final String loginButtonLocator = "button[data-cy='signin-button']";
    @FindBy(css = loginButtonLocator)
    public WebElement loginButtonElement;

    public LoginPage setUsername(String username) {
        log.info("[LOGIN PAGE]: Entering the username [{}]", username);
        usernameElement.sendKeys(username);

        return this;
    }

    public LoginPage setPassword(String password) {
        log.info("[LOGIN PAGE]: Entering the password [{}]", password);
        passwordElement.sendKeys(password);

        return this;
    }

    public HomePage clickLogin() {
        log.info("[LOGIN PAGE]: Clicking the [Log In] button to submit login credentials");
        HomePage page = new HomePage(driver);
        loginButtonElement.click();
        new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.urlToBe(page.getPageURL()));
        return page;
    }

}
