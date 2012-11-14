/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.hr.grade.business.service.IGradeRateService;
import net.nan21.dnet.module.hr.grade.domain.entity.GradeRate;

/**
 * Repository functionality for {@link GradeRate} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class GradeRateService extends AbstractEntityService<GradeRate>
		implements
			IGradeRateService {

	public GradeRateService() {
		super();
	}

	public GradeRateService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<GradeRate> getEntityClass() {
		return GradeRate.class;
	}

	/**
	 * Find by unique key
	 */
	public GradeRate findByName(String name) {
		return (GradeRate) this.em.createNamedQuery(GradeRate.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: currency
	 */
	public List<GradeRate> findByCurrency(Currency currency) {
		return this.findByCurrencyId(currency.getId());
	}

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<GradeRate> findByCurrencyId(Long currencyId) {
		return (List<GradeRate>) this.em
				.createQuery(
						"select e from GradeRate e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
						GradeRate.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCurrencyId", currencyId).getResultList();
	}
}
