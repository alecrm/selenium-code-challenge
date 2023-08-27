package uitests;

import org.alecrm.seleniumchallenge.models.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.UserSteps;

public class UserTest extends BaseTest {

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
    public void createUser() {
        User user = new User("createUser",
                             "createUser",
                             "createUser@email.com",
                             "passw0rd");

        userSteps.createUser(user);
    }

}
