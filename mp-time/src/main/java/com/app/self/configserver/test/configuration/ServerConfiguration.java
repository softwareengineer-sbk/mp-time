package com.app.self.configserver.test.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
@Getter @ToString
@ConfigurationProperties(prefix = "mp-time")
public class ServerConfiguration {

    private String msg;

}
