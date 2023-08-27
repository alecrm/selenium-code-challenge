package pages;

import org.alecrm.seleniumchallenge.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Optional;

import static java.lang.String.format;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver, "");
    }

    public Optional<WebElement> getTweetByUser(User user, String tweet) {
        return Optional.of(driver.findElement(tweetByUser(user.getUsername(), tweet)));
    }

    private By tweetByUser(String username, String tweet) {
        return By.xpath(format(".//span[normalize-space()='%s']//ancestor::li//p[normalize-space()='%s']",
                               username.toLowerCase(), tweet));
    }
}
