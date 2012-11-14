/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.skill.business.service.ISkillTypeService;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillCategory;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillType;

/**
 * Repository functionality for {@link SkillType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SkillTypeService extends AbstractEntityService<SkillType>
		implements
			ISkillTypeService {

	public SkillTypeService() {
		super();
	}

	public SkillTypeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<SkillType> getEntityClass() {
		return SkillType.class;
	}

	/**
	 * Find by unique key
	 */
	public SkillType findByName(String name) {
		return (SkillType) this.em.createNamedQuery(SkillType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: category
	 */
	public List<SkillType> findByCategory(SkillCategory category) {
		return this.findByCategoryId(category.getId());
	}

	/**
	 * Find by ID of reference: category.id
	 */
	public List<SkillType> findByCategoryId(Long categoryId) {
		return (List<SkillType>) this.em
				.createQuery(
						"select e from SkillType e where e.clientId = :pClientId and e.category.id = :pCategoryId",
						SkillType.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCategoryId", categoryId).getResultList();
	}
}
