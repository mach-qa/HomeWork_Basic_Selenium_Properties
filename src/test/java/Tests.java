import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import setup.TestSetup;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests extends TestSetup {

    private static final Logger logger = LoggerFactory.getLogger(Tests.class);

    @ParameterizedTest (name = "{2} has been verified")
    @CsvFileSource(resources = "/page_database.csv")
    @Tag("Regression")
    @DisplayName("Website Titles Verification on ")
    void websiteTitleTest(String websiteAddress, String expectedTitle, String websiteTitle) {
        getDriver().get(websiteAddress);
        logger.info("My Website Adress is " + websiteAddress);
        logger.debug("My Website Adress is " + websiteAddress);
        logger.warn("My Website Adress is " + websiteAddress);
        logger.error("My Website Adress is " + websiteAddress);
        logger.trace("My Website Adress is " + websiteAddress);

        assertThat(getDriver().getTitle()).isEqualTo(expectedTitle);
    }
}