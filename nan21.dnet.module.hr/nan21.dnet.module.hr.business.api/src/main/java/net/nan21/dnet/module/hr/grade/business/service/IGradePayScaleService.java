/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.GradePayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;

/**
 * Interface to expose business functions specific for {@link GradePayScale} domain
 * entity.
 */
public interface IGradePayScaleService extends IEntityService<GradePayScale> {

	/**
	 * Find by reference: grade
	 */
	public List<GradePayScale> findByGrade(Grade grade);

	/**
	 * Find by ID of reference: grade.id
	 */
	public List<GradePayScale> findByGradeId(Long gradeId);

	/**
	 * Find by reference: payScale
	 */
	public List<GradePayScale> findByPayScale(PayScale payScale);

	/**
	 * Find by ID of reference: payScale.id
	 */
	public List<GradePayScale> findByPayScaleId(Long payScaleId);

	/**
	 * Find by reference: ceiling
	 */
	public List<GradePayScale> findByCeiling(PayScalePoint ceiling);

	/**
	 * Find by ID of reference: ceiling.id
	 */
	public List<GradePayScale> findByCeilingId(Long ceilingId);
}
