/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tx.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.base.tx.business.service.IDeliveryMethodService;
import net.nan21.dnet.module.md.base.tx.domain.entity.DeliveryMethod;

/**
 * Repository functionality for {@link DeliveryMethod} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DeliveryMethodService
		extends
			AbstractEntityService<DeliveryMethod>
		implements
			IDeliveryMethodService {

	public DeliveryMethodService() {
		super();
	}

	public DeliveryMethodService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DeliveryMethod> getEntityClass() {
		return DeliveryMethod.class;
	}

	/**
	 * Find by unique key
	 */
	public DeliveryMethod findByName(String name) {
		return (DeliveryMethod) this.getEntityManager()
				.createNamedQuery(DeliveryMethod.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
