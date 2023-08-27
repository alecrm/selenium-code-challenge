package modals;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Optional;

public class NewTweetModal {

    public NewTweetModal(WebDriver driver) {
        this.driver = driver;
        this.container = By.cssSelector("div[aria-label='Compose new tweet']");
    }

    private final WebDriver driver;
    @Getter
    private final By container;


    public boolean isOpen() {
        return driver.findElement(container).isDisplayed();
    }
}
