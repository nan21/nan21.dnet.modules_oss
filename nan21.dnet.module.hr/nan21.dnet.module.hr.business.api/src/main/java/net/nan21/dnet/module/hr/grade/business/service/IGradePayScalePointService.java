/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.GradePayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.GradePayScalePoint;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;

/**
 * Interface to expose business functions specific for {@link GradePayScalePoint} domain
 * entity.
 */
public interface IGradePayScalePointService
		extends
			IEntityService<GradePayScalePoint> {

	/**
	 * Find by reference: gradePayScale
	 */
	public List<GradePayScalePoint> findByGradePayScale(
			GradePayScale gradePayScale);

	/**
	 * Find by ID of reference: gradePayScale.id
	 */
	public List<GradePayScalePoint> findByGradePayScaleId(Long gradePayScaleId);

	/**
	 * Find by reference: point
	 */
	public List<GradePayScalePoint> findByPoint(PayScalePoint point);

	/**
	 * Find by ID of reference: point.id
	 */
	public List<GradePayScalePoint> findByPointId(Long pointId);
}
