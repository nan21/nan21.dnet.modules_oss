/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.bp.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableLov;
import net.nan21.dnet.module.md.bp.domain.entity.BpAccount;

@Ds(entity = BpAccount.class, jpqlWhere = " e.vendor = true ")
public class VendorLovDs extends AbstractAuditableLov<BpAccount> {

	public static final String f_bpartnerId = "bpartnerId";
	public static final String f_code = "code";
	public static final String f_name = "name";
	public static final String f_orgId = "orgId";
	public static final String f_org = "org";
	public static final String f_paymentMethodId = "paymentMethodId";
	public static final String f_paymentMethod = "paymentMethod";
	public static final String f_paymentTermId = "paymentTermId";
	public static final String f_paymentTerm = "paymentTerm";

	@DsField(join = "left", path = "bpartner.id")
	private Long bpartnerId;

	@DsField(join = "left", path = "bpartner.code")
	private String code;

	@DsField(join = "left", path = "bpartner.name")
	private String name;

	@DsField(join = "left", path = "org.id")
	private Long orgId;

	@DsField(join = "left", path = "org.code")
	private String org;

	@DsField(join = "left", path = "vendPaymentMethod.id")
	private Long paymentMethodId;

	@DsField(join = "left", path = "vendPaymentMethod.name")
	private String paymentMethod;

	@DsField(join = "left", path = "vendPaymentTerm.id")
	private Long paymentTermId;

	@DsField(join = "left", path = "vendPaymentTerm.name")
	private String paymentTerm;

	public VendorLovDs() {
		super();
	}

	public VendorLovDs(BpAccount e) {
		super(e);
	}

	public Long getBpartnerId() {
		return this.bpartnerId;
	}

	public void setBpartnerId(Long bpartnerId) {
		this.bpartnerId = bpartnerId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
}
