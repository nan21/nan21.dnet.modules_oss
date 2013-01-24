/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillCategory;

/**
 * Interface to expose business functions specific for {@link SkillCategory} domain
 * entity.
 */
public interface ISkillCategoryService extends IEntityService<SkillCategory> {

	/**
	 * Find by unique key
	 */
	public SkillCategory findByName(String name);
}
