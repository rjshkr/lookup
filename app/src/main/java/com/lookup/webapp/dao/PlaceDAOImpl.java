/**
 * @author Rajashekar Dec 6, 2015
 */
package com.lookup.webapp.dao;

import java.util.List;







import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.lookup.webapp.model.Place;

public class PlaceDAOImpl implements PlaceDAO {

	@Autowired
	private SessionFactory sessionFactoryMysql;
	
	@Transactional("mysql")
	public List<Place> getList() {
		Criteria criteria = sessionFactoryMysql.getCurrentSession().createCriteria(Place.class);
		List<Place> list = criteria.list();
		return list;
	}

	@Override
	@Transactional("mysql")
	public Long getCount() {
		Criteria criteria = sessionFactoryMysql.getCurrentSession().createCriteria(Place.class);
		return (Long)criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	public SessionFactory getSessionFactoryMysql() {
		return sessionFactoryMysql;
	}

	public void setSessionFactoryMysql(SessionFactory sessionFactoryMysql) {
		this.sessionFactoryMysql = sessionFactoryMysql;
	}

	@Override
	@Transactional("mysql")
	public List<Place> search(String word) {
		Criteria criteria = sessionFactoryMysql.getCurrentSession().createCriteria(Place.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like("name", word));
		disjunction.add(Restrictions.like("category", word));
		criteria.add(disjunction);
		return criteria.list();
	}

}
