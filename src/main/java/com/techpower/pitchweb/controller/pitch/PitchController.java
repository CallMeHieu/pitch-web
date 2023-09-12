package com.techpower.pitchweb.controller.pitch;

import com.google.maps.errors.ApiException;
import com.techpower.pitchweb.enums.PitchStatus;
import com.techpower.pitchweb.enums.TimeValue;
import com.techpower.pitchweb.exception.PitchException;
import com.techpower.pitchweb.manager.AddressManager;
import com.techpower.pitchweb.manager.PitchManager;
import com.techpower.pitchweb.manager.PitchTimeManager;
import com.techpower.pitchweb.model.Address;
import com.techpower.pitchweb.model.Pitch;
import com.techpower.pitchweb.model.PitchTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.print.PrintException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PitchController {
    @Autowired
    private PitchManager pitchManager;
    @Autowired
    private AddressManager addressManager;
    @Autowired
    private PitchTimeManager pitchTimeManager;

    public List<Pitch> findAllPitch() {
        return pitchManager.getAllPitch();
    }
    public Pitch createPitch(String name,
                             String fullAddress,
                             List<PitchTime> pitchTimes,
                             PitchStatus status,
                             String currentUserId) throws IOException, InterruptedException, ApiException {
        if (!validatePitchTimes(pitchTimes)) return null;
        Pitch pitchData = pitchManager.getPitchByName(name);
        if (null != pitchData) {
            throw new PitchException("pitch_exited", "Đã tồn tại sân bóng tên: " + name);
        }
        Pitch newPitch = pitchManager.createPitch(name, fullAddress, status, currentUserId);
//        Address address = addAddress(newPitch, currentUserId);
//        newPitch.setAddress(address);
        newPitch.setPitchTime(addPitchTimes(pitchTimes, newPitch.getId(), currentUserId));
        return newPitch;
    }

    private Address addAddress(Pitch pitch, String currentUserId) throws IOException, InterruptedException, ApiException {
        return addressManager.createAddress(pitch.getAddress().getFullAddress(), currentUserId, pitch.getId());
    }

    private List<PitchTime> addPitchTimes(List<PitchTime> pitchTimes, String pitchId, String currentUserId) {
        List<PitchTime> result = new ArrayList<>();
        for (PitchTime pitchTime : pitchTimes) {
            result.add(pitchTimeManager.createPitchTime(pitchId, pitchTime.getStartTime(), pitchTime.getEndTime(), pitchTime.getPrice(), currentUserId));
        }
        return result;
    }

    private boolean validatePitchTimes(List<PitchTime> pitchTimes) {
        Set<TimeValue> startTimes = new HashSet<>();
        Set<TimeValue> endTimes = new HashSet<>();

        for (PitchTime pitchTime : pitchTimes) {
            if (pitchTime.getStartTime().equals(pitchTime.getEndTime())) return false;
            startTimes.add(pitchTime.getStartTime());
            endTimes.add(pitchTime.getEndTime());
        }

        return endTimes.containsAll(startTimes);
    }
}
