/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.skill.business.service.ISkillCategoryService;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillCategory;


public class SkillCategoryService extends AbstractEntityService<SkillCategory>
		implements ISkillCategoryService {
 
	public SkillCategoryService() {
		super();
	}

	public SkillCategoryService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<SkillCategory> getEntityClass() {
		return SkillCategory.class;
	}
	
	public SkillCategory findByName(String name) {		 
		return (SkillCategory) this.em
			.createNamedQuery(SkillCategory.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
}
