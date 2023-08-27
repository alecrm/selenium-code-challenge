package uitests;

import org.alecrm.seleniumchallenge.drivers.DriverFactory;
import org.alecrm.seleniumchallenge.models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.LoginSteps;

public class LoginTest {

    private final DriverFactory factory = new DriverFactory();
    private WebDriver driver;
    private LoginSteps loginSteps;


    @BeforeClass
    public void setup() {
        driver = factory.createDriver();
        loginSteps = new LoginSteps(driver);
    }

    @AfterClass
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
