package com.krysov.drivers;

import com.krysov.config.BrowserstackConfig;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);

    public static URL getBrowserstackUrl() {
        try {
            return new URL(browserstackConfig.remoteUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("browserstack.user", browserstackConfig.user());
        desiredCapabilities.setCapability("browserstack.key", browserstackConfig.key());
        desiredCapabilities.setCapability("app", browserstackConfig.app());
        desiredCapabilities.setCapability("app", browserstackConfig.url());
        desiredCapabilities.setCapability("device", "Google Pixel 3");
        desiredCapabilities.setCapability("os_version", "9.0");
        desiredCapabilities.setCapability("project", "Qa guru final project mobile");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "wiki_tests");
        try {
            return new AndroidDriver<>(new URL("http://hub-cloud.browserstack.com/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
