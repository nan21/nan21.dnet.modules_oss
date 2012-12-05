/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.training.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.training.business.service.ICourseService;
import net.nan21.dnet.module.hr.training.domain.entity.Course;
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;

/**
 * Repository functionality for {@link Course} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CourseService extends AbstractEntityService<Course>
		implements
			ICourseService {

	public CourseService() {
		super();
	}

	public CourseService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Course> getEntityClass() {
		return Course.class;
	}

	/**
	 * Find by unique key
	 */
	public Course findByCode(String code) {
		return (Course) this.getEntityManager()
				.createNamedQuery(Course.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public Course findByName(String name) {
		return (Course) this.getEntityManager()
				.createNamedQuery(Course.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: type
	 */
	public List<Course> findByType(CourseType type) {
		return this.findByTypeId(type.getId());
	}

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Course> findByTypeId(Long typeId) {
		return (List<Course>) this
				.getEntityManager()
				.createQuery(
						"select e from Course e where e.clientId = :pClientId and e.type.id = :pTypeId",
						Course.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTypeId", typeId).getResultList();
	}
}
