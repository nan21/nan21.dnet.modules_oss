/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

@Ds(entity = Payroll.class, sort = {@SortField(field = PayrollDs.f_name)})
@RefLookups({@RefLookup(refId = PayrollDs.f_engineId, namedQuery = Engine.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PayrollDs.f_engine)})})
public class PayrollDs extends AbstractTypeDs<Payroll> {

	public static final String f_engineId = "engineId";
	public static final String f_engine = "engine";
	public static final String f_periodType = "periodType";

	@DsField(join = "left", path = "engine.id")
	private Long engineId;

	@DsField(join = "left", path = "engine.name")
	private String engine;

	@DsField
	private String periodType;

	public PayrollDs() {
		super();
	}

	public PayrollDs(Payroll e) {
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

	public String getPeriodType() {
		return this.periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
}
