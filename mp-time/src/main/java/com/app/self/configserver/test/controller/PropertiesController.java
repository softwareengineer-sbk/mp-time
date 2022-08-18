package com.app.self.configserver.test.controller;

import com.app.self.configserver.test.configuration.ServerConfiguration;
import com.app.self.configserver.test.dto.Properties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;

@RestController
public class PropertiesController {

    private final ServerConfiguration serverConfiguration;

    public PropertiesController(ServerConfiguration serverConfiguration) {
        this.serverConfiguration = serverConfiguration;
    }

    @GetMapping(value = "/properties", produces = MediaType.APPLICATION_JSON)
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(serverConfiguration.getMsg());
        return ow.writeValueAsString(properties);
    }
}
