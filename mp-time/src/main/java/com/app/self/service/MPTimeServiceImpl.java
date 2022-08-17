package com.app.self.service;

import com.app.self.dto.MPTime;
import com.app.self.entity.MPTime_EO;
import com.app.self.repository.MPTimeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.app.self.utils.ResponseMessageConstants.PRAYER_TIME_NOT_UPDATED;
import static com.app.self.utils.ResponseMessageConstants.PRAYER_TIME_UPDATED;

@Slf4j
@Service
public class MPTimeServiceImpl implements MPTimeService{

    private final MPTimeRepository mpTimeRepository;
    public MPTimeServiceImpl(MPTimeRepository mpTimeRepository) {
        this.mpTimeRepository = mpTimeRepository;
    }

    @Override
    public ResponseEntity<MPTime> getMPTime(int mosqueId) {
        log.info("Method: {}; parameter mosqueId: {}", "getMPTime", mosqueId);
        Optional<MPTime_EO> mpTime_eo = mpTimeRepository.findByMosqueId(mosqueId);
        log.info("Successfully got object from database!!!");
        MPTime mpTime = null;
        if (mpTime_eo.isPresent()){
            mpTime = MPTime.builder()
                    .fajr(mpTime_eo.get().getFajr())
                    .dhuhr(mpTime_eo.get().getDhuhr())
                    .asr(mpTime_eo.get().getAsr())
                    .maghrib(mpTime_eo.get().getMaghrib())
                    .isha(mpTime_eo.get().getIsha())
                    .build();
        }
        return ResponseEntity.ok().body(mpTime);
    }

    @Override
    public ResponseEntity<String> updateMPTime(MPTime mpTime, int mosqueId) {
        MPTime_EO mpTime_eo = MPTime_EO.builder()
                .mosqueId(mosqueId)
                .fajr(mpTime.getFajr())
                .dhuhr(mpTime.getDhuhr())
                .asr(mpTime.getAsr())
                .maghrib(mpTime.getMaghrib())
                .isha(mpTime.getIsha())
                .build();
        try {
            mpTimeRepository.save(mpTime_eo);
            return ResponseEntity.accepted().body(PRAYER_TIME_UPDATED);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(PRAYER_TIME_NOT_UPDATED);
        }
    }
}
