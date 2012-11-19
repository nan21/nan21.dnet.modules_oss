/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountAcct;

@Ds(entity = FinancialAccountAcct.class)
public class FinancialAccountAcctDs
		extends
			AbstractAuditableDs<FinancialAccountAcct> {

	public static final String fFINANCIALACCOUNTID = "financialAccountId";
	public static final String fFINANCIALACCOUNT = "financialAccount";
	public static final String fACCSCHEMAID = "accSchemaId";
	public static final String fACCSCHEMA = "accSchema";
	public static final String fDEPOSITACCOUNTID = "depositAccountId";
	public static final String fDEPOSITACCOUNT = "depositAccount";
	public static final String fDEPOSITACCOUNTNAME = "depositAccountName";
	public static final String fWITHDRAWALACCOUNTID = "withdrawalAccountId";
	public static final String fWITHDRAWALACCOUNT = "withdrawalAccount";
	public static final String fWITHDRAWALACCOUNTNAME = "withdrawalAccountName";

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
