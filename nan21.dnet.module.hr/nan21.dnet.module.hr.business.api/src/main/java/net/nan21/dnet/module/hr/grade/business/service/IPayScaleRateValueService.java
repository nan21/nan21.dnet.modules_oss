/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRate;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRateValue;

/**
 * Interface to expose business functions specific for {@link PayScaleRateValue} domain
 * entity.
 */
public interface IPayScaleRateValueService
		extends
			IEntityService<PayScaleRateValue> {

	/**
	 * Find by reference: scaleRate
	 */
	public List<PayScaleRateValue> findByScaleRate(PayScaleRate scaleRate);

	/**
	 * Find by ID of reference: scaleRate.id
	 */
	public List<PayScaleRateValue> findByScaleRateId(Long scaleRateId);

	/**
	 * Find by reference: scalePoint
	 */
	public List<PayScaleRateValue> findByScalePoint(PayScalePoint scalePoint);

	/**
	 * Find by ID of reference: scalePoint.id
	 */
	public List<PayScaleRateValue> findByScalePointId(Long scalePointId);
}
