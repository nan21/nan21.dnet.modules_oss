/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.inventory.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransfer;

@Ds(entity = InvTransfer.class, sort = {@SortField(field = InvTransferDs.f_eventDate, desc = true)})
@RefLookups({
		@RefLookup(refId = InvTransferDs.f_transactionTypeId, namedQuery = InvTransactionType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = InvTransferDs.f_transactionType)}),
		@RefLookup(refId = InvTransferDs.f_fromInventoryId, namedQuery = Organization.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = InvTransferDs.f_fromInventory)}),
		@RefLookup(refId = InvTransferDs.f_toInventoryId, namedQuery = Organization.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = InvTransferDs.f_toInventory)})})
public class InvTransferDs extends AbstractAuditableDs<InvTransfer> {

	public static final String f_code = "code";
	public static final String f_docNo = "docNo";
	public static final String f_docDate = "docDate";
	public static final String f_eventDate = "eventDate";
	public static final String f_transactionTypeId = "transactionTypeId";
	public static final String f_transactionType = "transactionType";
	public static final String f_hasFromInventory = "hasFromInventory";
	public static final String f_hasToInventory = "hasToInventory";
	public static final String f_fromInventoryId = "fromInventoryId";
	public static final String f_fromInventory = "fromInventory";
	public static final String f_toInventoryId = "toInventoryId";
	public static final String f_toInventory = "toInventory";
	public static final String f_confirmed = "confirmed";
	public static final String f_posted = "posted";

	@DsField
	private String code;

	@DsField
	private String docNo;

	@DsField
	private Date docDate;

	@DsField
	private Date eventDate;

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
	private Boolean confirmed;

	@DsField
	private Boolean posted;

	public InvTransferDs() {
		super();
	}

	public InvTransferDs(InvTransfer e) {
		super(e);
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDocNo() {
		return this.docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public Date getDocDate() {
		return this.docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
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

	public Boolean getConfirmed() {
		return this.confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	public Boolean getPosted() {
		return this.posted;
	}

	public void setPosted(Boolean posted) {
		this.posted = posted;
	}
}
