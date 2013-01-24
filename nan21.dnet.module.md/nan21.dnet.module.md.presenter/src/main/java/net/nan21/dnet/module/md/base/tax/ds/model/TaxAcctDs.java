/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.base.tax.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.base.tax.domain.entity.TaxAcct;

@Ds(entity = TaxAcct.class)
@RefLookups({
		@RefLookup(refId = TaxAcctDs.f_taxId, namedQuery = Tax.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = TaxAcctDs.f_tax)}),
		@RefLookup(refId = TaxAcctDs.f_accSchemaId, namedQuery = AccSchema.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = TaxAcctDs.f_accSchema)}),
		@RefLookup(refId = TaxAcctDs.f_salesAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = TaxAcctDs.f_salesAccount)}),
		@RefLookup(refId = TaxAcctDs.f_purchaseAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = TaxAcctDs.f_purchaseAccount)})})
public class TaxAcctDs extends AbstractAuditableDs<TaxAcct> {

	public static final String f_taxId = "taxId";
	public static final String f_tax = "tax";
	public static final String f_accSchemaId = "accSchemaId";
	public static final String f_accSchema = "accSchema";
	public static final String f_salesAccountId = "salesAccountId";
	public static final String f_salesAccount = "salesAccount";
	public static final String f_salesAccountName = "salesAccountName";
	public static final String f_purchaseAccountId = "purchaseAccountId";
	public static final String f_purchaseAccount = "purchaseAccount";
	public static final String f_purchaseAccountName = "purchaseAccountName";
	public static final String f_nonDeductAccountId = "nonDeductAccountId";
	public static final String f_nonDeductAccount = "nonDeductAccount";
	public static final String f_nonDeductAccountName = "nonDeductAccountName";

	@DsField(join = "left", path = "tax.id")
	private Long taxId;

	@DsField(join = "left", path = "tax.name")
	private String tax;

	@DsField(join = "left", path = "accSchema.id")
	private Long accSchemaId;

	@DsField(join = "left", path = "accSchema.code")
	private String accSchema;

	@DsField(join = "left", path = "salesAccount.id")
	private Long salesAccountId;

	@DsField(join = "left", path = "salesAccount.code")
	private String salesAccount;

	@DsField(join = "left", path = "salesAccount.name")
	private String salesAccountName;

	@DsField(join = "left", path = "purchaseAccount.id")
	private Long purchaseAccountId;

	@DsField(join = "left", path = "purchaseAccount.code")
	private String purchaseAccount;

	@DsField(join = "left", path = "purchaseAccount.name")
	private String purchaseAccountName;

	@DsField(join = "left", path = "nonDeductAccount.id")
	private Long nonDeductAccountId;

	@DsField(join = "left", path = "nonDeductAccount.code")
	private String nonDeductAccount;

	@DsField(join = "left", path = "nonDeductAccount.name")
	private String nonDeductAccountName;

	public TaxAcctDs() {
		super();
	}

	public TaxAcctDs(TaxAcct e) {
		super(e);
	}

	public Long getTaxId() {
		return this.taxId;
	}

	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}

	public String getTax() {
		return this.tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
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

	public Long getSalesAccountId() {
		return this.salesAccountId;
	}

	public void setSalesAccountId(Long salesAccountId) {
		this.salesAccountId = salesAccountId;
	}

	public String getSalesAccount() {
		return this.salesAccount;
	}

	public void setSalesAccount(String salesAccount) {
		this.salesAccount = salesAccount;
	}

	public String getSalesAccountName() {
		return this.salesAccountName;
	}

	public void setSalesAccountName(String salesAccountName) {
		this.salesAccountName = salesAccountName;
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

	public Long getNonDeductAccountId() {
		return this.nonDeductAccountId;
	}

	public void setNonDeductAccountId(Long nonDeductAccountId) {
		this.nonDeductAccountId = nonDeductAccountId;
	}

	public String getNonDeductAccount() {
		return this.nonDeductAccount;
	}

	public void setNonDeductAccount(String nonDeductAccount) {
		this.nonDeductAccount = nonDeductAccount;
	}

	public String getNonDeductAccountName() {
		return this.nonDeductAccountName;
	}

	public void setNonDeductAccountName(String nonDeductAccountName) {
		this.nonDeductAccountName = nonDeductAccountName;
	}
}
