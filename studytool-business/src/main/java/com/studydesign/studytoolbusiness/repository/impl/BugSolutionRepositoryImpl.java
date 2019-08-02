package com.studydesign.studytoolbusiness.repository.impl;


import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studydesign.studytoolbusiness.entity.entitis.BugSolution;
import com.studydesign.studytoolbusiness.entity.q.QBugSolution;
import com.studydesign.studytoolbusiness.repository.BugSolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
* BugSolutionDaoImpl
* @author autogen
* @version
* @date 2019-06-20
*/
@Repository
public class BugSolutionRepositoryImpl implements BugSolutionRepository {

	private QBugSolution bugSolutionQ = QBugSolution.bugSolution;

	@PersistenceContext(unitName = "persisteUnit")
	protected EntityManager entityManager;

	@Autowired
	@Qualifier("queryFactory")
	private JPAQueryFactory queryFactory;

	@Override
	public BugSolution get(String id) {
		return queryFactory.selectFrom(bugSolutionQ).where(bugSolutionQ.id.eq(id)).fetchOne();
	}

	@Override
	public List<BugSolution> getListByPredicate(Predicate predicate){
		return queryFactory.selectFrom(bugSolutionQ).where(predicate).fetch();
	};

	@Override
	public void add(BugSolution bugSolution) {
		entityManager.persist(bugSolution);
	}

	@Override
	public void update(BugSolution bugSolution) {
		entityManager.merge(bugSolution);
	}

	@Override
	public long delete(String id){
		return queryFactory.delete(bugSolutionQ).where(bugSolutionQ.id.eq(id)).execute();
	}

	@Override
	public long deleteByCondition(Predicate predicate) {
		return queryFactory.delete(bugSolutionQ).where(predicate).execute();
	}



	public long count(Predicate predicate) {
		return queryFactory.from(bugSolutionQ).where(predicate).fetchCount();
	}
}