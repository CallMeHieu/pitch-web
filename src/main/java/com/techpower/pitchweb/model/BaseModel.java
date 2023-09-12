package com.techpower.pitchweb.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public abstract class BaseModel {
    @Id
    private String id;
    private Date createdStamp;
    private Date updatedStamp;
    private String updatedBy;
    private String createdBy;

    public BaseModel() {
    }

    public String getId() {
        return this.id;
    }

    public Date getCreatedStamp() {
        return this.createdStamp;
    }

    public Date getUpdatedStamp() {
        return this.updatedStamp;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setCreatedStamp(final Date createdStamp) {
        this.createdStamp = createdStamp;
    }

    public void setUpdatedStamp(final Date updatedStamp) {
        this.updatedStamp = updatedStamp;
    }

    public void setUpdatedBy(final String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }
}
