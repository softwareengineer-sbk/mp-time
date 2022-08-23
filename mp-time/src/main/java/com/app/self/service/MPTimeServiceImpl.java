package com.app.self.service;

import com.app.self.dto.MPTime;
import com.app.self.entity.MPTime_EO;
import com.app.self.exception.MosqueTimeNotFoundException;
import com.app.self.repository.MPTimeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.app.self.exception.MessageConstants.*;

@Slf4j
@Service
public class MPTimeServiceImpl implements MPTimeService {

    private final MPTimeRepository mpTimeRepository;

    public MPTimeServiceImpl(MPTimeRepository mpTimeRepository) {
        this.mpTimeRepository = mpTimeRepository;
    }

    @Override
    public ResponseEntity getMPTime(int mosqueId) {
        log.info("</> Started finding mosque");
        try {
            MPTime_EO mpTime_eo = mpTimeRepository.findByMosqueId(mosqueId)
                    .orElseThrow(() -> new MosqueTimeNotFoundException(MOSQUE_TIME_WITH_THIS_ID_NOT_EXIST));
            log.info("</> Success {}", MOSQUE_FOUND);
            return ResponseEntity.ok().body(mapToMPTime(mpTime_eo));
        } catch (MosqueTimeNotFoundException e) {
            log.info("</> Failure {}", MOSQUE_NOT_FOUND);
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    private MPTime mapToMPTime(MPTime_EO mpTime_eo) {
        return new MPTime(mpTime_eo.getFajr(),
                mpTime_eo.getDhuhr(), mpTime_eo.getAsr(), mpTime_eo.getMaghrib(), mpTime_eo.getIsha());
    }

    @Override
    public ResponseEntity<String> setMPTime(MPTime mpTime, int mosqueId) {
        MPTime_EO mpTime_eo = new MPTime_EO(mosqueId,
                mpTime.getFajr(), mpTime.getDhuhr(), mpTime.getAsr(), mpTime.getMaghrib(), mpTime.getIsha());
        log.info("</> Started setting mosque prayer time");
        try {
            mpTimeRepository.save(mpTime_eo);
            log.info("Success {}", MOSQUE_TIME_SET);
            return ResponseEntity.accepted().body(MOSQUE_TIME_SET);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Failure {}", MOSQUE_TIME_NOT_SET);
            return ResponseEntity.badRequest().body(MOSQUE_TIME_NOT_SET);
        }
    }
}
