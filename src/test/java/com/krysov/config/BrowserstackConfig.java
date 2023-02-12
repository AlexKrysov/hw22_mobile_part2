package com.krysov.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:mobile.properties"})
public interface BrowserstackConfig extends Config {
    @Key("browserstackUser")
    String user();

    @Key("browserstackKey")
    String key();

    @Key("browserstackUrl")
    String url();

    @Key("browserstackRemoteUrl")
    String remoteUrl();

    @Key("browserstackApp")
    String app();
}
