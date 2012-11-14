/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.training.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.training.business.service.ICourseCategoryService;
import net.nan21.dnet.module.hr.training.domain.entity.CourseCategory;

/**
 * Repository functionality for {@link CourseCategory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CourseCategoryService
		extends
			AbstractEntityService<CourseCategory>
		implements
			ICourseCategoryService {

	public CourseCategoryService() {
		super();
	}

	public CourseCategoryService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<CourseCategory> getEntityClass() {
		return CourseCategory.class;
	}

	/**
	 * Find by unique key
	 */
	public CourseCategory findByName(String name) {
		return (CourseCategory) this.em
				.createNamedQuery(CourseCategory.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
