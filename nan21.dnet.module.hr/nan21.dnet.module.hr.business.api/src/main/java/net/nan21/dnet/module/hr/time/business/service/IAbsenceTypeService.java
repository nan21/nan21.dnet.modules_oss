/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.time.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceCategory;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

/**
 * Interface to expose business functions specific for {@link AbsenceType} domain
 * entity.
 */
public interface IAbsenceTypeService extends IEntityService<AbsenceType> {

	/**
	 * Find by unique key
	 */
	public AbsenceType findByName(String name);

	/**
	 * Find by reference: category
	 */
	public List<AbsenceType> findByCategory(AbsenceCategory category);

	/**
	 * Find by ID of reference: category.id
	 */
	public List<AbsenceType> findByCategoryId(Long categoryId);
}
