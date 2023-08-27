package uitests;

import org.alecrm.seleniumchallenge.drivers.DriverFactory;
import org.alecrm.seleniumchallenge.models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.UserSteps;

public class UserTest {

    private final DriverFactory factory = new DriverFactory();
    private WebDriver driver;
    UserSteps userSteps;

    @BeforeClass
    public void setup() {
        driver = factory.createDriver();
        userSteps = new UserSteps(driver);
    }

    @AfterClass
    public void teardown() {
        factory.closeDriver(driver);
    }

    @Test(
            description = "Creates a user and confirms the Home Screen shows after submitting info"
    )
    public void createUserTest() {
        User user = new User("createUser2",
                             "createUser2",
                             "createUser2@email.com",
                             "passw0rd");

        userSteps.createUser(user);
        userSteps.confirmUserExists(user);
    }

}
