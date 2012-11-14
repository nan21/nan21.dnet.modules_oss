/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.LicenseType;

/**
 * Interface to expose business functions specific for {@link LicenseType} domain
 * entity.
 */
public interface ILicenseTypeService extends IEntityService<LicenseType> {

	/**
	 * Find by unique key
	 */
	public LicenseType findByName(String name);
}
