package com.app.self.controller;


import com.app.self.dto.MPTime;
import com.app.self.service.MPTimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.app.self.controller.EndpointConstants.GETTIME_MOSQUEID;
import static com.app.self.controller.EndpointConstants.SETTIME_MOSQUEID;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
public class MPTimeController {

    private final MPTimeService mpTimeService;
    public MPTimeController(MPTimeService mpTimeService) {
        this.mpTimeService = mpTimeService;
    }

    @GetMapping(value = GETTIME_MOSQUEID, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity getMPTime(@PathVariable int mosqueId){
        log.info("</> Request Endpoint: {}", GETTIME_MOSQUEID);
        return mpTimeService.getMPTime(mosqueId);
    }

    @PostMapping(value = SETTIME_MOSQUEID, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity updateMPTime(@RequestBody MPTime mpTime,  @PathVariable int mosqueId){
        log.info("</> Request Endpoint: {}", SETTIME_MOSQUEID);
        return mpTimeService.setMPTime(mpTime, mosqueId);
    }
}
