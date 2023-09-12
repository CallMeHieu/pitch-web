package com.techpower.pitchweb.model;

import lombok.Data;

@Data
public class Address extends BaseModel {
    private String pitchId;
    private String fullAddress;
    private double lat;
    private double lng;
    private String currentUserId;
}
