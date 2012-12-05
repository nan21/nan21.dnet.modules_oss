/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.price.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;

/**
 * Repository functionality for {@link PriceList} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PriceListService extends AbstractEntityService<PriceList> {

	public PriceListService() {
		super();
	}

	public PriceListService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PriceList> getEntityClass() {
		return PriceList.class;
	}

	/**
	 * Find by unique key
	 */
	public PriceList findByName(String name) {
		return (PriceList) this.getEntityManager()
				.createNamedQuery(PriceList.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: currency
	 */
	public List<PriceList> findByCurrency(Currency currency) {
		return this.findByCurrencyId(currency.getId());
	}

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<PriceList> findByCurrencyId(Long currencyId) {
		return (List<PriceList>) this
				.getEntityManager()
				.createQuery(
						"select e from PriceList e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
						PriceList.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCurrencyId", currencyId).getResultList();
	}
}
