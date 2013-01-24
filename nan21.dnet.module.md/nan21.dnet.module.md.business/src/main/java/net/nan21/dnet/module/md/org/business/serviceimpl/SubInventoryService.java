/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.org.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.org.business.service.ISubInventoryService;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;

/**
 * Repository functionality for {@link SubInventory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SubInventoryService extends AbstractEntityService<SubInventory>
		implements
			ISubInventoryService {

	public SubInventoryService() {
		super();
	}

	public SubInventoryService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SubInventory> getEntityClass() {
		return SubInventory.class;
	}

	/**
	 * Find by unique key
	 */
	public SubInventory findByName(String name) {
		return (SubInventory) this.getEntityManager()
				.createNamedQuery(SubInventory.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: inventory
	 */
	public List<SubInventory> findByInventory(Organization inventory) {
		return this.findByInventoryId(inventory.getId());
	}

	/**
	 * Find by ID of reference: inventory.id
	 */
	public List<SubInventory> findByInventoryId(Long inventoryId) {
		return (List<SubInventory>) this
				.getEntityManager()
				.createQuery(
						"select e from SubInventory e where e.clientId = :pClientId and e.inventory.id = :pInventoryId",
						SubInventory.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pInventoryId", inventoryId).getResultList();
	}
}
