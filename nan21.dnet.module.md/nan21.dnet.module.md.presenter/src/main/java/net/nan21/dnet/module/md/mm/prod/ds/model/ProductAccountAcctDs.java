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
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountAcct;

@Ds(entity = ProductAccountAcct.class)
@RefLookups({
		@RefLookup(refId = ProductAccountAcctDs.f_prodAccountId),
		@RefLookup(refId = ProductAccountAcctDs.f_accSchemaId, namedQuery = AccSchema.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductAccountAcctDs.f_accSchema)}),
		@RefLookup(refId = ProductAccountAcctDs.f_expenseAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductAccountAcctDs.f_expenseAccount)}),
		@RefLookup(refId = ProductAccountAcctDs.f_revenueAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProductAccountAcctDs.f_revenueAccount)})})
public class ProductAccountAcctDs
		extends
			AbstractAuditableDs<ProductAccountAcct> {

	public static final String f_prodAccountId = "prodAccountId";
	public static final String f_accSchemaId = "accSchemaId";
	public static final String f_accSchema = "accSchema";
	public static final String f_expenseAccountId = "expenseAccountId";
	public static final String f_expenseAccount = "expenseAccount";
	public static final String f_revenueAccountId = "revenueAccountId";
	public static final String f_revenueAccount = "revenueAccount";

	@DsField(join = "left", path = "prodAccount.id")
	private Long prodAccountId;

	@DsField(join = "left", path = "accSchema.id")
	private Long accSchemaId;

	@DsField(join = "left", path = "accSchema.code")
	private String accSchema;

	@DsField(join = "left", path = "expenseAccount.id")
	private Long expenseAccountId;

	@DsField(join = "left", path = "expenseAccount.code")
	private String expenseAccount;

	@DsField(join = "left", path = "revenueAccount.id")
	private Long revenueAccountId;

	@DsField(join = "left", path = "revenueAccount.code")
	private String revenueAccount;

	public ProductAccountAcctDs() {
		super();
	}

	public ProductAccountAcctDs(ProductAccountAcct e) {
		super(e);
	}

	public Long getProdAccountId() {
		return this.prodAccountId;
	}

	public void setProdAccountId(Long prodAccountId) {
		this.prodAccountId = prodAccountId;
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
}
