package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSetup {
    private static final Logger logger = LoggerFactory.getLogger(TestSetup.class);

    WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }

    @BeforeAll
    static void setupDriver(){
        WebDriverManager.chromedriver().setup();
        logger.info("Webdriver started succssfully");
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("Browser has been opened");
    }

    @AfterEach
    void exit() {
        driver.quit();
        logger.info("Webdriver closed properly");
    }
}
