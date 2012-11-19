/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.account.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;

@Ds(entity = BpAccount.class, jpqlWhere = " e.vendor = true ")
public class VendorAccountDs extends AbstractAuditableDs<BpAccount> {

	public static final String fBUSINESSPARTNERID = "businessPartnerId";
	public static final String fBUSINESSPARTNERCODE = "businessPartnerCode";
	public static final String fBUSINESSPARTNERNAME = "businessPartnerName";
	public static final String fVENDOR = "vendor";
	public static final String fORGID = "orgId";
	public static final String fORG = "org";
	public static final String fVENDORGROUPID = "vendorGroupId";
	public static final String fVENDORGROUP = "vendorGroup";
	public static final String fPAYMENTMETHODID = "paymentMethodId";
	public static final String fPAYMENTMETHOD = "paymentMethod";
	public static final String fCREDITLIMIT = "creditLimit";
	public static final String fPAYMENTTERMID = "paymentTermId";
	public static final String fPAYMENTTERM = "paymentTerm";
	public static final String fANALITICSEGMENT = "analiticSegment";
	public static final String fVENDANALITICSEGMENT = "vendAnaliticSegment";

	@DsField(join = "left", path = "bpartner.id")
	private Long businessPartnerId;

	@DsField(join = "left", path = "bpartner.code")
	private String businessPartnerCode;

	@DsField(join = "left", path = "bpartner.name")
	private String businessPartnerName;

	@DsField()
	private Boolean vendor;

	@DsField(join = "left", path = "org.id")
	private Long orgId;

	@DsField(join = "left", path = "org.code")
	private String org;

	@DsField(join = "left", path = "vendGroup.id")
	private Long vendorGroupId;

	@DsField(join = "left", path = "vendGroup.code")
	private String vendorGroup;

	@DsField(join = "left", path = "vendPaymentMethod.id")
	private Long paymentMethodId;

	@DsField(join = "left", path = "vendPaymentMethod.name")
	private String paymentMethod;

	@DsField(path = "vendCreditLimit")
	private Float creditLimit;

	@DsField(join = "left", path = "vendPaymentTerm.id")
	private Long paymentTermId;

	@DsField(join = "left", path = "vendPaymentTerm.name")
	private String paymentTerm;

	@DsField()
	private String analiticSegment;

	@DsField()
	private String vendAnaliticSegment;

	public VendorAccountDs() {
		super();
	}

	public VendorAccountDs(BpAccount e) {
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

	public Boolean getVendor() {
		return this.vendor;
	}

	public void setVendor(Boolean vendor) {
		this.vendor = vendor;
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

	public Long getVendorGroupId() {
		return this.vendorGroupId;
	}

	public void setVendorGroupId(Long vendorGroupId) {
		this.vendorGroupId = vendorGroupId;
	}

	public String getVendorGroup() {
		return this.vendorGroup;
	}

	public void setVendorGroup(String vendorGroup) {
		this.vendorGroup = vendorGroup;
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

	public String getVendAnaliticSegment() {
		return this.vendAnaliticSegment;
	}

	public void setVendAnaliticSegment(String vendAnaliticSegment) {
		this.vendAnaliticSegment = vendAnaliticSegment;
	}
}
