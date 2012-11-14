/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;

/**
 * Interface to expose business functions specific for {@link SubInventory} domain
 * entity.
 */
public interface ISubInventoryService extends IEntityService<SubInventory> {

	/**
	 * Find by unique key
	 */
	public SubInventory findByName(String name);

	/**
	 * Find by reference: inventory
	 */
	public List<SubInventory> findByInventory(Organization inventory);

	/**
	 * Find by ID of reference: inventory.id
	 */
	public List<SubInventory> findByInventoryId(Long inventoryId);
}
