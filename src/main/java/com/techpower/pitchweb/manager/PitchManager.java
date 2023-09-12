package com.techpower.pitchweb.manager;

import com.techpower.pitchweb.enums.PitchStatus;
import com.techpower.pitchweb.model.Address;
import com.techpower.pitchweb.model.Pitch;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PitchManager extends BaseManager<Pitch> {
    public PitchManager() {
        super("pitch", Pitch.class);
    }

    public List<Pitch> getAllPitch() {
        Criteria query = Criteria
                .where("status").ne(PitchStatus.DELETED.toString());
        return find(query);
    }

    public Pitch getPitchByName(String name) {
        Criteria query = Criteria
                .where("name").is(name);
        return findOne(query);
    }

    public Pitch createPitch(String name, String fullAddress, PitchStatus status, String currentUserId) {
        Pitch pitch = new Pitch();
        pitch.setName(name);
        pitch.setAddress(new Address());
        pitch.getAddress().setFullAddress(fullAddress);
        pitch.setStatus(status);
        create(pitch, currentUserId);
        return pitch;
    }
}
