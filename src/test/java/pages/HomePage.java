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

    public void likeTweetByUser(User user, String tweet) {
        driver.findElement(tweetByUserLikesLocator(user.getUsername(), tweet)).click();
    }

    public Optional<WebElement> getTweetByUser(User user, String tweet) {
        return Optional.of(driver.findElement(tweetByUserLocator(user.getUsername(), tweet)));
    }

    public int getTweetByUserLikes(User user, String tweet) {
        return Integer.parseInt(driver.findElement(tweetByUserLikesLocator(user.getUsername(), tweet)).getText());
    }

    private By tweetByUserLocator(String username, String tweet) {
        return By.xpath(format(".//span[normalize-space()='%s']//ancestor::li//p[normalize-space()='%s']",
                               username.toLowerCase(), tweet));
    }

    private By tweetByUserLikesLocator(String username, String tweet) {
        return By.xpath(format(".//span[normalize-space()='%s']//ancestor::li//p[normalize-space()='%s']//ancestor::div[contains(@class,'ListItemContent')]//button[span[contains(@class,'LikeIcon')]]",
                               username.toLowerCase(), tweet));
    }
}
