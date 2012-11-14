/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillCategory;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillType;

/**
 * Interface to expose business functions specific for {@link SkillType} domain
 * entity.
 */
public interface ISkillTypeService extends IEntityService<SkillType> {

	/**
	 * Find by unique key
	 */
	public SkillType findByName(String name);

	/**
	 * Find by reference: category
	 */
	public List<SkillType> findByCategory(SkillCategory category);

	/**
	 * Find by ID of reference: category.id
	 */
	public List<SkillType> findByCategoryId(Long categoryId);
}
