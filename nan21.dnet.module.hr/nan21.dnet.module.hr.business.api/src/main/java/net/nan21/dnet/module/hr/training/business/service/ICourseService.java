/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.training.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.training.domain.entity.Course;
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;

/**
 * Interface to expose business functions specific for {@link Course} domain
 * entity.
 */
public interface ICourseService extends IEntityService<Course> {

	/**
	 * Find by unique key
	 */
	public Course findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Course findByName(String name);

	/**
	 * Find by reference: type
	 */
	public List<Course> findByType(CourseType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Course> findByTypeId(Long typeId);
}
