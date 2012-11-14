/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.training.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.training.domain.entity.CourseCategory;

/**
 * Interface to expose business functions specific for {@link CourseCategory} domain
 * entity.
 */
public interface ICourseCategoryService extends IEntityService<CourseCategory> {

	/**
	 * Find by unique key
	 */
	public CourseCategory findByName(String name);
}
