/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.training.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.training.domain.entity.CourseCategory;
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;

/**
 * Interface to expose business functions specific for {@link CourseType} domain
 * entity.
 */
public interface ICourseTypeService extends IEntityService<CourseType> {

	/**
	 * Find by unique key
	 */
	public CourseType findByName(String name);

	/**
	 * Find by reference: category
	 */
	public List<CourseType> findByCategory(CourseCategory category);

	/**
	 * Find by ID of reference: category.id
	 */
	public List<CourseType> findByCategoryId(Long categoryId);
}
