package com.techpower.pitchweb.model;

import com.techpower.pitchweb.enums.PitchStatus;
import lombok.Data;

import java.util.List;

@Data
public class Pitch extends BaseModel {
    private String name;
    private Address address;
    private List<PitchTime> pitchTime;
    private String numberPhone;
    private PitchStatus status;
}
