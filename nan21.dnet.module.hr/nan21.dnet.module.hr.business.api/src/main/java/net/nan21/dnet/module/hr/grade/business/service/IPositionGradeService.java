/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.PositionGrade;
import net.nan21.dnet.module.hr.job.domain.entity.Position;

/**
 * Interface to expose business functions specific for {@link PositionGrade} domain
 * entity.
 */
public interface IPositionGradeService extends IEntityService<PositionGrade> {

	/**
	 * Find by reference: position
	 */
	public List<PositionGrade> findByPosition(Position position);

	/**
	 * Find by ID of reference: position.id
	 */
	public List<PositionGrade> findByPositionId(Long positionId);

	/**
	 * Find by reference: grade
	 */
	public List<PositionGrade> findByGrade(Grade grade);

	/**
	 * Find by ID of reference: grade.id
	 */
	public List<PositionGrade> findByGradeId(Long gradeId);
}
