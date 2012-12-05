/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.currency.business.serviceimpl;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyXRateService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRate;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

/**
 * Repository functionality for {@link CurrencyXRate} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CurrencyXRateService extends AbstractEntityService<CurrencyXRate>
		implements
			ICurrencyXRateService {

	public CurrencyXRateService() {
		super();
	}

	public CurrencyXRateService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CurrencyXRate> getEntityClass() {
		return CurrencyXRate.class;
	}

	/**
	 * Find by unique key
	 */
	public CurrencyXRate findByValid(CurrencyXRateProvider provider,
			Currency source, Currency target, Date validAt) {
		return (CurrencyXRate) this.getEntityManager()
				.createNamedQuery(CurrencyXRate.NQ_FIND_BY_VALID)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProvider", provider)
				.setParameter("pSource", source)
				.setParameter("pTarget", target)
				.setParameter("pValidAt", validAt).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public CurrencyXRate findByValid(Long providerId, Long sourceId,
			Long targetId, Date validAt) {
		return (CurrencyXRate) this.getEntityManager()
				.createNamedQuery(CurrencyXRate.NQ_FIND_BY_VALID_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProviderId", providerId)
				.setParameter("pSourceId", sourceId)
				.setParameter("pTargetId", targetId)
				.setParameter("pValidAt", validAt).getSingleResult();
	}

	/**
	 * Find by reference: provider
	 */
	public List<CurrencyXRate> findByProvider(CurrencyXRateProvider provider) {
		return this.findByProviderId(provider.getId());
	}

	/**
	 * Find by ID of reference: provider.id
	 */
	public List<CurrencyXRate> findByProviderId(Long providerId) {
		return (List<CurrencyXRate>) this
				.getEntityManager()
				.createQuery(
						"select e from CurrencyXRate e where e.clientId = :pClientId and e.provider.id = :pProviderId",
						CurrencyXRate.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProviderId", providerId).getResultList();
	}

	/**
	 * Find by reference: source
	 */
	public List<CurrencyXRate> findBySource(Currency source) {
		return this.findBySourceId(source.getId());
	}

	/**
	 * Find by ID of reference: source.id
	 */
	public List<CurrencyXRate> findBySourceId(Long sourceId) {
		return (List<CurrencyXRate>) this
				.getEntityManager()
				.createQuery(
						"select e from CurrencyXRate e where e.clientId = :pClientId and e.source.id = :pSourceId",
						CurrencyXRate.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSourceId", sourceId).getResultList();
	}

	/**
	 * Find by reference: target
	 */
	public List<CurrencyXRate> findByTarget(Currency target) {
		return this.findByTargetId(target.getId());
	}

	/**
	 * Find by ID of reference: target.id
	 */
	public List<CurrencyXRate> findByTargetId(Long targetId) {
		return (List<CurrencyXRate>) this
				.getEntityManager()
				.createQuery(
						"select e from CurrencyXRate e where e.clientId = :pClientId and e.target.id = :pTargetId",
						CurrencyXRate.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTargetId", targetId).getResultList();
	}
}
