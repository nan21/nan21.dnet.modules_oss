/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.currency.business.service;

import java.util.Date;
import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRate;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

/**
 * Interface to expose business functions specific for {@link CurrencyXRate} domain
 * entity.
 */
public interface ICurrencyXRateService extends IEntityService<CurrencyXRate> {

	/**
	 * Find by unique key
	 */
	public CurrencyXRate findByValid(CurrencyXRateProvider provider,
			Currency source, Currency target, Date validAt);

	/**
	 * Find by unique key
	 */
	public CurrencyXRate findByValid(Long providerId, Long sourceId,
			Long targetId, Date validAt);

	/**
	 * Find by reference: provider
	 */
	public List<CurrencyXRate> findByProvider(CurrencyXRateProvider provider);

	/**
	 * Find by ID of reference: provider.id
	 */
	public List<CurrencyXRate> findByProviderId(Long providerId);

	/**
	 * Find by reference: source
	 */
	public List<CurrencyXRate> findBySource(Currency source);

	/**
	 * Find by ID of reference: source.id
	 */
	public List<CurrencyXRate> findBySourceId(Long sourceId);

	/**
	 * Find by reference: target
	 */
	public List<CurrencyXRate> findByTarget(Currency target);

	/**
	 * Find by ID of reference: target.id
	 */
	public List<CurrencyXRate> findByTargetId(Long targetId);
}
