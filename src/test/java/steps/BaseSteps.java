package steps;

import org.openqa.selenium.WebDriver;

public class BaseSteps {

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver driver;

}
