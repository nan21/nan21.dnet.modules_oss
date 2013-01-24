/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
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
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroupAcct;

@Ds(entity = CustomerGroupAcct.class)
@RefLookups({
		@RefLookup(refId = CustomerGroupAcctDs.f_custGroupId, namedQuery = CustomerGroup.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = CustomerGroupAcctDs.f_custGroup)}),
		@RefLookup(refId = CustomerGroupAcctDs.f_salesAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = CustomerGroupAcctDs.f_salesAccount)}),
		@RefLookup(refId = CustomerGroupAcctDs.f_prepayAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = CustomerGroupAcctDs.f_prepayAccount)}),
		@RefLookup(refId = CustomerGroupAcctDs.f_accSchemaId, namedQuery = AccSchema.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = CustomerGroupAcctDs.f_accSchema)})})
public class CustomerGroupAcctDs extends AbstractAuditableDs<CustomerGroupAcct> {

	public static final String f_custGroupId = "custGroupId";
	public static final String f_custGroup = "custGroup";
	public static final String f_accSchemaId = "accSchemaId";
	public static final String f_accSchema = "accSchema";
	public static final String f_salesAccountId = "salesAccountId";
	public static final String f_salesAccount = "salesAccount";
	public static final String f_salesAccountName = "salesAccountName";
	public static final String f_prepayAccountId = "prepayAccountId";
	public static final String f_prepayAccount = "prepayAccount";
	public static final String f_prepayAccountName = "prepayAccountName";

	@DsField(join = "left", path = "custGroup.id")
	private Long custGroupId;

	@DsField(join = "left", path = "custGroup.code")
	private String custGroup;

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

	@DsField(join = "left", path = "prepayAccount.id")
	private Long prepayAccountId;

	@DsField(join = "left", path = "prepayAccount.code")
	private String prepayAccount;

	@DsField(join = "left", path = "prepayAccount.name")
	private String prepayAccountName;

	public CustomerGroupAcctDs() {
		super();
	}

	public CustomerGroupAcctDs(CustomerGroupAcct e) {
		super(e);
	}

	public Long getCustGroupId() {
		return this.custGroupId;
	}

	public void setCustGroupId(Long custGroupId) {
		this.custGroupId = custGroupId;
	}

	public String getCustGroup() {
		return this.custGroup;
	}

	public void setCustGroup(String custGroup) {
		this.custGroup = custGroup;
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
