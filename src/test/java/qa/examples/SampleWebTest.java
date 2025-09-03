package qa.examples;

import qa.base.WebBaseTest;
import qa.base.web.WebDriverManage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import static org.assertj.core.api.Assertions.assertThat;

public class SampleWebTest extends WebBaseTest {

    @Test
    @DisplayName("Google Ana Sayfa Testi")
    @Description("Google ana sayfasının açıldığını doğrular")
    @Severity(SeverityLevel.BLOCKER)
    void googleHomePageTest() {
        WebDriverManage.getDriver().get("https://www.google.com");
        String title = WebDriverManage.getDriver().getTitle();
        assertThat(title).contains("Google");
    }
}