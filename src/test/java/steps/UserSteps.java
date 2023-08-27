package steps;

import com.beust.ah.A;
import org.alecrm.seleniumchallenge.models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AllProfilesPage;
import pages.HomePage;
import pages.SignupPage;

public class UserSteps extends BaseSteps {

    public UserSteps(WebDriver driver) {
        super(driver);
    }

    public void createUser(User user) {
        HomePage homePage = new HomePage(driver);
        SignupPage signupPage = new SignupPage(driver);

        driver.get(signupPage.getPageURL());

        signupPage.enterName(user.getName())
                .enterUsername(user.getUsername())
                .enterEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .enterConfirmationPassword(user.getPassword())
                .clickSignUp();

        Assert.assertEquals(driver.getCurrentUrl(), homePage.getPageURL());
    }

    public void confirmUserExists(User user) {
        AllProfilesPage page = new AllProfilesPage(driver).clickAllProfiles();
        Assert.assertTrue(page.getProfile(user).isPresent());
    }
}
