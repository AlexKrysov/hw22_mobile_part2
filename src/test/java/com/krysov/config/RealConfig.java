package com.krysov.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile.properties"
})
public interface RealConfig extends Config {

    @Key("deviceName")
    String deviceName();

    @Key("androidVersion")
    String androidVersion();

    @Key("realAppPath")
    String appPath();


}
