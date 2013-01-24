/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.currency.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

/**
 * Interface to expose business functions specific for {@link CurrencyXRateProvider} domain
 * entity.
 */
public interface ICurrencyXRateProviderService
		extends
			IEntityService<CurrencyXRateProvider> {

	/**
	 * Find by unique key
	 */
	public CurrencyXRateProvider findByCode(String code);

	/**
	 * Find by unique key
	 */
	public CurrencyXRateProvider findByName(String name);
}
