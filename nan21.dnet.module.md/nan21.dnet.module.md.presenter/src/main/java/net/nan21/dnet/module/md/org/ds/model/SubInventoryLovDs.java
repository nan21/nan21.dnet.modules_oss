/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;

@Ds(entity = SubInventory.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = SubInventoryLovDs.f_name)})
public class SubInventoryLovDs extends AbstractTypeLov<SubInventory> {

	public static final String f_inventoryId = "inventoryId";

	@DsField(join = "left", path = "inventory.id")
	private Long inventoryId;

	public SubInventoryLovDs() {
		super();
	}

	public SubInventoryLovDs(SubInventory e) {
		super(e);
	}

	public Long getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}
}
