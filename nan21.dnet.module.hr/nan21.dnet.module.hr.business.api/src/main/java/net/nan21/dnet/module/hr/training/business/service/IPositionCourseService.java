/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.training.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.training.domain.entity.Course;
import net.nan21.dnet.module.hr.training.domain.entity.PositionCourse;

/**
 * Interface to expose business functions specific for {@link PositionCourse} domain
 * entity.
 */
public interface IPositionCourseService extends IEntityService<PositionCourse> {

	/**
	 * Find by reference: position
	 */
	public List<PositionCourse> findByPosition(Position position);

	/**
	 * Find by ID of reference: position.id
	 */
	public List<PositionCourse> findByPositionId(Long positionId);

	/**
	 * Find by reference: course
	 */
	public List<PositionCourse> findByCourse(Course course);

	/**
	 * Find by ID of reference: course.id
	 */
	public List<PositionCourse> findByCourseId(Long courseId);
}
