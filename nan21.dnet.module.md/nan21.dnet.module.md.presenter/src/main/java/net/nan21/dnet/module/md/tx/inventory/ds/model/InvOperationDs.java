/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.inventory.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvOperation;

@Ds(entity = InvOperation.class, sort = {@SortField(field = InvOperationDs.f_eventDate, desc = true)})
public class InvOperationDs extends AbstractAuditableDs<InvOperation> {

	public static final String f_itemId = "itemId";
	public static final String f_itemCode = "itemCode";
	public static final String f_item = "item";
	public static final String f_eventDate = "eventDate";
	public static final String f_inventoryId = "inventoryId";
	public static final String f_inventory = "inventory";
	public static final String f_inventoryName = "inventoryName";
	public static final String f_subInventoryId = "subInventoryId";
	public static final String f_subInventory = "subInventory";
	public static final String f_locatorId = "locatorId";
	public static final String f_locator = "locator";
	public static final String f_transactionId = "transactionId";
	public static final String f_transactionLineId = "transactionLineId";
	public static final String f_direction = "direction";
	public static final String f_quantity = "quantity";
	public static final String f_uomId = "uomId";
	public static final String f_uom = "uom";

	@DsField(join = "left", path = "item.id")
	private Long itemId;

	@DsField(join = "left", path = "item.code")
	private String itemCode;

	@DsField(join = "left", path = "item.name")
	private String item;

	@DsField
	private Date eventDate;

	@DsField(join = "left", path = "inventory.id")
	private Long inventoryId;

	@DsField(join = "left", path = "inventory.code")
	private String inventory;

	@DsField(join = "left", path = "inventory.name")
	private String inventoryName;

	@DsField(join = "left", path = "subInventory.id")
	private Long subInventoryId;

	@DsField(join = "left", path = "subInventory.name")
	private String subInventory;

	@DsField(join = "left", path = "locator.id")
	private Long locatorId;

	@DsField(join = "left", path = "locator.name")
	private String locator;

	@DsField(join = "left", path = "transactionLine.invTransaction.id")
	private Long transactionId;

	@DsField(join = "left", path = "transactionLine.id")
	private Long transactionLineId;

	@DsField
	private String direction;

	@DsField
	private Float quantity;

	@DsField(join = "left", path = "uom.id")
	private Long uomId;

	@DsField(join = "left", path = "uom.code")
	private String uom;

	public InvOperationDs() {
		super();
	}

	public InvOperationDs(InvOperation e) {
		super(e);
	}

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Long getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventory() {
		return this.inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getInventoryName() {
		return this.inventoryName;
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
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

	public Long getLocatorId() {
		return this.locatorId;
	}

	public void setLocatorId(Long locatorId) {
		this.locatorId = locatorId;
	}

	public String getLocator() {
		return this.locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public Long getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getTransactionLineId() {
		return this.transactionLineId;
	}

	public void setTransactionLineId(Long transactionLineId) {
		this.transactionLineId = transactionLineId;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Float getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public Long getUomId() {
		return this.uomId;
	}

	public void setUomId(Long uomId) {
		this.uomId = uomId;
	}

	public String getUom() {
		return this.uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}
}
