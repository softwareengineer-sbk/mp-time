package com.app.self.controller;


import com.app.self.dto.MPTime;
import com.app.self.service.MPTimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MPTimeController {

    private final MPTimeService mpTimeService;
    public MPTimeController(MPTimeService mpTimeService) {
        this.mpTimeService = mpTimeService;
    }

    @GetMapping(value = "/getTime/{mosqueId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MPTime> getMPTime(@PathVariable int mosqueId){
        log.info("Method: {}; parameter mosqueId: {}", "getMPTime", mosqueId);
        return mpTimeService.getMPTime(mosqueId);
    }

    @PostMapping(value = "/setTime/{mosqueId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateMPTime(@RequestBody MPTime mpTime,  @PathVariable int mosqueId){
        log.info("Method: {}; request body: {}; parameter mosqueId: {}", "updateMPTime", mpTime, mosqueId);
        return mpTimeService.updateMPTime(mpTime, mosqueId);
    }
}
