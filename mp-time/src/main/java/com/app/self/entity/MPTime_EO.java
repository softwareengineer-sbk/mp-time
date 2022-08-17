package com.app.self.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
@Getter
@Builder
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
}
