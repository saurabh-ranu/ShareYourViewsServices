package com.omnie.shareyourviewservice.hibermapping;

// Generated Sep 1, 2015 2:49:52 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Userrole.
 * @see com.omnie.shareyourviewservice.hibermapping.Userrole
 * @author Hibernate Tools
 */
@Stateless
public class UserroleHome {

	private static final Log log = LogFactory.getLog(UserroleHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Userrole transientInstance) {
		log.debug("persisting Userrole instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Userrole persistentInstance) {
		log.debug("removing Userrole instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Userrole merge(Userrole detachedInstance) {
		log.debug("merging Userrole instance");
		try {
			Userrole result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Userrole findById(Long id) {
		log.debug("getting Userrole instance with id: " + id);
		try {
			Userrole instance = entityManager.find(Userrole.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
