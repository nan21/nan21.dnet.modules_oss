/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.time.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.time.business.service.IAbsenceTypeService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceCategory;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

/**
 * Repository functionality for {@link AbsenceType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AbsenceTypeService extends AbstractEntityService<AbsenceType>
		implements
			IAbsenceTypeService {

	public AbsenceTypeService() {
		super();
	}

	public AbsenceTypeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<AbsenceType> getEntityClass() {
		return AbsenceType.class;
	}

	/**
	 * Find by unique key
	 */
	public AbsenceType findByName(String name) {
		return (AbsenceType) this.em
				.createNamedQuery(AbsenceType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: category
	 */
	public List<AbsenceType> findByCategory(AbsenceCategory category) {
		return this.findByCategoryId(category.getId());
	}

	/**
	 * Find by ID of reference: category.id
	 */
	public List<AbsenceType> findByCategoryId(Long categoryId) {
		return (List<AbsenceType>) this.em
				.createQuery(
						"select e from AbsenceType e where e.clientId = :pClientId and e.category.id = :pCategoryId",
						AbsenceType.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCategoryId", categoryId).getResultList();
	}
}
