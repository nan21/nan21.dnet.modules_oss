/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.currency.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateAverage;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

/**
 * Interface to expose business functions specific for {@link CurrencyXRateAverage} domain
 * entity.
 */
public interface ICurrencyXRateAverageService
		extends
			IEntityService<CurrencyXRateAverage> {

	/**
	 * Find by reference: provider
	 */
	public List<CurrencyXRateAverage> findByProvider(
			CurrencyXRateProvider provider);

	/**
	 * Find by ID of reference: provider.id
	 */
	public List<CurrencyXRateAverage> findByProviderId(Long providerId);

	/**
	 * Find by reference: source
	 */
	public List<CurrencyXRateAverage> findBySource(Currency source);

	/**
	 * Find by ID of reference: source.id
	 */
	public List<CurrencyXRateAverage> findBySourceId(Long sourceId);

	/**
	 * Find by reference: target
	 */
	public List<CurrencyXRateAverage> findByTarget(Currency target);

	/**
	 * Find by ID of reference: target.id
	 */
	public List<CurrencyXRateAverage> findByTargetId(Long targetId);
}
