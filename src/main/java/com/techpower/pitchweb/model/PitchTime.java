package com.techpower.pitchweb.model;

import com.techpower.pitchweb.enums.TimeValue;
import lombok.Data;

@Data
public class PitchTime extends BaseModel {
    private String pitchId;
    private TimeValue startTime;
    private TimeValue endTime;
    private double price;

    public PitchTime(TimeValue startTime, TimeValue endTime, double price) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public PitchTime() {
    }
}
