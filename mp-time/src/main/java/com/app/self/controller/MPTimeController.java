package com.app.self.controller;


import com.app.self.dto.MPTime;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MPTimeController {

    @GetMapping(value = "/getTime/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MPTime> getMPTime(@PathVariable int id){
        return ResponseEntity.ok().body(new MPTime("","","","",""));
    }

    @PostMapping(value = "/updateTime/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateMPTime(@PathVariable int id){
        return ResponseEntity.accepted().body("");
    }
}
