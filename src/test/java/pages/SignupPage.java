package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver, "signup");
    }
    
    @FindBy(css = "input[data-cy='signup-name-input']")
    public WebElement nameElement;

    @FindBy(css = "input[data-cy='signup-username-input']")
    public WebElement usernameElement;

    @FindBy(css = "input[data-cy='signup-email-input']")
    public WebElement emailElement;

    @FindBy(css = "input[data-cy='signup-password-input']")
    public WebElement passwordElement;

    @FindBy(css = "input[data-cy='signup-password2-input']")
    public WebElement confirmationPasswordElement;

    @FindBy(css = "button[data-cy='signup-submit']")
    public WebElement signUpButtonElement;
    
    public SignupPage enterName(String name) {
        log.info("[SIGNUP PAGE]: Entering [{}] in the 'name' field", name);
        nameElement.sendKeys(name);

        return this;
    }

    public SignupPage enterUsername(String username) {
        log.info("[SIGNUP PAGE]: Entering [{}] in the 'username' field", username);
        usernameElement.sendKeys(username);

        return this;
    }

    public SignupPage enterEmail(String email) {
        log.info("[SIGNUP PAGE]: Entering [{}] in the 'email' field", email);
        emailElement.sendKeys(email);

        return this;
    }

    public SignupPage enterPassword(String password) {
        log.info("[SIGNUP PAGE]: Entering [{}] in the 'password' field", password);
        passwordElement.sendKeys(password);

        return this;
    }

    public SignupPage enterConfirmationPassword(String confirmationPassword) {
        log.info("[SIGNUP PAGE]: Entering [{}] in the 'confirmation password' field", confirmationPassword);
        confirmationPasswordElement.sendKeys(confirmationPassword);

        return this;
    }

    public HomePage clickSignUp() {
        log.info("[SIGNUP PAGE]: Clicking the [Sign Up] button to submit signup credentials");
        HomePage page = new HomePage(driver);
        signUpButtonElement.click();
        new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.urlToBe(page.getPageURL()));
        return page;
    }

}
