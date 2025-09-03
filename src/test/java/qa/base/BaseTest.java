package qa.base;

import qa.base.web.WebDriverManage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import io.qameta.allure.Allure;

public abstract class BaseTest {

    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println("Starting test: " + testInfo.getDisplayName());
        Allure.step("Test başlatılıyor: " + testInfo.getDisplayName());

        if (isWebTest()) {
            WebDriverManage.setupDriver();
        }
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("Finishing test: " + testInfo.getDisplayName());

        if (isWebTest()) {
            WebDriverManage.quitDriver();
        }

        Allure.step("Test tamamlandı: " + testInfo.getDisplayName());
    }

    protected abstract boolean isWebTest();
}