/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.currency.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.business.service.ICurrencyService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;

/**
 * Repository functionality for {@link Currency} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CurrencyService extends AbstractEntityService<Currency>
		implements
			ICurrencyService {

	public CurrencyService() {
		super();
	}

	public CurrencyService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Currency> getEntityClass() {
		return Currency.class;
	}

	/**
	 * Find by unique key
	 */
	public Currency findByCode(String code) {
		return (Currency) this.getEntityManager()
				.createNamedQuery(Currency.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public Currency findByName(String name) {
		return (Currency) this.getEntityManager()
				.createNamedQuery(Currency.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
