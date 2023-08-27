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
}
