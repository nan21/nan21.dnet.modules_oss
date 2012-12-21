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
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.md.bp.domain.entity.Bank;
import net.nan21.dnet.module.md.bp.domain.entity.BpBankAccount;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

@Ds(entity = BpBankAccount.class)
@RefLookups({
		@RefLookup(refId = BpBankAccountDs.f_currencyId, namedQuery = Currency.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = BpBankAccountDs.f_currencyCode)}),
		@RefLookup(refId = BpBankAccountDs.f_bankId, namedQuery = Bank.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = BpBankAccountDs.f_bankCode)}),
		@RefLookup(refId = BpBankAccountDs.f_bpartnerId, namedQuery = BusinessPartner.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = BpBankAccountDs.f_bpartnerCode)})})
public class BpBankAccountDs extends AbstractAuditableDs<BpBankAccount> {

	public static final String f_bpartnerId = "bpartnerId";
	public static final String f_bpartnerCode = "bpartnerCode";
	public static final String f_bankId = "bankId";
	public static final String f_bankCode = "bankCode";
	public static final String f_bankBranch = "bankBranch";
	public static final String f_accountNo = "accountNo";
	public static final String f_ibanAccount = "ibanAccount";
	public static final String f_active = "active";
	public static final String f_notes = "notes";
	public static final String f_currencyId = "currencyId";
	public static final String f_currencyCode = "currencyCode";

	@DsField(join = "left", path = "bpartner.id")
	private Long bpartnerId;

	@DsField(join = "left", path = "bpartner.code")
	private String bpartnerCode;

	@DsField(join = "left", path = "bank.id")
	private Long bankId;

	@DsField(join = "left", path = "bank.code")
	private String bankCode;

	@DsField
	private String bankBranch;

	@DsField
	private String accountNo;

	@DsField
	private Boolean ibanAccount;

	@DsField
	private Boolean active;

	@DsField
	private String notes;

	@DsField(join = "left", path = "currency.id")
	private Long currencyId;

	@DsField(join = "left", path = "currency.code")
	private String currencyCode;

	public BpBankAccountDs() {
		super();
	}

	public BpBankAccountDs(BpBankAccount e) {
		super(e);
	}

	public Long getBpartnerId() {
		return this.bpartnerId;
	}

	public void setBpartnerId(Long bpartnerId) {
		this.bpartnerId = bpartnerId;
	}

	public String getBpartnerCode() {
		return this.bpartnerCode;
	}

	public void setBpartnerCode(String bpartnerCode) {
		this.bpartnerCode = bpartnerCode;
	}

	public Long getBankId() {
		return this.bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankBranch() {
		return this.bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Boolean getIbanAccount() {
		return this.ibanAccount;
	}

	public void setIbanAccount(Boolean ibanAccount) {
		this.ibanAccount = ibanAccount;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Long getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
}
