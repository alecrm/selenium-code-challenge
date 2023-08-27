package uitests;

import org.alecrm.seleniumchallenge.drivers.DriverFactory;
import org.alecrm.seleniumchallenge.models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.LoginSteps;

public class LoginTest {

    private final DriverFactory factory = new DriverFactory();
    private WebDriver driver;
    private LoginSteps loginSteps;

    @BeforeMethod
    public void setup() {
        driver = factory.createDriver();
        loginSteps = new LoginSteps(driver);
    }

    @AfterMethod
    public void teardown() {
        factory.closeDriver(driver);
    }

    @Test(
            description = "Enters login credentials and confirms the Home Page shows"
    )
    public void loginTest() {
        User user = new User("admin", "passw0rd");

        loginSteps.loginUser(user);
        loginSteps.confirmLoggedInUser(user);
    }

}
