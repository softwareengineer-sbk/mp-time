package com.app.self.service;

import com.app.self.dto.MPTime;
import org.springframework.http.ResponseEntity;

public interface MPTimeService {
    ResponseEntity getMPTime(int mosqueId);

    ResponseEntity setMPTime(MPTime mpTime, int mosqueId);
}
