/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.acc.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;

/**
 * Interface to expose business functions specific for {@link AccSchema} domain
 * entity.
 */
public interface IAccSchemaService extends IEntityService<AccSchema> {

	/**
	 * Find by unique key
	 */
	public AccSchema findByCode(String code);

	/**
	 * Find by unique key
	 */
	public AccSchema findByName(String name);
}
