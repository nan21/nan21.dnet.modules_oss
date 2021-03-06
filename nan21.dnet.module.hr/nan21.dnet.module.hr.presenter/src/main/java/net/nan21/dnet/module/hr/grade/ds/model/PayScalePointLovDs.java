/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.grade.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableLov;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScalePoint;

@Ds(entity = PayScalePoint.class, sort = {@SortField(field = PayScalePointLovDs.f_name)})
public class PayScalePointLovDs extends AbstractAuditableLov<PayScalePoint> {

	public static final String f_name = "name";
	public static final String f_payScaleId = "payScaleId";

	@DsField(path = "code")
	private String name;

	@DsField(join = "left", path = "payScale.id")
	private Long payScaleId;

	public PayScalePointLovDs() {
		super();
	}

	public PayScalePointLovDs(PayScalePoint e) {
		super(e);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPayScaleId() {
		return this.payScaleId;
	}

	public void setPayScaleId(Long payScaleId) {
		this.payScaleId = payScaleId;
	}
}
