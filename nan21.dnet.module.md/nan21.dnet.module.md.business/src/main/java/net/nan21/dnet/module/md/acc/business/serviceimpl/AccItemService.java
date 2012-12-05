/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.acc.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.acc.business.service.IAccItemService;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;

/**
 * Repository functionality for {@link AccItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AccItemService extends AbstractEntityService<AccItem>
		implements
			IAccItemService {

	public AccItemService() {
		super();
	}

	public AccItemService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AccItem> getEntityClass() {
		return AccItem.class;
	}

	/**
	 * Find by unique key
	 */
	public AccItem findByName(String name) {
		return (AccItem) this.getEntityManager()
				.createNamedQuery(AccItem.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
