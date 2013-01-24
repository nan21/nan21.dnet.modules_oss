/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.mm.prod.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroupAcct;

@Ds(entity = ProductAccountGroupAcct.class)
@RefLookups({
		@RefLookup(refId = ProductAccountGroupAcctDs.f_groupId, namedQuery = ProductAccountGroup.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductAccountGroupAcctDs.f_group)}),
		@RefLookup(refId = ProductAccountGroupAcctDs.f_accSchemaId, namedQuery = AccSchema.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductAccountGroupAcctDs.f_accSchema)}),
		@RefLookup(refId = ProductAccountGroupAcctDs.f_expenseAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductAccountGroupAcctDs.f_expenseAccount)}),
		@RefLookup(refId = ProductAccountGroupAcctDs.f_revenueAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductAccountGroupAcctDs.f_revenueAccount)})})
public class ProductAccountGroupAcctDs
		extends
			AbstractAuditableDs<ProductAccountGroupAcct> {

	public static final String f_groupId = "groupId";
	public static final String f_group = "group";
	public static final String f_accSchemaId = "accSchemaId";
	public static final String f_accSchema = "accSchema";
	public static final String f_expenseAccountId = "expenseAccountId";
	public static final String f_expenseAccount = "expenseAccount";
	public static final String f_expenseAccountName = "expenseAccountName";
	public static final String f_revenueAccountId = "revenueAccountId";
	public static final String f_revenueAccount = "revenueAccount";
	public static final String f_revenueAccountName = "revenueAccountName";

	@DsField(join = "left", path = "group.id")
	private Long groupId;

	@DsField(join = "left", path = "group.code")
	private String group;

	@DsField(join = "left", path = "accSchema.id")
	private Long accSchemaId;

	@DsField(join = "left", path = "accSchema.code")
	private String accSchema;

	@DsField(join = "left", path = "expenseAccount.id")
	private Long expenseAccountId;

	@DsField(join = "left", path = "expenseAccount.code")
	private String expenseAccount;

	@DsField(join = "left", path = "expenseAccount.name")
	private String expenseAccountName;

	@DsField(join = "left", path = "revenueAccount.id")
	private Long revenueAccountId;

	@DsField(join = "left", path = "revenueAccount.code")
	private String revenueAccount;

	@DsField(join = "left", path = "revenueAccount.name")
	private String revenueAccountName;

	public ProductAccountGroupAcctDs() {
		super();
	}

	public ProductAccountGroupAcctDs(ProductAccountGroupAcct e) {
		super(e);
	}

	public Long getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
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

	public Long getExpenseAccountId() {
		return this.expenseAccountId;
	}

	public void setExpenseAccountId(Long expenseAccountId) {
		this.expenseAccountId = expenseAccountId;
	}

	public String getExpenseAccount() {
		return this.expenseAccount;
	}

	public void setExpenseAccount(String expenseAccount) {
		this.expenseAccount = expenseAccount;
	}

	public String getExpenseAccountName() {
		return this.expenseAccountName;
	}

	public void setExpenseAccountName(String expenseAccountName) {
		this.expenseAccountName = expenseAccountName;
	}

	public Long getRevenueAccountId() {
		return this.revenueAccountId;
	}

	public void setRevenueAccountId(Long revenueAccountId) {
		this.revenueAccountId = revenueAccountId;
	}

	public String getRevenueAccount() {
		return this.revenueAccount;
	}

	public void setRevenueAccount(String revenueAccount) {
		this.revenueAccount = revenueAccount;
	}

	public String getRevenueAccountName() {
		return this.revenueAccountName;
	}

	public void setRevenueAccountName(String revenueAccountName) {
		this.revenueAccountName = revenueAccountName;
	}
}
