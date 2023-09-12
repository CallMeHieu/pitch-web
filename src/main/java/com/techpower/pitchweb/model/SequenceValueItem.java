package com.techpower.pitchweb.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(
        collection = "sequence_value_item"
)
public class SequenceValueItem extends BaseModel implements Serializable {
    private int seqId;

    public static SequenceValueItemBuilder builder() {
        return new SequenceValueItemBuilder();
    }

    public int getSeqId() {
        return this.seqId;
    }

    public void setSeqId(final int seqId) {
        this.seqId = seqId;
    }

    public SequenceValueItem() {
    }

    public SequenceValueItem(final int seqId) {
        this.seqId = seqId;
    }

    public static class SequenceValueItemBuilder {
        private int seqId;

        SequenceValueItemBuilder() {
        }

        public SequenceValueItemBuilder seqId(final int seqId) {
            this.seqId = seqId;
            return this;
        }

        public SequenceValueItem build() {
            return new SequenceValueItem(this.seqId);
        }

        public String toString() {
            return "SequenceValueItem.SequenceValueItemBuilder(seqId=" + this.seqId + ")";
        }
    }
}
