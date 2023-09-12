package com.techpower.pitchweb.manager;

import com.techpower.pitchweb.model.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public abstract class BaseManager<T> {
    @Autowired
    protected MongoTemplate mongoTemplate;
    protected String collectionName;
    protected Class<T> tClass;
    @Autowired
    private SequenceValueItemManager sequenceValueItemManager;

    public BaseManager(String collectionName, Class<T> tClass) {
        this.collectionName = collectionName;
        this.tClass = tClass;
    }

    public BaseManager(MongoTemplate mongoTemplate, String collectionName, Class<T> tClass) {
        this.mongoTemplate = mongoTemplate;
        this.collectionName = collectionName;
        this.tClass = tClass;
    }

    public T getById(String id) {
        return this.mongoTemplate.findById(id, this.tClass, this.collectionName);
    }

    public Optional<T> getOptionalById(String id) {
        return Optional.ofNullable(this.mongoTemplate.findById(id, this.tClass, this.collectionName));
    }

    public List<T> getByIds(List<String> ids) {
        return this.mongoTemplate.find(Query.query(Criteria.where("_id").in(ids)), this.tClass, this.collectionName);
    }

    public List<T> getByAttribute(String name, Object value) {
        return this.mongoTemplate.find(Query.query(Criteria.where(name).is(value)), this.tClass, this.collectionName);
    }

    public <D> List<T> getByListAttribute(String name, List<D> value) {
        return this.mongoTemplate.find(Query.query(Criteria.where(name).in(value)), this.tClass, this.collectionName);
    }

    public T findOne(Criteria criteria) {
        return this.mongoTemplate.findOne(Query.query(criteria), this.tClass, this.collectionName);
    }

    public List<T> find(Criteria criteria) {
        return this.mongoTemplate.find(Query.query(criteria), this.tClass, this.collectionName);
    }

    public Object create(T object, String updateBy) {
        return this.createObject(object, updateBy, this.collectionName);
    }

    private Object createObject(Object object, String updateBy, String collectionName) {
        Assert.notNull(object, "Object must not null");
        if (object instanceof BaseModel) {
            BaseModel baseModel = (BaseModel) object;
            if (null == baseModel.getId()) {
                baseModel.setId(this.sequenceValueItemManager.getSequence(this.tClass));
            }

            if (null == baseModel.getCreatedStamp()) {
                baseModel.setCreatedStamp(new Date());
            }

            baseModel.setUpdatedBy(updateBy);
            baseModel.setCreatedBy(updateBy);
        }

        Object newObject = this.mongoTemplate.insert(object, collectionName);
//        this.mongoTemplate.insert(UpdateLog.createCreateLog(newObject, updateBy, collectionName));
        return newObject;
    }
}
