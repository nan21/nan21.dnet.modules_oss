/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.currency.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyXRateProviderService;
import net.nan21.dnet.module.bd.currency.domain.entity.CurrencyXRateProvider;

/**
 * Repository functionality for {@link CurrencyXRateProvider} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CurrencyXRateProviderService
		extends
			AbstractEntityService<CurrencyXRateProvider>
		implements
			ICurrencyXRateProviderService {

	public CurrencyXRateProviderService() {
		super();
	}

	public CurrencyXRateProviderService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<CurrencyXRateProvider> getEntityClass() {
		return CurrencyXRateProvider.class;
	}

	/**
	 * Find by unique key
	 */
	public CurrencyXRateProvider findByCode(String code) {
		return (CurrencyXRateProvider) this.getEntityManager()
				.createNamedQuery(CurrencyXRateProvider.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public CurrencyXRateProvider findByName(String name) {
		return (CurrencyXRateProvider) this.getEntityManager()
				.createNamedQuery(CurrencyXRateProvider.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
