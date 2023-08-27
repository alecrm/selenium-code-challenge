package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BasePage {

    public MyProfilePage(WebDriver driver) {
        super(driver, "profile");
    }

    @FindBy(css = "span[class='Profile___StyledSpan2-sc-1ddc1ma-6 lpvDgC']")
    public WebElement profileUsernameElement;

    public String getProfileUsername() {
        return profileUsernameElement.getText();
    }

}
