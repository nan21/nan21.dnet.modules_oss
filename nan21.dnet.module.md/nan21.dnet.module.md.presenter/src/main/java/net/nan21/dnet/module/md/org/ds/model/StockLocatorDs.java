/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;

@Ds(entity = StockLocator.class, sort = {@SortField(field = StockLocatorDs.f_name)})
@RefLookups({@RefLookup(refId = StockLocatorDs.f_subInventoryId, namedQuery = SubInventory.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = StockLocatorDs.f_subInventory)})})
public class StockLocatorDs extends AbstractTypeDs<StockLocator> {

	public static final String f_subInventoryId = "subInventoryId";
	public static final String f_subInventory = "subInventory";
	public static final String f_locatorTypeId = "locatorTypeId";
	public static final String f_locatorType = "locatorType";

	@DsField(join = "left", path = "subInventory.id")
	private Long subInventoryId;

	@DsField(join = "left", path = "subInventory.name")
	private String subInventory;

	@DsField(join = "left", path = "locatorType.id")
	private Long locatorTypeId;

	@DsField(join = "left", path = "locatorType.name")
	private String locatorType;

	public StockLocatorDs() {
		super();
	}

	public StockLocatorDs(StockLocator e) {
		super(e);
	}

	public Long getSubInventoryId() {
		return this.subInventoryId;
	}

	public void setSubInventoryId(Long subInventoryId) {
		this.subInventoryId = subInventoryId;
	}

	public String getSubInventory() {
		return this.subInventory;
	}

	public void setSubInventory(String subInventory) {
		this.subInventory = subInventory;
	}

	public Long getLocatorTypeId() {
		return this.locatorTypeId;
	}

	public void setLocatorTypeId(Long locatorTypeId) {
		this.locatorTypeId = locatorTypeId;
	}

	public String getLocatorType() {
		return this.locatorType;
	}

	public void setLocatorType(String locatorType) {
		this.locatorType = locatorType;
	}
}
