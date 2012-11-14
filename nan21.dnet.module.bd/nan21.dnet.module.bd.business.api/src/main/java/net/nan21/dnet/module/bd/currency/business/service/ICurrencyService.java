/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.currency.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;

/**
 * Interface to expose business functions specific for {@link Currency} domain
 * entity.
 */
public interface ICurrencyService extends IEntityService<Currency> {

	/**
	 * Find by unique key
	 */
	public Currency findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Currency findByName(String name);
}
