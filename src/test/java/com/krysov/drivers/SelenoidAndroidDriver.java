package com.krysov.drivers;

import com.krysov.config.SelenoidConfig;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidAndroidDriver implements WebDriverProvider {

    public static SelenoidConfig selenoidConfig = ConfigFactory.create(SelenoidConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("deviceName", "android");
        desiredCapabilities.setCapability("version", selenoidConfig.selenoidAppversion());

        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");

        desiredCapabilities.setCapability("app", selenoidConfig.selenoidappPath());
        try {
            return new AndroidDriver<>(new URL(selenoidConfig.selenoidUrl()), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
