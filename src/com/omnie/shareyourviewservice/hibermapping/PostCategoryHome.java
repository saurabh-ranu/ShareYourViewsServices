package com.omnie.shareyourviewservice.hibermapping;

// Generated Sep 1, 2015 2:49:52 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class PostCategory.
 * @see com.omnie.shareyourviewservice.hibermapping.PostCategory
 * @author Hibernate Tools
 */
@Stateless
public class PostCategoryHome {

	private static final Log log = LogFactory.getLog(PostCategoryHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(PostCategory transientInstance) {
		log.debug("persisting PostCategory instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(PostCategory persistentInstance) {
		log.debug("removing PostCategory instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public PostCategory merge(PostCategory detachedInstance) {
		log.debug("merging PostCategory instance");
		try {
			PostCategory result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PostCategory findById(Long id) {
		log.debug("getting PostCategory instance with id: " + id);
		try {
			PostCategory instance = entityManager.find(PostCategory.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
