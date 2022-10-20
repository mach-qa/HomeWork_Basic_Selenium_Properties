package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserEnvironment {
    private WebDriver driver;

    private String browserName;
    private boolean headless;
    private int timeout;
    private boolean attachScreenShot;

    private Logger logger;

    public BrowserEnvironment() {
        logger = LoggerFactory.getLogger(BrowserEnvironment.class);
        this.browserName = PropertyStore.BROWSER.isSpecified() ? PropertyStore.BROWSER.getValue() : this.browserName;
        this.headless = false;
        this.timeout = 15;
        this.attachScreenShot = false;
        this.initBrowserSettings();
    }

    private void initBrowserSettings() {
        this.timeout = PropertyStore.BROWSER_TIMEOUT.isSpecified() ? PropertyStore.BROWSER_TIMEOUT.getIntValue() : this.timeout;
        //this.webBrowserImplicitTimeOut = PropertyStore.BROWSER_IMPLICIT_TIMEOUT.isSpecified() ? PropertyStore.BROWSER_IMPLICIT_TIMEOUT.getIntValue() : this.webBrowserImplicitTimeOut;
        this.attachScreenShot = PropertyStore.BROWSER_ATTACH_SCREENSHOT.isSpecified() ? PropertyStore.BROWSER_ATTACH_SCREENSHOT.getBoolean() : this.attachScreenShot;
        this.headless = PropertyStore.HEADLESS_MODE.getBoolean();
    }

    public WebDriver getDriver() {
        WebDriver driver;
        switch (this.browserName) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);
                driver.get(System.getProperty("appUrl"));
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
                optionsFirefox.addArguments("start-maximized");
                driver = new FirefoxDriver(optionsFirefox);
                driver.get(System.getProperty("appUrl"));
                break;
            default:
                InternetExplorerOptions optionsDefault = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(optionsDefault);
                driver.get(System.getProperty("appUrl"));
                break;
        }
        this.driver = driver;
        return this.driver;
    }
}