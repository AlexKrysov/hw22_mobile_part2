package com.krysov.tests;

import com.krysov.config.RunConfig;
import com.krysov.helpers.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.MobileBy;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.krysov.helpers.RunHelper.runHelper;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestBase {

    private final RunConfig config = ConfigFactory.create(RunConfig.class, System.getProperties());

    SelenideElement textView = $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")),
            forwardButton = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            getStartedButton = $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")),
            searchContainer = $(MobileBy.id("org.wikipedia.alpha:id/search_container"));

    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = runHelper().getDriverClass().getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        if (config.deviceHost().equals("selenoid")) {
            Attach.addVideo();
        }
        closeWebDriver();
    }
}
