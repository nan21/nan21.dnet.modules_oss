/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountAcct;

@Ds(entity = FinancialAccountAcct.class)
@RefLookups({
		@RefLookup(refId = FinancialAccountAcctDs.f_financialAccountId, namedQuery = FinancialAccount.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = FinancialAccountAcctDs.f_financialAccount)}),
		@RefLookup(refId = FinancialAccountAcctDs.f_accSchemaId, namedQuery = AccSchema.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = FinancialAccountAcctDs.f_accSchema)}),
		@RefLookup(refId = FinancialAccountAcctDs.f_depositAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = FinancialAccountAcctDs.f_depositAccount)}),
		@RefLookup(refId = FinancialAccountAcctDs.f_withdrawalAccountId, namedQuery = Account.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = FinancialAccountAcctDs.f_withdrawalAccount)})})
public class FinancialAccountAcctDs
		extends
			AbstractAuditableDs<FinancialAccountAcct> {

	public static final String f_financialAccountId = "financialAccountId";
	public static final String f_financialAccount = "financialAccount";
	public static final String f_accSchemaId = "accSchemaId";
	public static final String f_accSchema = "accSchema";
	public static final String f_depositAccountId = "depositAccountId";
	public static final String f_depositAccount = "depositAccount";
	public static final String f_depositAccountName = "depositAccountName";
	public static final String f_withdrawalAccountId = "withdrawalAccountId";
	public static final String f_withdrawalAccount = "withdrawalAccount";
	public static final String f_withdrawalAccountName = "withdrawalAccountName";

	@DsField(join = "left", path = "financialAccount.id")
	private Long financialAccountId;

	@DsField(join = "left", path = "financialAccount.name")
	private String financialAccount;

	@DsField(join = "left", path = "accSchema.id")
	private Long accSchemaId;

	@DsField(join = "left", path = "accSchema.code")
	private String accSchema;

	@DsField(join = "left", path = "depositAccount.id")
	private Long depositAccountId;

	@DsField(join = "left", path = "depositAccount.code")
	private String depositAccount;

	@DsField(noInsert = true, noUpdate = true, join = "left", path = "depositAccount.name")
	private String depositAccountName;

	@DsField(join = "left", path = "withdrawalAccount.id")
	private Long withdrawalAccountId;

	@DsField(join = "left", path = "withdrawalAccount.code")
	private String withdrawalAccount;

	@DsField(noInsert = true, noUpdate = true, join = "left", path = "withdrawalAccount.name")
	private String withdrawalAccountName;

	public FinancialAccountAcctDs() {
		super();
	}

	public FinancialAccountAcctDs(FinancialAccountAcct e) {
		super(e);
	}

	public Long getFinancialAccountId() {
		return this.financialAccountId;
	}

	public void setFinancialAccountId(Long financialAccountId) {
		this.financialAccountId = financialAccountId;
	}

	public String getFinancialAccount() {
		return this.financialAccount;
	}

	public void setFinancialAccount(String financialAccount) {
		this.financialAccount = financialAccount;
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

	public Long getDepositAccountId() {
		return this.depositAccountId;
	}

	public void setDepositAccountId(Long depositAccountId) {
		this.depositAccountId = depositAccountId;
	}

	public String getDepositAccount() {
		return this.depositAccount;
	}

	public void setDepositAccount(String depositAccount) {
		this.depositAccount = depositAccount;
	}

	public String getDepositAccountName() {
		return this.depositAccountName;
	}

	public void setDepositAccountName(String depositAccountName) {
		this.depositAccountName = depositAccountName;
	}

	public Long getWithdrawalAccountId() {
		return this.withdrawalAccountId;
	}

	public void setWithdrawalAccountId(Long withdrawalAccountId) {
		this.withdrawalAccountId = withdrawalAccountId;
	}

	public String getWithdrawalAccount() {
		return this.withdrawalAccount;
	}

	public void setWithdrawalAccount(String withdrawalAccount) {
		this.withdrawalAccount = withdrawalAccount;
	}

	public String getWithdrawalAccountName() {
		return this.withdrawalAccountName;
	}

	public void setWithdrawalAccountName(String withdrawalAccountName) {
		this.withdrawalAccountName = withdrawalAccountName;
	}
}
