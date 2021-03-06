/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;

@Ds(entity = PayrollElement.class, jpqlWhere = " e.balance = true ", sort = {@SortField(field = PayrollElementBalanceLovDs.f_code)})
public class PayrollElementBalanceLovDs
		extends
			AbstractTypeWithCodeLov<PayrollElement> {

	public static final String f_engineId = "engineId";
	public static final String f_engine = "engine";

	@DsField(join = "left", path = "engine.id")
	private Long engineId;

	@DsField(join = "left", path = "engine.name")
	private String engine;

	public PayrollElementBalanceLovDs() {
		super();
	}

	public PayrollElementBalanceLovDs(PayrollElement e) {
		super(e);
	}

	public Long getEngineId() {
		return this.engineId;
	}

	public void setEngineId(Long engineId) {
		this.engineId = engineId;
	}

	public String getEngine() {
		return this.engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}
}
