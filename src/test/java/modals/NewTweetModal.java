package modals;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
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

    public NewTweetModal enterTweet(String tweet) {
        log.info("[NEW TWEET MODAL]: Entering [{}] into the tweet input field", tweet);
        WebElement tweetInputElement = driver.findElement(container).findElement(tweetInputLocator);
        tweetInputElement.sendKeys(tweet);

        return this;
    }

    public void clickTweet() {
        log.info("[NEW TWEET MODAL]: Publishing tweet");
        WebElement tweetButtonElement = driver.findElement(container).findElement(tweetButtonLocator);
        tweetButtonElement.click();
    }

    private final By tweetInputLocator = By.cssSelector("form textarea");
    private final By tweetButtonLocator = By.cssSelector("form button");
}
