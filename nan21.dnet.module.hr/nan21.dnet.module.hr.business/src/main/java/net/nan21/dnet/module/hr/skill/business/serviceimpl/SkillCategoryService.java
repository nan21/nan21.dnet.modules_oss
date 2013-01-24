/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.skill.business.service.ISkillCategoryService;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillCategory;

/**
 * Repository functionality for {@link SkillCategory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SkillCategoryService extends AbstractEntityService<SkillCategory>
		implements
			ISkillCategoryService {

	public SkillCategoryService() {
		super();
	}

	public SkillCategoryService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SkillCategory> getEntityClass() {
		return SkillCategory.class;
	}

	/**
	 * Find by unique key
	 */
	public SkillCategory findByName(String name) {
		return (SkillCategory) this.getEntityManager()
				.createNamedQuery(SkillCategory.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
