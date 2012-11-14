/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.BusinessObject;

/**
 * Interface to expose business functions specific for {@link BusinessObject} domain
 * entity.
 */
public interface IBusinessObjectService extends IEntityService<BusinessObject> {

	/**
	 * Find by unique key
	 */
	public BusinessObject findByName(String name);
}
