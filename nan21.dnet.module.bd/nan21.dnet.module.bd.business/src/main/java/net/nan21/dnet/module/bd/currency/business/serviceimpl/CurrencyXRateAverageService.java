/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.currency.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyXRateAverageService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateAverage;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

/**
 * Repository functionality for {@link CurrencyXRateAverage} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CurrencyXRateAverageService
		extends
			AbstractEntityService<CurrencyXRateAverage>
		implements
			ICurrencyXRateAverageService {

	public CurrencyXRateAverageService() {
		super();
	}

	public CurrencyXRateAverageService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<CurrencyXRateAverage> getEntityClass() {
		return CurrencyXRateAverage.class;
	}

	/**
	 * Find by reference: provider
	 */
	public List<CurrencyXRateAverage> findByProvider(
			CurrencyXRateProvider provider) {
		return this.findByProviderId(provider.getId());
	}

	/**
	 * Find by ID of reference: provider.id
	 */
	public List<CurrencyXRateAverage> findByProviderId(Long providerId) {
		return (List<CurrencyXRateAverage>) this.em
				.createQuery(
						"select e from CurrencyXRateAverage e where e.clientId = :pClientId and e.provider.id = :pProviderId",
						CurrencyXRateAverage.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProviderId", providerId).getResultList();
	}

	/**
	 * Find by reference: source
	 */
	public List<CurrencyXRateAverage> findBySource(Currency source) {
		return this.findBySourceId(source.getId());
	}

	/**
	 * Find by ID of reference: source.id
	 */
	public List<CurrencyXRateAverage> findBySourceId(Long sourceId) {
		return (List<CurrencyXRateAverage>) this.em
				.createQuery(
						"select e from CurrencyXRateAverage e where e.clientId = :pClientId and e.source.id = :pSourceId",
						CurrencyXRateAverage.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSourceId", sourceId).getResultList();
	}

	/**
	 * Find by reference: target
	 */
	public List<CurrencyXRateAverage> findByTarget(Currency target) {
		return this.findByTargetId(target.getId());
	}

	/**
	 * Find by ID of reference: target.id
	 */
	public List<CurrencyXRateAverage> findByTargetId(Long targetId) {
		return (List<CurrencyXRateAverage>) this.em
				.createQuery(
						"select e from CurrencyXRateAverage e where e.clientId = :pClientId and e.target.id = :pTargetId",
						CurrencyXRateAverage.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTargetId", targetId).getResultList();
	}
}
