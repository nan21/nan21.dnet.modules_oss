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
import net.nan21.dnet.module.md.bp.domain.entity.BpAccountAcct;

@Ds(entity = BpAccountAcct.class)
@RefLookups({
		@RefLookup(refId = BpAccountAcctDs.f_bpAccountId),
		@RefLookup(refId = BpAccountAcctDs.f_accSchemaId, namedQuery = AccSchema.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = BpAccountAcctDs.f_accSchema)}),
		@RefLookup(refId = BpAccountAcctDs.f_custSalesAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = BpAccountAcctDs.f_custSalesAccount)}),
		@RefLookup(refId = BpAccountAcctDs.f_custPrepayAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = BpAccountAcctDs.f_custPrepayAccount)}),
		@RefLookup(refId = BpAccountAcctDs.f_vendorPurchaseAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = BpAccountAcctDs.f_vendorPurchaseAccount)}),
		@RefLookup(refId = BpAccountAcctDs.f_vendorPrepayAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = BpAccountAcctDs.f_vendorPrepayAccount)})})
public class BpAccountAcctDs extends AbstractAuditableDs<BpAccountAcct> {

	public static final String f_bpAccountId = "bpAccountId";
	public static final String f_accSchemaId = "accSchemaId";
	public static final String f_accSchema = "accSchema";
	public static final String f_custSalesAccountId = "custSalesAccountId";
	public static final String f_custSalesAccount = "custSalesAccount";
	public static final String f_custPrepayAccountId = "custPrepayAccountId";
	public static final String f_custPrepayAccount = "custPrepayAccount";
	public static final String f_vendorPurchaseAccountId = "vendorPurchaseAccountId";
	public static final String f_vendorPurchaseAccount = "vendorPurchaseAccount";
	public static final String f_vendorPrepayAccountId = "vendorPrepayAccountId";
	public static final String f_vendorPrepayAccount = "vendorPrepayAccount";

	@DsField(join = "left", path = "bpAccount.id")
	private Long bpAccountId;

	@DsField(join = "left", path = "accSchema.id")
	private Long accSchemaId;

	@DsField(join = "left", path = "accSchema.code")
	private String accSchema;

	@DsField(join = "left", path = "custSalesAccount.id")
	private Long custSalesAccountId;

	@DsField(join = "left", path = "custSalesAccount.code")
	private String custSalesAccount;

	@DsField(join = "left", path = "custPrepayAccount.id")
	private Long custPrepayAccountId;

	@DsField(join = "left", path = "custPrepayAccount.code")
	private String custPrepayAccount;

	@DsField(join = "left", path = "vendorPurchaseAccount.id")
	private Long vendorPurchaseAccountId;

	@DsField(join = "left", path = "vendorPurchaseAccount.code")
	private String vendorPurchaseAccount;

	@DsField(join = "left", path = "vendorPrepayAccount.id")
	private Long vendorPrepayAccountId;

	@DsField(join = "left", path = "vendorPrepayAccount.code")
	private String vendorPrepayAccount;

	public BpAccountAcctDs() {
		super();
	}

	public BpAccountAcctDs(BpAccountAcct e) {
		super(e);
	}

	public Long getBpAccountId() {
		return this.bpAccountId;
	}

	public void setBpAccountId(Long bpAccountId) {
		this.bpAccountId = bpAccountId;
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

	public Long getCustSalesAccountId() {
		return this.custSalesAccountId;
	}

	public void setCustSalesAccountId(Long custSalesAccountId) {
		this.custSalesAccountId = custSalesAccountId;
	}

	public String getCustSalesAccount() {
		return this.custSalesAccount;
	}

	public void setCustSalesAccount(String custSalesAccount) {
		this.custSalesAccount = custSalesAccount;
	}

	public Long getCustPrepayAccountId() {
		return this.custPrepayAccountId;
	}

	public void setCustPrepayAccountId(Long custPrepayAccountId) {
		this.custPrepayAccountId = custPrepayAccountId;
	}

	public String getCustPrepayAccount() {
		return this.custPrepayAccount;
	}

	public void setCustPrepayAccount(String custPrepayAccount) {
		this.custPrepayAccount = custPrepayAccount;
	}

	public Long getVendorPurchaseAccountId() {
		return this.vendorPurchaseAccountId;
	}

	public void setVendorPurchaseAccountId(Long vendorPurchaseAccountId) {
		this.vendorPurchaseAccountId = vendorPurchaseAccountId;
	}

	public String getVendorPurchaseAccount() {
		return this.vendorPurchaseAccount;
	}

	public void setVendorPurchaseAccount(String vendorPurchaseAccount) {
		this.vendorPurchaseAccount = vendorPurchaseAccount;
	}

	public Long getVendorPrepayAccountId() {
		return this.vendorPrepayAccountId;
	}

	public void setVendorPrepayAccountId(Long vendorPrepayAccountId) {
		this.vendorPrepayAccountId = vendorPrepayAccountId;
	}

	public String getVendorPrepayAccount() {
		return this.vendorPrepayAccount;
	}

	public void setVendorPrepayAccount(String vendorPrepayAccount) {
		this.vendorPrepayAccount = vendorPrepayAccount;
	}
}
