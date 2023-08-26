package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(WebDriver driver, String pageURL) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.pageURL = "http://localhost:3000/" + pageURL;
    }

    protected WebDriver driver;
    @Getter
    protected String pageURL;

    protected boolean isOpen() {
        return driver.getCurrentUrl().equals(pageURL);
    }

}
