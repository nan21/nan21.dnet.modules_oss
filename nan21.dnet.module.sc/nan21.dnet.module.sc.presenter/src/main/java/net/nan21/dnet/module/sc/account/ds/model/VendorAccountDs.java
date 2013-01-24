/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.account.ds.model;

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
import net.nan21.dnet.module.md.bp.domain.entity.VendorGroup;

@Ds(entity = BpAccount.class, jpqlWhere = " e.vendor = true ")
@RefLookups({
		@RefLookup(refId = VendorAccountDs.f_businessPartnerId, namedQuery = BusinessPartner.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = VendorAccountDs.f_businessPartnerCode)}),
		@RefLookup(refId = VendorAccountDs.f_orgId, namedQuery = Organization.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = VendorAccountDs.f_org)}),
		@RefLookup(refId = VendorAccountDs.f_vendorGroupId, namedQuery = VendorGroup.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = VendorAccountDs.f_vendorGroup)}),
		@RefLookup(refId = VendorAccountDs.f_paymentMethodId, namedQuery = PaymentMethod.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = VendorAccountDs.f_paymentMethod)}),
		@RefLookup(refId = VendorAccountDs.f_paymentTermId, namedQuery = PaymentTerm.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = VendorAccountDs.f_paymentTerm)})})
public class VendorAccountDs extends AbstractAuditableDs<BpAccount> {

	public static final String f_businessPartnerId = "businessPartnerId";
	public static final String f_businessPartnerCode = "businessPartnerCode";
	public static final String f_businessPartnerName = "businessPartnerName";
	public static final String f_vendor = "vendor";
	public static final String f_orgId = "orgId";
	public static final String f_org = "org";
	public static final String f_vendorGroupId = "vendorGroupId";
	public static final String f_vendorGroup = "vendorGroup";
	public static final String f_paymentMethodId = "paymentMethodId";
	public static final String f_paymentMethod = "paymentMethod";
	public static final String f_creditLimit = "creditLimit";
	public static final String f_paymentTermId = "paymentTermId";
	public static final String f_paymentTerm = "paymentTerm";
	public static final String f_analiticSegment = "analiticSegment";
	public static final String f_vendAnaliticSegment = "vendAnaliticSegment";

	@DsField(join = "left", path = "bpartner.id")
	private Long businessPartnerId;

	@DsField(join = "left", path = "bpartner.code")
	private String businessPartnerCode;

	@DsField(join = "left", path = "bpartner.name")
	private String businessPartnerName;

	@DsField
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

	@DsField
	private String analiticSegment;

	@DsField
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
