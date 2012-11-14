/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.grade.business.service.IPayScaleService;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;

/**
 * Repository functionality for {@link PayScale} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PayScaleService extends AbstractEntityService<PayScale>
		implements
			IPayScaleService {

	public PayScaleService() {
		super();
	}

	public PayScaleService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<PayScale> getEntityClass() {
		return PayScale.class;
	}

	/**
	 * Find by unique key
	 */
	public PayScale findByCode(String code) {
		return (PayScale) this.em.createNamedQuery(PayScale.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public PayScale findByName(String name) {
		return (PayScale) this.em.createNamedQuery(PayScale.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
