package com.krysov.helpers;

import com.krysov.config.RunConfig;
import com.krysov.drivers.BrowserstackMobileDriver;
import com.krysov.drivers.LocalAndroidDriver;
import com.krysov.drivers.RealMobileDriver;
import com.krysov.drivers.SelenoidAndroidDriver;
import org.aeonbits.owner.ConfigFactory;

public class RunHelper {

    private final RunConfig config = ConfigFactory.create(RunConfig.class, System.getProperties());

    private RunHelper() {
    }

    public static RunHelper runHelper() {
        return new RunHelper();
    }

    public Class<?> getDriverClass() {
        switch (config.deviceHost()) {
            case "browserstack":
                return BrowserstackMobileDriver.class;
            case "local":
                return LocalAndroidDriver.class;
            case "real":
                return RealMobileDriver.class;
            case "selenoid":
                return SelenoidAndroidDriver.class;
            case "null":
                throw new NullPointerException("Device host is null");
            default:
                throw new RuntimeException("Incorrect device host");
        }
    }
}
