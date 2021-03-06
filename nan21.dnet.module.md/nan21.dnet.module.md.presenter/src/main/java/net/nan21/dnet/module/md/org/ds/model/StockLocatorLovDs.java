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
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;

@Ds(entity = StockLocator.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = StockLocatorLovDs.f_name)})
public class StockLocatorLovDs extends AbstractTypeLov<StockLocator> {

	public static final String f_subInventoryId = "subInventoryId";

	@DsField(join = "left", path = "subInventory.id")
	private Long subInventoryId;

	public StockLocatorLovDs() {
		super();
	}

	public StockLocatorLovDs(StockLocator e) {
		super(e);
	}

	public Long getSubInventoryId() {
		return this.subInventoryId;
	}

	public void setSubInventoryId(Long subInventoryId) {
		this.subInventoryId = subInventoryId;
	}
}
