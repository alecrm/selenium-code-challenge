package pages;

import lombok.extern.log4j.Log4j2;
import modals.TweetModal;
import org.alecrm.seleniumchallenge.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

import static java.lang.String.format;

@Log4j2
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver, "");
    }

    public void likeTweetByUser(User user, String tweet) {
        driver.findElement(tweetByUserLikesLocator(user.getUsername(), tweet)).click();
    }

    public Optional<WebElement> getTweetByUser(User user, String tweet) {
        try {
            return Optional.of(driver.findElement(tweetByUserLocator(user.getUsername(), tweet)));
        } catch (NoSuchElementException e) {
            return Optional.empty();
        }
    }

    public int getTweetByUserLikes(User user, String tweet) {
        return Integer.parseInt(driver.findElement(tweetByUserLikesLocator(user.getUsername(), tweet)).getText());
    }

    public TweetModal openTweetByUser(User user, String tweet) {
        TweetModal modal = new TweetModal(driver, user.getUsername().toLowerCase(), tweet);
        if (modal.isOpen()) {
            log.info("[HOME PAGE]: Tweet is already open!");
            return modal;
        }

        log.info("[HOME PAGE]: Opening provided tweet");
        driver.findElement(tweetByUserOpenLocator(user.getUsername(), tweet)).click();
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.visibilityOf(driver.findElement(modal.getContainer())));
        return modal;
    }

    private By tweetByUserLocator(String username, String tweet) {
        return By.xpath(format(".//span[normalize-space()='%s']//ancestor::li//p[normalize-space()='%s']",
                               username.toLowerCase(), tweet));
    }

    private By tweetByUserLikesLocator(String username, String tweet) {
        return By.xpath(format(".//span[normalize-space()='%s']//ancestor::li//p[normalize-space()='%s']//ancestor::div[contains(@class,'ListItemContent')]//button[span[contains(@class,'LikeIcon')]]",
                               username.toLowerCase(), tweet));
    }

    private By tweetByUserOpenLocator(String username, String tweet) {
        return By.xpath(format(".//span[normalize-space()='%s']//ancestor::li//p[normalize-space()='%s']//ancestor::div[contains(@class,'ListItemContent')]//button[*[name()='svg']]",
                               username.toLowerCase(), tweet));
    }
}
