package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps extends BaseSteps {

    public LoginSteps(WebDriver driver) {
        super(driver);
    }

    public void loginUser(String username, String password) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        driver.get(loginPage.getPageURL());

        loginPage.setUsername(username)
                .setPassword(password)
                .clickLogin();

        Assert.assertEquals(driver.getCurrentUrl(), homePage.getPageURL());
    }
}
