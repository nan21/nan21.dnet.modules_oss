/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.benefit.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.benefit.domain.entity.BenefitType;

/**
 * Interface to expose business functions specific for {@link BenefitType} domain
 * entity.
 */
public interface IBenefitTypeService extends IEntityService<BenefitType> {

	/**
	 * Find by unique key
	 */
	public BenefitType findByName(String name);
}
