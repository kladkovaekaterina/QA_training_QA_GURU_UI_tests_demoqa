package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.BrowserLocalConfig;
import config.BrowserRemoteConfig;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

        BrowserRemoteConfig configRemote = ConfigFactory.create(BrowserRemoteConfig.class, System.getProperties());
        BrowserLocalConfig configLocal = ConfigFactory.create(BrowserLocalConfig.class, System.getProperties());

        if ("remote".equals(System.getProperty("driver"))) {
            Configuration.browser = configRemote.getBrowserName();
            Configuration.browserVersion = configRemote.getBrowserVersion();
            Configuration.remote = configRemote.getRemoteDriver();
            System.out.println("Remote launch");
        } else {
            Configuration.browser = configLocal.getBrowserName();
            Configuration.browserVersion = configLocal.getBrowserVersion();
            System.out.println("Local launch");
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();

        closeWebDriver();
    }

}