package steps;

import org.alecrm.seleniumchallenge.models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyProfilePage;

public class LoginSteps extends BaseSteps {

    public LoginSteps(WebDriver driver) {
        super(driver);
    }

    public void loginUser(User user) {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        driver.get(loginPage.getPageURL());

        loginPage.setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .clickLogin();

        Assert.assertEquals(driver.getCurrentUrl(), homePage.getPageURL());
    }

    public void confirmLoggedInUser(User user) {
        MyProfilePage page = new MyProfilePage(driver).openMyProfile();
        Assert.assertEquals(page.getProfileUsername(), "@" + user.getUsername().toLowerCase());
    }
}
