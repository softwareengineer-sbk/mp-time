package com.app.self.service;

import com.app.self.dto.MPTime;
import org.springframework.http.ResponseEntity;

public interface MPTimeService {
    ResponseEntity<MPTime> getMPTime(int mosqueId);

    ResponseEntity<String> updateMPTime(MPTime mpTime, int mosqueId);
}
