package uitests;

import org.alecrm.seleniumchallenge.drivers.DriverFactory;
import org.alecrm.seleniumchallenge.models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.TweetSteps;

public class TweetTest {

    private final DriverFactory factory = new DriverFactory();
    private WebDriver driver;
    private TweetSteps tweetSteps;
    private LoginSteps loginSteps;
    private final User user = new User("admin", "passw0rd");

    @BeforeMethod
    public void setup() {
        driver = factory.createDriver();
        tweetSteps = new TweetSteps(driver);
        loginSteps = new LoginSteps(driver);

        loginSteps.loginUser(user);
    }

    @AfterMethod
    public void teardown() {
        factory.closeDriver(driver);
    }

    @Test(
            description = "Publishes a tweet and confirms it exists"
    )
    public void publishTweetTest() {
        String tweet = "This is a test tweet!";

        tweetSteps.publishTweet(tweet);
        tweetSteps.confirmTweetExists(user, tweet + "!");
    }

    @Test(
            description = "Likes a tweet and confirms the like count raises by one"
    )
    public void likeTweetTest() {
        String tweet = "I bet this will get exactly 1 like.";

        tweetSteps.publishTweet(tweet);
        tweetSteps.likeTweetByUser(user, tweet);
        tweetSteps.confirmNumberOfTweetLikes(user, tweet, 1);
    }

    @Test(
            description = "Comments on a tweet and confirms the comment was published"
    )
    public void commentOnTweetTest() {
        String tweet = "I hope someone comments on this!";
        String comment = "Here you go, buddy. You seem lonely.";

        tweetSteps.publishTweet(tweet);
        tweetSteps.commentOnTweetByUser(user, tweet, comment);
        tweetSteps.confirmCommentOnTweetByUser(user, tweet, user, comment);
    }

}
