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

    @FindBy(css = "input[data-cy='signin-username-input']")
    WebElement usernameElement;

    @FindBy(css = "input[data-cy='signin-password-input']")
    public WebElement passwordElement;

    @FindBy(css = "button[data-cy='signin-button']")
    public WebElement loginButtonElement;

    public LoginPage setUsername(String username) {
        log.info("[LOGIN PAGE]: Entering [{}] in the 'username' field", username);
        usernameElement.sendKeys(username);

        return this;
    }

    public LoginPage setPassword(String password) {
        log.info("[LOGIN PAGE]: Entering [{}] in the 'password' field", password);
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
