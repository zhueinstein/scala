package com.learn.dao.baseDao;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * 基础查询类
 *
 * Query 中封装查询条件和排序规则
 */
public abstract class MongodbBaseDao<T> {

    /**
     * spring mongodb　集成操作类　
     */
    protected MongoTemplate mongoTemplate;

    /**
     * 获取需要操作的实体类class
     */
    protected abstract Class<T> getEntityClass();

    /**
     * 注入mongodbTemplate
     */
    protected abstract void setMongoTemplate(MongoTemplate mongoTemplate);

    public void updateMulti(Query query, Update update) {
        mongoTemplate.updateMulti(query, update, this.getEntityClass());
    }

    /** 根据指定条件删除数据*/
    public void removeAllByQuery(Query query){
        this.mongoTemplate.remove(query,getEntityClass());
    }

    /** 根据删除一个实体*/
    public void removeById(String id){
        this.mongoTemplate.remove(new Query(Criteria.where("_id").is(id)),getEntityClass());
    }

    /** 根据query 计算总量*/
    public long countBeanByQuery(Query query){
        return mongoTemplate.count(query,getEntityClass());
    }

    /**
     * 按条件查询
     * @param query 查询条件，相当于 mysql where条件
     * @param orders 排序 ，相当于 mysql order 条件
     * @param skip 跳过 ，相当于 mysql limit m,n 中的 m
     * @param limit 取数据， 相当于 mysql limit m,n 中的 n
     * @return
     */
    public List<T> listBean(Query query, List<Sort.Order> orders, Integer skip, Integer limit){
        if(null!=orders && orders.size()>0){
            query.with(new Sort(orders));
        }
        if(limit != null){
            query.limit(limit);
        }

        if(skip != null){
            query.skip(skip);
        }

        return mongoTemplate.find(query,getEntityClass());
    }

    /** 查询单个实体 */
    public T getBean(Query query){
        return mongoTemplate.findOne(query, getEntityClass());
    }
}
