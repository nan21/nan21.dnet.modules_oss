/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.account.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class CustomerAccountDsFilter extends AbstractAuditableDsFilter {

	private Long businessPartnerId;

	private Long businessPartnerId_From;

	private Long businessPartnerId_To;

	private String businessPartnerCode;

	private String businessPartnerName;

	private Boolean customer;

	private Long orgId;

	private Long orgId_From;

	private Long orgId_To;

	private String org;

	private Long customerGroupId;

	private Long customerGroupId_From;

	private Long customerGroupId_To;

	private String customerGroup;

	private Long paymentMethodId;

	private Long paymentMethodId_From;

	private Long paymentMethodId_To;

	private String paymentMethod;

	private Float creditLimit;

	private Float creditLimit_From;

	private Float creditLimit_To;

	private Long paymentTermId;

	private Long paymentTermId_From;

	private Long paymentTermId_To;

	private String paymentTerm;

	private String analiticSegment;

	private String custAnaliticSegment;

	public Long getBusinessPartnerId() {
		return this.businessPartnerId;
	}

	public Long getBusinessPartnerId_From() {
		return this.businessPartnerId_From;
	}

	public Long getBusinessPartnerId_To() {
		return this.businessPartnerId_To;
	}

	public void setBusinessPartnerId(Long businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}

	public void setBusinessPartnerId_From(Long businessPartnerId_From) {
		this.businessPartnerId_From = businessPartnerId_From;
	}

	public void setBusinessPartnerId_To(Long businessPartnerId_To) {
		this.businessPartnerId_To = businessPartnerId_To;
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

	public Long getOrgId_From() {
		return this.orgId_From;
	}

	public Long getOrgId_To() {
		return this.orgId_To;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public void setOrgId_From(Long orgId_From) {
		this.orgId_From = orgId_From;
	}

	public void setOrgId_To(Long orgId_To) {
		this.orgId_To = orgId_To;
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

	public Long getCustomerGroupId_From() {
		return this.customerGroupId_From;
	}

	public Long getCustomerGroupId_To() {
		return this.customerGroupId_To;
	}

	public void setCustomerGroupId(Long customerGroupId) {
		this.customerGroupId = customerGroupId;
	}

	public void setCustomerGroupId_From(Long customerGroupId_From) {
		this.customerGroupId_From = customerGroupId_From;
	}

	public void setCustomerGroupId_To(Long customerGroupId_To) {
		this.customerGroupId_To = customerGroupId_To;
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

	public Long getPaymentMethodId_From() {
		return this.paymentMethodId_From;
	}

	public Long getPaymentMethodId_To() {
		return this.paymentMethodId_To;
	}

	public void setPaymentMethodId(Long paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public void setPaymentMethodId_From(Long paymentMethodId_From) {
		this.paymentMethodId_From = paymentMethodId_From;
	}

	public void setPaymentMethodId_To(Long paymentMethodId_To) {
		this.paymentMethodId_To = paymentMethodId_To;
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

	public Float getCreditLimit_From() {
		return this.creditLimit_From;
	}

	public Float getCreditLimit_To() {
		return this.creditLimit_To;
	}

	public void setCreditLimit(Float creditLimit) {
		this.creditLimit = creditLimit;
	}

	public void setCreditLimit_From(Float creditLimit_From) {
		this.creditLimit_From = creditLimit_From;
	}

	public void setCreditLimit_To(Float creditLimit_To) {
		this.creditLimit_To = creditLimit_To;
	}

	public Long getPaymentTermId() {
		return this.paymentTermId;
	}

	public Long getPaymentTermId_From() {
		return this.paymentTermId_From;
	}

	public Long getPaymentTermId_To() {
		return this.paymentTermId_To;
	}

	public void setPaymentTermId(Long paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public void setPaymentTermId_From(Long paymentTermId_From) {
		this.paymentTermId_From = paymentTermId_From;
	}

	public void setPaymentTermId_To(Long paymentTermId_To) {
		this.paymentTermId_To = paymentTermId_To;
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
