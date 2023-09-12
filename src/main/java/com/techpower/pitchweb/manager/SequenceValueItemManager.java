package com.techpower.pitchweb.manager;

import com.techpower.pitchweb.model.SequenceValueItem;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SequenceValueItemManager {
    private final MongoTemplate mongoTemplate;

    public String getSequence(Class forClass) {
        String sequenceName = forClass.getName();
        SequenceValueItem sequenceValueItem = (SequenceValueItem) this.mongoTemplate.findById(sequenceName, SequenceValueItem.class);
        if (null == sequenceValueItem) {
            sequenceValueItem = new SequenceValueItem();
            sequenceValueItem.setId(sequenceName);
            sequenceValueItem.setSeqId(1000);
            sequenceValueItem.setCreatedStamp(new Date());
            this.mongoTemplate.save(sequenceValueItem);
            return "1000";
        } else {
            int sequenceId = sequenceValueItem.getSeqId() + 1;
            sequenceValueItem.setSeqId(sequenceId);
            sequenceValueItem.setUpdatedStamp(new Date());
            this.mongoTemplate.save(sequenceValueItem);
            return String.valueOf(sequenceId);
        }
    }

    public SequenceValueItemManager(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}

