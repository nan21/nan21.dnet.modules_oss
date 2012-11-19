/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.account.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;

@Ds(entity = BpAccount.class, jpqlWhere = " e.customer = true ")
public class CustomerAccountDs extends AbstractAuditableDs<BpAccount> {

	public static final String fBUSINESSPARTNERID = "businessPartnerId";
	public static final String fBUSINESSPARTNERCODE = "businessPartnerCode";
	public static final String fBUSINESSPARTNERNAME = "businessPartnerName";
	public static final String fCUSTOMER = "customer";
	public static final String fORGID = "orgId";
	public static final String fORG = "org";
	public static final String fCUSTOMERGROUPID = "customerGroupId";
	public static final String fCUSTOMERGROUP = "customerGroup";
	public static final String fPAYMENTMETHODID = "paymentMethodId";
	public static final String fPAYMENTMETHOD = "paymentMethod";
	public static final String fCREDITLIMIT = "creditLimit";
	public static final String fPAYMENTTERMID = "paymentTermId";
	public static final String fPAYMENTTERM = "paymentTerm";
	public static final String fANALITICSEGMENT = "analiticSegment";
	public static final String fCUSTANALITICSEGMENT = "custAnaliticSegment";

	@DsField(join = "left", path = "bpartner.id")
	private Long businessPartnerId;

	@DsField(join = "left", path = "bpartner.code")
	private String businessPartnerCode;

	@DsField(join = "left", path = "bpartner.name")
	private String businessPartnerName;

	@DsField()
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

	@DsField()
	private String analiticSegment;

	@DsField()
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
