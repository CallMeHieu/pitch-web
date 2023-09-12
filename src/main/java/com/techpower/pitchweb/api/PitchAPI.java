package com.techpower.pitchweb.api;

import com.google.maps.android.PackageManager;
import com.google.maps.errors.ApiException;
import com.techpower.pitchweb.controller.pitch.PitchController;
import com.techpower.pitchweb.enums.PitchStatus;
import com.techpower.pitchweb.enums.TimeValue;
import com.techpower.pitchweb.manager.PitchManager;
import com.techpower.pitchweb.model.Pitch;
import com.techpower.pitchweb.model.PitchTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PitchAPI {
    @Autowired
    private PitchController pitchController;

    @PostMapping("/pitch")
    public Pitch createPitch() throws IOException, InterruptedException, ApiException {
        List<PitchTime> pitchTimes = new ArrayList<>();
        pitchTimes.add(new PitchTime(TimeValue.TIME_05_00, TimeValue.TIME_14_00, 100000.0));
        pitchTimes.add(new PitchTime(TimeValue.TIME_14_00, TimeValue.TIME_17_00, 140000.0));
        pitchTimes.add(new PitchTime(TimeValue.TIME_17_00, TimeValue.TIME_00_00, 190000.0));
        pitchTimes.add(new PitchTime(TimeValue.TIME_00_00, TimeValue.TIME_05_00, 90000.0));
        return pitchController.createPitch("Sân bóng đá nông lâm NLU 11as5",
                "35 đường số 4, phường Trường Thọ, thành phố Thủ Đức",
                pitchTimes,
                PitchStatus.DELETED, "Hiếu");
    }
}
