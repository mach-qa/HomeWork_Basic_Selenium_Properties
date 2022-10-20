import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class Example {
    WebDriver driver;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Check Title Sii")
    @Tag("regression")
    @Tag("SII")
    void checkTitle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sii.pl");

        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Rozwiązania i usługi IT, inżynierii i BPO - Sii Polska";
        driver.quit();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @Test
    @DisplayName("Check Title Sii")
    @Tag("regression")
    @Tag("SII")
    void checkBookingTitle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com");

        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Booking.com";
        driver.quit();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}
