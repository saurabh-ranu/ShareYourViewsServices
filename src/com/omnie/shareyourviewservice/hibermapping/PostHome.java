package com.omnie.shareyourviewservice.hibermapping;

// Generated Sep 1, 2015 2:49:52 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Post.
 * @see com.omnie.shareyourviewservice.hibermapping.Post
 * @author Hibernate Tools
 */
@Stateless
public class PostHome {

	private static final Log log = LogFactory.getLog(PostHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Post transientInstance) {
		log.debug("persisting Post instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Post persistentInstance) {
		log.debug("removing Post instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Post merge(Post detachedInstance) {
		log.debug("merging Post instance");
		try {
			Post result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Post findById(Long id) {
		log.debug("getting Post instance with id: " + id);
		try {
			Post instance = entityManager.find(Post.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
