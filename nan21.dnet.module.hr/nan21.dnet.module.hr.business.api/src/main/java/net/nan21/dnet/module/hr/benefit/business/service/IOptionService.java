/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.benefit.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.benefit.domain.entity.Option;

/**
 * Interface to expose business functions specific for {@link Option} domain
 * entity.
 */
public interface IOptionService extends IEntityService<Option> {

	/**
	 * Find by unique key
	 */
	public Option findByName(String name);
}
