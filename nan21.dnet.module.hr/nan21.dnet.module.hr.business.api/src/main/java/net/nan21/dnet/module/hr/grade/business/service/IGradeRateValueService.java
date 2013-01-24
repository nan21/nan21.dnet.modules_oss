/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRateValue;

/**
 * Interface to expose business functions specific for {@link GradeRateValue} domain
 * entity.
 */
public interface IGradeRateValueService extends IEntityService<GradeRateValue> {

	/**
	 * Find by reference: gradeRate
	 */
	public List<GradeRateValue> findByGradeRate(GradeRate gradeRate);

	/**
	 * Find by ID of reference: gradeRate.id
	 */
	public List<GradeRateValue> findByGradeRateId(Long gradeRateId);

	/**
	 * Find by reference: grade
	 */
	public List<GradeRateValue> findByGrade(Grade grade);

	/**
	 * Find by ID of reference: grade.id
	 */
	public List<GradeRateValue> findByGradeId(Long gradeId);
}
