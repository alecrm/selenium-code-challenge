package modals;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseModal {

    public BaseModal(WebDriver driver, By container) {
        this.driver = driver;
        this.container = container;
    }

    protected final WebDriver driver;
    @Getter
    protected final By container;

    public boolean isOpen() {
        return driver.findElement(container).isDisplayed();
    }

}
