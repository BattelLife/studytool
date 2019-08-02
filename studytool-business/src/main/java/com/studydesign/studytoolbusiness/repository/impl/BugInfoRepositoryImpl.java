package com.studydesign.studytoolbusiness.repository.impl;


import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studydesign.studytoolbusiness.entity.entitis.BugInfo;
import com.studydesign.studytoolbusiness.entity.q.QBugInfo;
import com.studydesign.studytoolbusiness.repository.BugInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
* BugInfoDaoImpl
* @author autogen
* @version
* @date 2019-06-20
*/
@Repository
public class BugInfoRepositoryImpl implements BugInfoRepository {

	private QBugInfo bugInfoQ = QBugInfo.bugInfo;

	@PersistenceContext(unitName = "persisteUnit")
	protected EntityManager entityManager;

	@Autowired
	@Qualifier("queryFactory")
	private JPAQueryFactory queryFactory;

	@Override
	public BugInfo get(String id) {
		return queryFactory.selectFrom(bugInfoQ).where(bugInfoQ.id.eq(id)).fetchOne();
	}


	@Override
	public void add(BugInfo bugInfo) {
		entityManager.persist(bugInfo);
	}

	@Override
	public void update(BugInfo bugInfo) {
		entityManager.merge(bugInfo);
	}

	@Override
	public long delete(String id){
		return queryFactory.delete(bugInfoQ).where(bugInfoQ.id.eq(id)).execute();
	}

	@Override
	public long deleteByCondition(Predicate predicate) {
		return queryFactory.delete(bugInfoQ).where(predicate).execute();
	}

	@Override
	public List<BugInfo> getListByPredicate(Predicate predicate){
		return queryFactory.selectFrom(bugInfoQ).where(predicate).fetch();
	};


	public long count(Predicate predicate) {
		return queryFactory.from(bugInfoQ).where(predicate).fetchCount();
	}
}