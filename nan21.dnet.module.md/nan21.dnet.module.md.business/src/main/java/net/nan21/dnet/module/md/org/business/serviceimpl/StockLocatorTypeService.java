/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.org.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.org.business.service.IStockLocatorTypeService;
import net.nan21.dnet.module.md.org.domain.entity.StockLocatorType;

/**
 * Repository functionality for {@link StockLocatorType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class StockLocatorTypeService
		extends
			AbstractEntityService<StockLocatorType>
		implements
			IStockLocatorTypeService {

	public StockLocatorTypeService() {
		super();
	}

	public StockLocatorTypeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<StockLocatorType> getEntityClass() {
		return StockLocatorType.class;
	}

	/**
	 * Find by unique key
	 */
	public StockLocatorType findByName(String name) {
		return (StockLocatorType) this.em
				.createNamedQuery(StockLocatorType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
