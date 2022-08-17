package com.app.self.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MPTime {

    private String fajr;
    private String dhuhr;
    private String asr;
    private String maghrib;
    private String isha;
}
