package pages;

import org.alecrm.seleniumchallenge.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Optional;

import static java.lang.String.format;

public class AllProfilesPage extends BasePage {

    public AllProfilesPage(WebDriver driver) {
        super(driver, "profiles");
    }

    public Optional<WebElement> getProfile(User user) {
        try {
            return Optional.of(driver.findElement(profileByUsername(user.getUsername())));
        } catch (NoSuchElementException e) {
            return Optional.empty();
        }
    }

    private By profileByUsername(String username) {
        return By.xpath(format(".//p[normalize-space()='@%s']//ancestor::li", username.toLowerCase()));
    }
}
