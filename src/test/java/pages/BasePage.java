package pages;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class BasePage {

    public BasePage(WebDriver driver, String pageURL) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.pageURL = "http://localhost:3000/" + pageURL;
    }

    protected WebDriver driver;
    @Getter
    protected String pageURL;

    @FindBy(css = "a[class='components__StyledNavLink-jhoq2c-10 fQUpas']")
    public WebElement allProfilesButtonElement;

    @FindBy(id = "menu-button--menu--1")
    public WebElement userMenuButtonElement;

    @FindBy(css = "a[data-valuetext='Profile']")
    public WebElement myProfileButtonElement;
    
    public AllProfilesPage clickAllProfiles() {
        log.info("[BASE PAGE]: Clicking the [All Profiles] button");
        AllProfilesPage page = new AllProfilesPage(driver);
        allProfilesButtonElement.click();
        new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.urlToBe(page.getPageURL()));
        return page;
    }

    public MyProfilePage openMyProfile() {
        log.info("[BASE PAGE]: Navigating to current user's profile");
        MyProfilePage page = new MyProfilePage(driver);
        userMenuButtonElement.click();
        myProfileButtonElement.click();
        return page;
    }

    protected boolean isOpen() {
        return driver.getCurrentUrl().equals(pageURL);
    }

}
