package com.learn.dao;

import com.learn.dao.baseDao.MongodbBaseDao;
import com.learn.entity.AuditCase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.HashMap;
import java.util.Map;

public class AuditCaseDao extends MongodbBaseDao<AuditCase> {
	
    @Override
    protected Class<AuditCase> getEntityClass() {
        return AuditCase.class;
    }

    @Qualifier("mongoTemplate")
    @Override
    protected void setMongoTemplate(MongoTemplate mongoTemplate) {
        super.mongoTemplate=mongoTemplate;
    }
    
    
    /**
     *保存AuditCase; 
     */
    public AuditCase saveAuditCase(AuditCase auditCase) {
    	mongoTemplate.save(auditCase);
    	return auditCase;
    }
    
    /**
     *通过caseId 查询AuditCase; 
     * 
     */
    
    public AuditCase getAuditCase(String caseId) {
    	return mongoTemplate.findById(caseId, getEntityClass());
    }
    
    /**
     * 
     * @param caseId
     * @param manuallyReviewNum 待人工审核数量增加量
     * @param completionNum 完成数量增加量
     */
    public void updateCase(String caseId,Integer manuallyReviewNum ,Integer completionNum) {
    		Update update = new Update();
    		if(manuallyReviewNum!=null) {
    			update.inc("manuallyReviewNum", manuallyReviewNum); 
    		}
    		if(completionNum!=null) {
    			update.inc("completionNum", completionNum); 
    		}
    	 	Query query = new Query();
    	 	query.addCriteria(Criteria.where("caseId").is(caseId));
    	 	mongoTemplate.updateFirst(query, update, AuditCase.class);
    }
    /**
     * 分页查询AuditCase 
     * 
     * */
    public Map<String, Object> getAuditCases(Integer skip, Integer limit, Integer count) {
    	Map<String,Object> re = new HashMap<String,Object>();
    	Query query = new Query();
    	if(count != null && count == 1){
    		re.put("count",mongoTemplate.count(query, getEntityClass()));
    		return re;
    	}
    	if(limit != null)
    		query.limit(limit);
    	if(skip != null)
    		query.skip(skip);
    	query.with(new Sort(Direction.DESC,"createDate"));
    	re.put("list", mongoTemplate.find(query, getEntityClass()));
    	return re;
    }
    
}
