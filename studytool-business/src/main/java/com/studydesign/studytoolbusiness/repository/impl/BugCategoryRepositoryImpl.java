package com.studydesign.studytoolbusiness.repository.impl;


import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studydesign.studytoolbusiness.entity.entitis.BugCategory;
import com.studydesign.studytoolbusiness.entity.q.QBugCategory;
import com.studydesign.studytoolbusiness.repository.BugCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
* BugCategoryDaoImpl
* @author autogen
* @version
* @date 2019-06-20
*/
@Repository
public class BugCategoryRepositoryImpl implements BugCategoryRepository {

	private QBugCategory bugCategoryQ = QBugCategory.bugCategory;

	@PersistenceContext(unitName = "persisteUnit")
	protected EntityManager entityManager;

	@Autowired
	@Qualifier("queryFactory")
	private JPAQueryFactory queryFactory;




	@Override
	public BugCategory get(String id) {
		return queryFactory.selectFrom(bugCategoryQ).where(bugCategoryQ.id.eq(id)).fetchOne();
	}



	@Override
	public void add(BugCategory bugCategory) {
		entityManager.persist(bugCategory);
	}

	@Override
	public void update(BugCategory bugCategory) {
		entityManager.merge(bugCategory);
	}

	@Override
	public long delete(String id){
		return queryFactory.delete(bugCategoryQ).where(bugCategoryQ.id.eq(id)).execute();
	}

	@Override
	public long deleteByCondition(Predicate predicate) {
		return queryFactory.delete(bugCategoryQ).where(predicate).execute();
	}

	@Override
	public List<BugCategory> getListByPredicate(Predicate predicate){
		return queryFactory.selectFrom(bugCategoryQ).where(predicate).fetch();
	};


	public long count(Predicate predicate) {
		return queryFactory.from(bugCategoryQ).where(predicate).fetchCount();
	}
}