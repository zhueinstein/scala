package com.learn.dao;


import com.learn.dao.baseDao.MongodbBaseDao;
import com.learn.entity.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DrugInfoDao extends MongodbBaseDao<Drug> {

	@Override
	protected Class<Drug> getEntityClass() {
		return Drug.class;
	}

	@Override
	@Autowired
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		super.mongoTemplate = mongoTemplate;
	}
	
	public Drug getDrugByCode(String code){
		return mongoTemplate.findOne(new Query(Criteria.where("drugCode").is(code)), getEntityClass());
	}
	
	public List<Drug> getDrugsByCode(List<String> codes){
		return mongoTemplate.find(new Query(Criteria.where("drugCode").in(codes)), getEntityClass());
	}

	public  List<Drug> getDrugs(){
		return mongoTemplate.findAll(getEntityClass());
	}

	public List<Drug> getDrugsByCommonName(String commonName) {
		return mongoTemplate.find(new Query(Criteria.where("commonName").is(commonName)), getEntityClass());
	}
}
