import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import setup.TestSetup;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests extends TestSetup {

    @ParameterizedTest (name = "{2} has been verified")
    @CsvFileSource(resources = "/page_database.csv")
    @Tag("Regression")
    @DisplayName("Website Titles Verification on ")
    void websiteTitleTest(String websiteAddress, String expectedTitle, String websiteTitle) {
        getDriver().get(websiteAddress);
        assertThat(getDriver().getTitle()).isEqualTo(expectedTitle);
    }
}