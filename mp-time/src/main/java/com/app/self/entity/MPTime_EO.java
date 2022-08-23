package com.app.self.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
@Getter @Builder
@Entity(name = "MPTIME")
public class MPTime_EO {

    @Id
    @Column(name = "mosque_id")
    private Integer mosqueId;

    private String fajr;
    private String dhuhr;
    private String asr;
    private String maghrib;
    private String isha;

    public MPTime_EO() {
    }

    public MPTime_EO(Integer mosqueId, String fajr, String dhuhr, String asr, String maghrib, String isha) {
        this.mosqueId = mosqueId;
        this.fajr = fajr;
        this.dhuhr = dhuhr;
        this.asr = asr;
        this.maghrib = maghrib;
        this.isha = isha;
    }
}
