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
import net.nan21.dnet.module.hr.training.business.service.ICourseTypeService;
import net.nan21.dnet.module.hr.training.domain.entity.CourseCategory;
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;

/**
 * Repository functionality for {@link CourseType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CourseTypeService extends AbstractEntityService<CourseType>
		implements
			ICourseTypeService {

	public CourseTypeService() {
		super();
	}

	public CourseTypeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<CourseType> getEntityClass() {
		return CourseType.class;
	}

	/**
	 * Find by unique key
	 */
	public CourseType findByName(String name) {
		return (CourseType) this.em
				.createNamedQuery(CourseType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: category
	 */
	public List<CourseType> findByCategory(CourseCategory category) {
		return this.findByCategoryId(category.getId());
	}

	/**
	 * Find by ID of reference: category.id
	 */
	public List<CourseType> findByCategoryId(Long categoryId) {
		return (List<CourseType>) this.em
				.createQuery(
						"select e from CourseType e where e.clientId = :pClientId and e.category.id = :pCategoryId",
						CourseType.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCategoryId", categoryId).getResultList();
	}
}
