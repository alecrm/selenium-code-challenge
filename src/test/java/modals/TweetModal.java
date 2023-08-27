package modals;

import org.alecrm.seleniumchallenge.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;
import java.util.Optional;

import static java.lang.String.format;

public class TweetModal extends BaseModal {

    public TweetModal(WebDriver driver, String author, String tweet) {
        super(driver, By.cssSelector("div[aria-label='Tweet']"));
        this.author = author;
        this.tweet = tweet;
    }

    private final String author;
    private final String tweet;

    public String getTweetAuthor() {
        return driver.findElement(tweetAuthorLocator).getText();
    }

    public String getTweetText() {
        return driver.findElement(tweetTextLocator).getText();
    }

    public void enterComment(String comment) {
        driver.findElement(container).findElement(inputCommentLocator).sendKeys(comment);
        driver.findElement(container).findElement(inputCommentLocator).sendKeys(Keys.ENTER);
    }

    public Optional<WebElement> getCommentByUser(User user, String comment) {
        return Optional.of(driver.findElement(container)
                                   .findElement(commentByUserLocator(user.getUsername(), comment)));
    }

    public void closeTweetModal() {
        driver.findElement(container).sendKeys(Keys.ESCAPE);
        new WebDriverWait(driver, Duration.ofMillis(5000)).until(
                ExpectedConditions.urlToBe(new HomePage(driver).getPageURL()));
    }

    @Override
    public boolean isOpen() {
        if (driver.findElements(container).size() == 1) {
            return driver.findElement(container).isDisplayed() && author.equals(getTweetAuthor()) &&
                    tweet.equals(getTweetText());
        }
        return false;
    }

    private final By tweetAuthorLocator = By.xpath(
            ".//div[contains(@class,'UserInfo')]//a[contains(@class,'Username')]");
    private final By tweetTextLocator = By.xpath(
            ".//div[contains(@class,'TweetContent')]//p[contains(@class,'TweetText')]");
    private final By inputCommentLocator = By.cssSelector("input");

    private By commentByUserLocator(String username, String comment) {
        return By.xpath(format(".//ul//span[normalize-space()='%s']//ancestor::li//p[normalize-space()='%s']",
                               username.toLowerCase(), comment));
    }

}
