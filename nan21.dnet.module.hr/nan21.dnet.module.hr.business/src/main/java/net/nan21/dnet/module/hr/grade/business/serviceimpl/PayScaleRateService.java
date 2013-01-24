/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.hr.grade.business.service.IPayScaleRateService;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScaleRate;

/**
 * Repository functionality for {@link PayScaleRate} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PayScaleRateService extends AbstractEntityService<PayScaleRate>
		implements
			IPayScaleRateService {

	public PayScaleRateService() {
		super();
	}

	public PayScaleRateService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PayScaleRate> getEntityClass() {
		return PayScaleRate.class;
	}

	/**
	 * Find by unique key
	 */
	public PayScaleRate findByName(String name) {
		return (PayScaleRate) this.getEntityManager()
				.createNamedQuery(PayScaleRate.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: payScale
	 */
	public List<PayScaleRate> findByPayScale(PayScale payScale) {
		return this.findByPayScaleId(payScale.getId());
	}

	/**
	 * Find by ID of reference: payScale.id
	 */
	public List<PayScaleRate> findByPayScaleId(Long payScaleId) {
		return (List<PayScaleRate>) this
				.getEntityManager()
				.createQuery(
						"select e from PayScaleRate e where e.clientId = :pClientId and e.payScale.id = :pPayScaleId",
						PayScaleRate.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPayScaleId", payScaleId).getResultList();
	}

	/**
	 * Find by reference: currency
	 */
	public List<PayScaleRate> findByCurrency(Currency currency) {
		return this.findByCurrencyId(currency.getId());
	}

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<PayScaleRate> findByCurrencyId(Long currencyId) {
		return (List<PayScaleRate>) this
				.getEntityManager()
				.createQuery(
						"select e from PayScaleRate e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
						PayScaleRate.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCurrencyId", currencyId).getResultList();
	}
}
