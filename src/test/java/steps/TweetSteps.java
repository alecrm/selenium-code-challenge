package steps;

import modals.NewTweetModal;
import org.alecrm.seleniumchallenge.models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;

public class TweetSteps extends BaseSteps {

    public TweetSteps(WebDriver driver) {
        super(driver);
    }

    public void publishTweet(String tweet) {
        NewTweetModal modal = new HomePage(driver).openNewTweetModal();
        modal.enterTweet(tweet)
                .clickTweet();
    }

    public void confirmTweetExists(User user, String tweet) {
        HomePage page = new HomePage(driver).openHomePage();
        Assert.assertTrue(page.getTweetByUser(user, tweet).isPresent());
    }

    public void confirmNumberOfTweetLikes(User user, String tweet, int likes) {
        HomePage page = new HomePage(driver).openHomePage();
        Assert.assertEquals(page.getTweetByUserLikes(user, tweet), likes);
    }

    public void likeTweetByUser(User user, String tweet) {
        HomePage page = new HomePage(driver).openHomePage();
        int beforeLikes = page.getTweetByUserLikes(user, tweet);
        page.likeTweetByUser(user, tweet);

        Assert.assertEquals(page.getTweetByUserLikes(user, tweet), beforeLikes + 1);
    }
}
