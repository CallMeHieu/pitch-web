package com.techpower.pitchweb.bean;

import com.google.maps.errors.ApiException;
import com.techpower.pitchweb.controller.pitch.PitchController;
import com.techpower.pitchweb.enums.PitchStatus;
import com.techpower.pitchweb.enums.TimeValue;
import com.techpower.pitchweb.model.Pitch;
import com.techpower.pitchweb.model.PitchTime;
import com.techpower.pitchweb.request.PitchCreateRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Component
@ManagedBean
@ViewScoped
public class PitchCreateBean extends BaseBean {
    @Autowired
    private PitchController pitchController;
    private final String title = "Thêm mới sân bóng";
    private final TimeValue[] optionTime = TimeValue.values();
    @Getter
    @Setter
    private PitchCreateRequest pitchCreateRequest = new PitchCreateRequest();
    @Getter
    @Setter
    private List<PitchTime> pitchTimes = new ArrayList<>();
    @Getter
    @Setter
    private PitchTime pitchTime = new PitchTime();

    public String getTitle() {
        return title;
    }

    public void addPitchTime() {
        pitchTimes.add(pitchTime);
    }

    public void addPitch() throws IOException, InterruptedException, ApiException {
        pitchTimes.add(new PitchTime(TimeValue.TIME_05_00, TimeValue.TIME_14_00, 100000.0));
        pitchTimes.add(new PitchTime(TimeValue.TIME_14_00, TimeValue.TIME_17_00, 140000.0));
        pitchTimes.add(new PitchTime(TimeValue.TIME_17_00, TimeValue.TIME_00_00, 190000.0));
        pitchTimes.add(new PitchTime(TimeValue.TIME_00_00, TimeValue.TIME_05_00, 90000.0));
        pitchController.createPitch(
                pitchCreateRequest.getName(),
                pitchCreateRequest.getFullAddress(),
                pitchTimes,
                PitchStatus.ACTIVE, "Hiếu");
    }
}
