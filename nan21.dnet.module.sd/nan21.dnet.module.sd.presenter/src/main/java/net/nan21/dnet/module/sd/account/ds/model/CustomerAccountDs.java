/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.account.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.CustomerGroup;

@Ds(entity = BpAccount.class, jpqlWhere = " e.customer = true ")
@RefLookups({
		@RefLookup(refId = CustomerAccountDs.f_businessPartnerId, namedQuery = BusinessPartner.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = CustomerAccountDs.f_businessPartnerCode)}),
		@RefLookup(refId = CustomerAccountDs.f_orgId, namedQuery = Organization.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = CustomerAccountDs.f_org)}),
		@RefLookup(refId = CustomerAccountDs.f_customerGroupId, namedQuery = CustomerGroup.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = CustomerAccountDs.f_customerGroup)}),
		@RefLookup(refId = CustomerAccountDs.f_paymentMethodId, namedQuery = PaymentMethod.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = CustomerAccountDs.f_paymentMethod)}),
		@RefLookup(refId = CustomerAccountDs.f_paymentTermId, namedQuery = PaymentTerm.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = CustomerAccountDs.f_paymentTerm)})})
public class CustomerAccountDs extends AbstractAuditableDs<BpAccount> {

	public static final String f_businessPartnerId = "businessPartnerId";
	public static final String f_businessPartnerCode = "businessPartnerCode";
	public static final String f_businessPartnerName = "businessPartnerName";
	public static final String f_customer = "customer";
	public static final String f_orgId = "orgId";
	public static final String f_org = "org";
	public static final String f_customerGroupId = "customerGroupId";
	public static final String f_customerGroup = "customerGroup";
	public static final String f_paymentMethodId = "paymentMethodId";
	public static final String f_paymentMethod = "paymentMethod";
	public static final String f_creditLimit = "creditLimit";
	public static final String f_paymentTermId = "paymentTermId";
	public static final String f_paymentTerm = "paymentTerm";
	public static final String f_analiticSegment = "analiticSegment";
	public static final String f_custAnaliticSegment = "custAnaliticSegment";

	@DsField(join = "left", path = "bpartner.id")
	private Long businessPartnerId;

	@DsField(join = "left", path = "bpartner.code")
	private String businessPartnerCode;

	@DsField(join = "left", path = "bpartner.name")
	private String businessPartnerName;

	@DsField
	private Boolean customer;

	@DsField(join = "left", path = "org.id")
	private Long orgId;

	@DsField(join = "left", path = "org.code")
	private String org;

	@DsField(join = "left", path = "custGroup.id")
	private Long customerGroupId;

	@DsField(join = "left", path = "custGroup.code")
	private String customerGroup;

	@DsField(join = "left", path = "custPaymentMethod.id")
	private Long paymentMethodId;

	@DsField(join = "left", path = "custPaymentMethod.name")
	private String paymentMethod;

	@DsField(path = "custCreditLimit")
	private Float creditLimit;

	@DsField(join = "left", path = "custPaymentTerm.id")
	private Long paymentTermId;

	@DsField(join = "left", path = "custPaymentTerm.name")
	private String paymentTerm;

	@DsField
	private String analiticSegment;

	@DsField
	private String custAnaliticSegment;

	public CustomerAccountDs() {
		super();
	}

	public CustomerAccountDs(BpAccount e) {
		super(e);
	}

	public Long getBusinessPartnerId() {
		return this.businessPartnerId;
	}

	public void setBusinessPartnerId(Long businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}

	public String getBusinessPartnerCode() {
		return this.businessPartnerCode;
	}

	public void setBusinessPartnerCode(String businessPartnerCode) {
		this.businessPartnerCode = businessPartnerCode;
	}

	public String getBusinessPartnerName() {
		return this.businessPartnerName;
	}

	public void setBusinessPartnerName(String businessPartnerName) {
		this.businessPartnerName = businessPartnerName;
	}

	public Boolean getCustomer() {
		return this.customer;
	}

	public void setCustomer(Boolean customer) {
		this.customer = customer;
	}

	public Long getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrg() {
		return this.org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public Long getCustomerGroupId() {
		return this.customerGroupId;
	}

	public void setCustomerGroupId(Long customerGroupId) {
		this.customerGroupId = customerGroupId;
	}

	public String getCustomerGroup() {
		return this.customerGroup;
	}

	public void setCustomerGroup(String customerGroup) {
		this.customerGroup = customerGroup;
	}

	public Long getPaymentMethodId() {
		return this.paymentMethodId;
	}

	public void setPaymentMethodId(Long paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Float getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(Float creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Long getPaymentTermId() {
		return this.paymentTermId;
	}

	public void setPaymentTermId(Long paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public String getPaymentTerm() {
		return this.paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public String getAnaliticSegment() {
		return this.analiticSegment;
	}

	public void setAnaliticSegment(String analiticSegment) {
		this.analiticSegment = analiticSegment;
	}

	public String getCustAnaliticSegment() {
		return this.custAnaliticSegment;
	}

	public void setCustAnaliticSegment(String custAnaliticSegment) {
		this.custAnaliticSegment = custAnaliticSegment;
	}
}
