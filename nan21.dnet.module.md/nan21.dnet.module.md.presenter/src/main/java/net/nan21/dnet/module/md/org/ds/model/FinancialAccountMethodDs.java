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
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountMethod;

@Ds(entity = FinancialAccountMethod.class)
@RefLookups({
		@RefLookup(refId = FinancialAccountMethodDs.f_financialAccountId, namedQuery = FinancialAccount.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = FinancialAccountMethodDs.f_financialAccount)}),
		@RefLookup(refId = FinancialAccountMethodDs.f_payMethodId, namedQuery = PaymentMethod.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = FinancialAccountMethodDs.f_payMethod)})})
public class FinancialAccountMethodDs
		extends
			AbstractAuditableDs<FinancialAccountMethod> {

	public static final String f_financialAccountId = "financialAccountId";
	public static final String f_financialAccount = "financialAccount";
	public static final String f_financialAccountType = "financialAccountType";
	public static final String f_payMethodId = "payMethodId";
	public static final String f_payMethod = "payMethod";
	public static final String f_allowPayIn = "allowPayIn";
	public static final String f_allowPayOut = "allowPayOut";

	@DsField(join = "left", path = "financialAccount.id")
	private Long financialAccountId;

	@DsField(join = "left", path = "financialAccount.name")
	private String financialAccount;

	@DsField(join = "left", path = "financialAccount.type")
	private String financialAccountType;

	@DsField(join = "left", path = "payMethod.id")
	private Long payMethodId;

	@DsField(join = "left", path = "payMethod.name")
	private String payMethod;

	@DsField
	private Boolean allowPayIn;

	@DsField
	private Boolean allowPayOut;

	public FinancialAccountMethodDs() {
		super();
	}

	public FinancialAccountMethodDs(FinancialAccountMethod e) {
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

	public String getFinancialAccountType() {
		return this.financialAccountType;
	}

	public void setFinancialAccountType(String financialAccountType) {
		this.financialAccountType = financialAccountType;
	}

	public Long getPayMethodId() {
		return this.payMethodId;
	}

	public void setPayMethodId(Long payMethodId) {
		this.payMethodId = payMethodId;
	}

	public String getPayMethod() {
		return this.payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public Boolean getAllowPayIn() {
		return this.allowPayIn;
	}

	public void setAllowPayIn(Boolean allowPayIn) {
		this.allowPayIn = allowPayIn;
	}

	public Boolean getAllowPayOut() {
		return this.allowPayOut;
	}

	public void setAllowPayOut(Boolean allowPayOut) {
		this.allowPayOut = allowPayOut;
	}
}
