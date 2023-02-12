package com.krysov.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile.properties"
})
public interface SelenoidConfig extends Config {

    @Key("selenoidUrl")
    String selenoidUrl();

    @Key("selenoidAppversion")
    String selenoidAppversion();

    @Key("selenoidAppPath")
    String selenoidappPath();
}
