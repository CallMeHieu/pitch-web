package com.techpower.pitchweb.manager;

import com.techpower.pitchweb.enums.PitchStatus;
import com.techpower.pitchweb.enums.TimeValue;
import com.techpower.pitchweb.model.Address;
import com.techpower.pitchweb.model.Pitch;
import com.techpower.pitchweb.model.PitchTime;
import org.springframework.stereotype.Repository;

@Repository
public class PitchTimeManager extends BaseManager<PitchTime> {
    public PitchTimeManager() {
        super("pitchTime", PitchTime.class);
    }

    public PitchTime createPitchTime(String pitchId, TimeValue startTime, TimeValue endTime, double price, String currentUserId) {
        PitchTime pitchTime = new PitchTime();
        pitchTime.setPitchId(pitchId);
        pitchTime.setStartTime(startTime);
        pitchTime.setEndTime(endTime);
        pitchTime.setPrice(price);
        create(pitchTime, currentUserId);
        return pitchTime;
    }
}
