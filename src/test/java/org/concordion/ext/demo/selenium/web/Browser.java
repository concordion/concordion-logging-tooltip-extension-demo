package org.concordion.ext.demo.selenium.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.concordion.ext.selenium.SeleniumEventLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Manages the browser session. 
 */
public class Browser {
    static {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;
    
    public Browser() {
        ChromeOptions options = new ChromeOptions();
        if (("true").equals(System.getenv("HEADLESS_CHROME"))) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        driver = new ChromeDriver(options);
    }
    
    public void close() {
        driver.close();
    }
    
    public void addLogger() {
        EventFiringWebDriver efwd = new EventFiringWebDriver(driver);
        efwd.register(new SeleniumEventLogger());
        driver = efwd;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
