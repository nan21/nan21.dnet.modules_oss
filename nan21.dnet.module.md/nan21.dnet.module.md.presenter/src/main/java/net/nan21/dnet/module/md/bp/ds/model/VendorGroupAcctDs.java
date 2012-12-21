/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroupAcct;

@Ds(entity = VendorGroupAcct.class)
@RefLookups({
		@RefLookup(refId = VendorGroupAcctDs.f_vendorGroupId, namedQuery = VendorGroup.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = VendorGroupAcctDs.f_vendorGroup)}),
		@RefLookup(refId = VendorGroupAcctDs.f_purchaseAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = VendorGroupAcctDs.f_purchaseAccount)}),
		@RefLookup(refId = VendorGroupAcctDs.f_prepayAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = VendorGroupAcctDs.f_prepayAccount)}),
		@RefLookup(refId = VendorGroupAcctDs.f_accSchemaId, namedQuery = AccSchema.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = VendorGroupAcctDs.f_accSchema)})})
public class VendorGroupAcctDs extends AbstractAuditableDs<VendorGroupAcct> {

	public static final String f_vendorGroupId = "vendorGroupId";
	public static final String f_vendorGroup = "vendorGroup";
	public static final String f_accSchemaId = "accSchemaId";
	public static final String f_accSchema = "accSchema";
	public static final String f_purchaseAccountId = "purchaseAccountId";
	public static final String f_purchaseAccount = "purchaseAccount";
	public static final String f_purchaseAccountName = "purchaseAccountName";
	public static final String f_prepayAccountId = "prepayAccountId";
	public static final String f_prepayAccount = "prepayAccount";
	public static final String f_prepayAccountName = "prepayAccountName";

	@DsField(join = "left", path = "vendorGroup.id")
	private Long vendorGroupId;

	@DsField(join = "left", path = "vendorGroup.code")
	private String vendorGroup;

	@DsField(join = "left", path = "accSchema.id")
	private Long accSchemaId;

	@DsField(join = "left", path = "accSchema.code")
	private String accSchema;

	@DsField(join = "left", path = "purchaseAccount.id")
	private Long purchaseAccountId;

	@DsField(join = "left", path = "purchaseAccount.code")
	private String purchaseAccount;

	@DsField(join = "left", path = "purchaseAccount.name")
	private String purchaseAccountName;

	@DsField(join = "left", path = "prepayAccount.id")
	private Long prepayAccountId;

	@DsField(join = "left", path = "prepayAccount.code")
	private String prepayAccount;

	@DsField(join = "left", path = "prepayAccount.name")
	private String prepayAccountName;

	public VendorGroupAcctDs() {
		super();
	}

	public VendorGroupAcctDs(VendorGroupAcct e) {
		super(e);
	}

	public Long getVendorGroupId() {
		return this.vendorGroupId;
	}

	public void setVendorGroupId(Long vendorGroupId) {
		this.vendorGroupId = vendorGroupId;
	}

	public String getVendorGroup() {
		return this.vendorGroup;
	}

	public void setVendorGroup(String vendorGroup) {
		this.vendorGroup = vendorGroup;
	}

	public Long getAccSchemaId() {
		return this.accSchemaId;
	}

	public void setAccSchemaId(Long accSchemaId) {
		this.accSchemaId = accSchemaId;
	}

	public String getAccSchema() {
		return this.accSchema;
	}

	public void setAccSchema(String accSchema) {
		this.accSchema = accSchema;
	}

	public Long getPurchaseAccountId() {
		return this.purchaseAccountId;
	}

	public void setPurchaseAccountId(Long purchaseAccountId) {
		this.purchaseAccountId = purchaseAccountId;
	}

	public String getPurchaseAccount() {
		return this.purchaseAccount;
	}

	public void setPurchaseAccount(String purchaseAccount) {
		this.purchaseAccount = purchaseAccount;
	}

	public String getPurchaseAccountName() {
		return this.purchaseAccountName;
	}

	public void setPurchaseAccountName(String purchaseAccountName) {
		this.purchaseAccountName = purchaseAccountName;
	}

	public Long getPrepayAccountId() {
		return this.prepayAccountId;
	}

	public void setPrepayAccountId(Long prepayAccountId) {
		this.prepayAccountId = prepayAccountId;
	}

	public String getPrepayAccount() {
		return this.prepayAccount;
	}

	public void setPrepayAccount(String prepayAccount) {
		this.prepayAccount = prepayAccount;
	}

	public String getPrepayAccountName() {
		return this.prepayAccountName;
	}

	public void setPrepayAccountName(String prepayAccountName) {
		this.prepayAccountName = prepayAccountName;
	}
}
