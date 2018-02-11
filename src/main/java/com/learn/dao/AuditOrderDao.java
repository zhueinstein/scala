package com.learn.dao;

import com.learn.dao.baseDao.MongodbBaseDao;
import com.learn.entity.AuditOrder;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AuditOrderDao extends MongodbBaseDao<AuditOrder> {

	@Override
	protected Class<AuditOrder> getEntityClass() {
		return AuditOrder.class;
	}

	@Autowired
	@Qualifier("mongoTemplate")
	@Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		super.mongoTemplate = mongoTemplate;
	}

	/**
	 * 查询AuditOrder
	 */
	public AuditOrder getAuditOrder(String caseId, String orderId) {
		return mongoTemplate.findById(orderId, getEntityClass());
	}

	public AuditOrder saveAuditOrder(AuditOrder order) {
		mongoTemplate.save(order);
		return order;
	}

	private Collection<?> splitInt(String[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		for (String s : arr) {
			list.add(Integer.parseInt(s));
		}
		return list;
	}
    public void editOrderStatus(String id, String orderId, Integer status, String manualAuditUser){
    	Query query = new Query().addCriteria(Criteria.where("caseId").is(id)).addCriteria(Criteria.where("_id").is(new ObjectId(orderId)));
    	Update update = new Update().set("status", status).set("manualAuditUser", manualAuditUser);
    	mongoTemplate.updateMulti(query, update, getEntityClass());
    }

    public void updateOrderStatus(String caseId, String orderId, Integer status){
		Query query = new Query(Criteria.where("caseId").is(caseId)).addCriteria(Criteria.where("orderId").is(orderId));
        Update update = new Update().set("status", status);
		updateMulti(query,update);
	}

	public AuditOrder getAuditOrderByCaseIdAndOrderNo(String caseId, String orderNo){
		Query query = new Query();
		query.addCriteria(Criteria.where("caseId").is(caseId).and("orderNo").is(orderNo));
		return this.getBean(query);
	}

	public AuditOrder getAuditOrderByCaseIdAndsameDayAuditOrder(String caseId, String orderNo){
		Query query = new Query();
		query.addCriteria(Criteria.where("caseId").is(caseId).and("sameDayAuditOrder.orderNo").is(orderNo));
		return this.getBean(query);
	}
}
