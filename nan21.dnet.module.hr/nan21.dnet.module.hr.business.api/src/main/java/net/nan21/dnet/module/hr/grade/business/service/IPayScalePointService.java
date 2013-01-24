/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;

/**
 * Interface to expose business functions specific for {@link PayScalePoint} domain
 * entity.
 */
public interface IPayScalePointService extends IEntityService<PayScalePoint> {

	/**
	 * Find by unique key
	 */
	public PayScalePoint findByScale_code(PayScale payScale, String code);

	/**
	 * Find by unique key
	 */
	public PayScalePoint findByScale_code(Long payScaleId, String code);

	/**
	 * Find by reference: payScale
	 */
	public List<PayScalePoint> findByPayScale(PayScale payScale);

	/**
	 * Find by ID of reference: payScale.id
	 */
	public List<PayScalePoint> findByPayScaleId(Long payScaleId);
}
