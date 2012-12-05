/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.org.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.org.business.service.IStockLocatorService;
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;
import net.nan21.dnet.module.md.org.domain.entity.StockLocatorType;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;

/**
 * Repository functionality for {@link StockLocator} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class StockLocatorService extends AbstractEntityService<StockLocator>
		implements
			IStockLocatorService {

	public StockLocatorService() {
		super();
	}

	public StockLocatorService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<StockLocator> getEntityClass() {
		return StockLocator.class;
	}

	/**
	 * Find by unique key
	 */
	public StockLocator findByName(String name) {
		return (StockLocator) this.getEntityManager()
				.createNamedQuery(StockLocator.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: subInventory
	 */
	public List<StockLocator> findBySubInventory(SubInventory subInventory) {
		return this.findBySubInventoryId(subInventory.getId());
	}

	/**
	 * Find by ID of reference: subInventory.id
	 */
	public List<StockLocator> findBySubInventoryId(Long subInventoryId) {
		return (List<StockLocator>) this
				.getEntityManager()
				.createQuery(
						"select e from StockLocator e where e.clientId = :pClientId and e.subInventory.id = :pSubInventoryId",
						StockLocator.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSubInventoryId", subInventoryId)
				.getResultList();
	}

	/**
	 * Find by reference: locatorType
	 */
	public List<StockLocator> findByLocatorType(StockLocatorType locatorType) {
		return this.findByLocatorTypeId(locatorType.getId());
	}

	/**
	 * Find by ID of reference: locatorType.id
	 */
	public List<StockLocator> findByLocatorTypeId(Long locatorTypeId) {
		return (List<StockLocator>) this
				.getEntityManager()
				.createQuery(
						"select e from StockLocator e where e.clientId = :pClientId and e.locatorType.id = :pLocatorTypeId",
						StockLocator.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pLocatorTypeId", locatorTypeId).getResultList();
	}
}
