package com.nordbank.ngwebap.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value={"web.properties"})
public class GlobalConfig {

    @Value("${ap.server.host}")
    public String APServerHost;
}
