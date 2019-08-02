package com.studydesign.studytoolbusiness.repository.impl;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.studydesign.studytoolbusiness.entity.entitis.UserInfo;
import com.studydesign.studytoolbusiness.entity.q.QUserInfo;
import com.studydesign.studytoolbusiness.repository.UserInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
* UserInfoDaoImpl
* @author autogen
* @version
* @date 2019-06-20
*/
@Repository
public class UserInfoRepositoryImpl implements UserInfoRepository {

	private QUserInfo userInfoQ = QUserInfo.userInfo;

	@PersistenceContext(unitName = "persisteUnit")
	protected EntityManager entityManager;

	@Autowired
	@Qualifier("queryFactory")
	private JPAQueryFactory queryFactory;

	@Override
	public UserInfo get(String id) {
		return queryFactory.selectFrom(userInfoQ).where(userInfoQ.id.eq(id)).fetchOne();
	}



	@Override
	public int add(UserInfo userInfo) {
		entityManager.persist(userInfo);
		return 1;
	}

	@Override
	public int update(UserInfo userInfo) {
		entityManager.merge(userInfo);
        return 1;
	}

	@Override
	public long delete(String id){
		return queryFactory.delete(userInfoQ).where(userInfoQ.id.eq(id)).execute();
	}

	@Override
	public long deleteByCondition(Predicate predicate) {
		return queryFactory.delete(userInfoQ).where(predicate).execute();
	}

	@Override
	public List<UserInfo> getListByPredicate(Predicate predicate){
		return queryFactory.selectFrom(userInfoQ).where(predicate).fetch();
	};


	public long count(Predicate predicate) {
		return queryFactory.from(userInfoQ).where(predicate).fetchCount();
	}
}