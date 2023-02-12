package com.krysov.config;

import org.aeonbits.owner.Config;

public interface RunConfig extends Config {

    @DefaultValue("local")
    String deviceHost();

}
