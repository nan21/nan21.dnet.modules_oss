/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.order.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseInventoryTransaction;

@Ds(entity = PurchaseInventoryTransaction.class)
@RefLookups({
		@RefLookup(refId = PurchaseInventoryTransactionDs.f_supplierId, namedQuery = BusinessPartner.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = PurchaseInventoryTransactionDs.f_supplier)}),
		@RefLookup(refId = PurchaseInventoryTransactionDs.f_transactionTypeId, namedQuery = InvTransactionType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PurchaseInventoryTransactionDs.f_transactionType)}),
		@RefLookup(refId = PurchaseInventoryTransactionDs.f_fromInventoryId, namedQuery = Organization.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PurchaseInventoryTransactionDs.f_fromInventory)}),
		@RefLookup(refId = PurchaseInventoryTransactionDs.f_toInventoryId, namedQuery = Organization.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PurchaseInventoryTransactionDs.f_toInventory)})})
public class PurchaseInventoryTransactionDs
		extends
			AbstractAuditableDs<PurchaseInventoryTransaction> {

	public static final String f_supplierId = "supplierId";
	public static final String f_supplier = "supplier";
	public static final String f_transactionTypeId = "transactionTypeId";
	public static final String f_transactionType = "transactionType";
	public static final String f_hasFromInventory = "hasFromInventory";
	public static final String f_hasToInventory = "hasToInventory";
	public static final String f_fromInventoryId = "fromInventoryId";
	public static final String f_fromInventory = "fromInventory";
	public static final String f_toInventoryId = "toInventoryId";
	public static final String f_toInventory = "toInventory";
	public static final String f_eventDate = "eventDate";

	@DsField(join = "left", path = "supplier.id")
	private Long supplierId;

	@DsField(join = "left", path = "supplier.code")
	private String supplier;

	@DsField(join = "left", path = "transactionType.id")
	private Long transactionTypeId;

	@DsField(join = "left", path = "transactionType.name")
	private String transactionType;

	@DsField(join = "left", path = "transactionType.hasFromInventory")
	private Boolean hasFromInventory;

	@DsField(join = "left", path = "transactionType.hasToInventory")
	private Boolean hasToInventory;

	@DsField(join = "left", path = "fromInventory.id")
	private Long fromInventoryId;

	@DsField(join = "left", path = "fromInventory.code")
	private String fromInventory;

	@DsField(join = "left", path = "toInventory.id")
	private Long toInventoryId;

	@DsField(join = "left", path = "toInventory.code")
	private String toInventory;

	@DsField
	private Date eventDate;

	public PurchaseInventoryTransactionDs() {
		super();
	}

	public PurchaseInventoryTransactionDs(PurchaseInventoryTransaction e) {
		super(e);
	}

	public Long getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplier() {
		return this.supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Long getTransactionTypeId() {
		return this.transactionTypeId;
	}

	public void setTransactionTypeId(Long transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Boolean getHasFromInventory() {
		return this.hasFromInventory;
	}

	public void setHasFromInventory(Boolean hasFromInventory) {
		this.hasFromInventory = hasFromInventory;
	}

	public Boolean getHasToInventory() {
		return this.hasToInventory;
	}

	public void setHasToInventory(Boolean hasToInventory) {
		this.hasToInventory = hasToInventory;
	}

	public Long getFromInventoryId() {
		return this.fromInventoryId;
	}

	public void setFromInventoryId(Long fromInventoryId) {
		this.fromInventoryId = fromInventoryId;
	}

	public String getFromInventory() {
		return this.fromInventory;
	}

	public void setFromInventory(String fromInventory) {
		this.fromInventory = fromInventory;
	}

	public Long getToInventoryId() {
		return this.toInventoryId;
	}

	public void setToInventoryId(Long toInventoryId) {
		this.toInventoryId = toInventoryId;
	}

	public String getToInventory() {
		return this.toInventory;
	}

	public void setToInventory(String toInventory) {
		this.toInventory = toInventory;
	}

	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
}
