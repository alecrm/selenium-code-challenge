package org.alecrm.seleniumchallenge.drivers;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

import static java.lang.String.format;

/**
 * Factory class for generating drivers. Currently only works with Chrome, but could be extended to work with others.
 *
 * @author alec.millar
 */
@Log4j2
public class DriverFactory {

    private final String[] chromeOptionArgs = {
            "--no-default-browser-check",
            "--disable-background-timer-throttling",
            "--disable-backgrounding-occluded-windows",
            "--disable-renderer-backgrounding",
            "--disable-certificate-errors"
    };

    private static final ChromeOptions chromeOptions = new ChromeOptions();

    public DriverFactory() {
        log.trace("[DRIVER]: Detecting OS and setting webdriver path...");
        String os = System.getProperty("os.name");
        System.out.println(os);
        String driverResourcePath = System.getProperty("user.dir") + "/src/main/resources/drivers";
        String webDriverPath;

        if (os.startsWith("Windows")) {
            webDriverPath = driverResourcePath + "/windows/chromedriver.exe";
        } else if (os.startsWith("Mac")) {
            webDriverPath = driverResourcePath + "/mac/chromedriver";
        } else if (os.startsWith("Linux")) {
            webDriverPath = driverResourcePath + "/linux/chromedriver";
        } else {
            throw new NotImplementedException(format("[DRIVER]: [%s] OS has not been implemented yet.", os));
        }

        log.trace("[DRIVER]: Setting web driver path to: [{}]", webDriverPath);
        System.setProperty("webdriver.chrome.driver", webDriverPath);

        log.trace("[DRIVER]: Setting the following chrome option args: [{}]", Arrays.asList(chromeOptionArgs));
        for (String arg : chromeOptionArgs) {
            chromeOptions.addArguments(arg);
        }
    }

    /**
     * Creates and opens a chrome WebDriver at maximized size after passing through a predefined set of options.
     *
     * @return Requested chrome WebDriver
     */
    public WebDriver createDriver() {
        log.debug("[DRIVER]: Instantiating chrome browser");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * Exits a given chrome WebDriver
     *
     * @param driver The WebDriver to quit out of
     */
    public void closeDriver(WebDriver driver) {
        log.debug("[DRIVER]: Quitting out of driver");
        driver.quit();
    }
}
