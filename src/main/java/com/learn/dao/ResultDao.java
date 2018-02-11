package com.learn.dao;


import com.learn.dao.baseDao.MongodbBaseDao;
import com.learn.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class ResultDao extends MongodbBaseDao<Result> {

	@Override
	protected Class<Result> getEntityClass() {
		return Result.class;
	}

    @Qualifier("mongoTemplate")
    @Override
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		super.mongoTemplate=mongoTemplate;
	}
	
	public Result saveAuditResult (Result result) {
		mongoTemplate.save(result);
		return result;
	}
	
	/**
	 * 通过caseId,orderId查询审核结果
	 * */
	public Result getAuditResult (String caseId, String orderId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("caseId").is(caseId).and("orderId").is(orderId));
		return mongoTemplate.findOne(query, getEntityClass());
	}
	
}
