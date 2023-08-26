package uitests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.LoginSteps;

public class LoginTest extends BaseTest {

    LoginSteps loginSteps;

    @BeforeClass
    public void setup() {
        driver = factory.createDriver();
        loginSteps = new LoginSteps(driver);
    }

    @AfterClass
    public void teardown() {
        factory.closeDriver(driver);
    }

    @Test
    public void loginTest() {
        String username = "admin";
        String password = "passw0rd"; // Most secure password ever

        loginSteps.loginUser(username, password);
    }

}
