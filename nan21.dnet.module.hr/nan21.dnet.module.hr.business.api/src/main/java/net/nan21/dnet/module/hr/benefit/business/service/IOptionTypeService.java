/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.benefit.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.benefit.domain.entity.OptionType;

/**
 * Interface to expose business functions specific for {@link OptionType} domain
 * entity.
 */
public interface IOptionTypeService extends IEntityService<OptionType> {

	/**
	 * Find by unique key
	 */
	public OptionType findByName(String name);
}
