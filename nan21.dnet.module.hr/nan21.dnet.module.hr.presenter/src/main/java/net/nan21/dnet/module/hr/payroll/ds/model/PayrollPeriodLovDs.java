/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

@Ds(entity = PayrollPeriod.class, jpqlWhere = "", sort = {@SortField(field = PayrollPeriodLovDs.f_startDate, desc = true)})
public class PayrollPeriodLovDs extends AbstractTypeLov<PayrollPeriod> {

	public static final String f_payrollId = "payrollId";
	public static final String f_active = "active";
	public static final String f_processed = "processed";
	public static final String f_closed = "closed";
	public static final String f_startDate = "startDate";

	@DsField(join = "left", path = "payroll.id")
	private Long payrollId;

	@DsField
	private Boolean active;

	@DsField
	private Boolean processed;

	@DsField
	private Boolean closed;

	@DsField
	private Date startDate;

	public PayrollPeriodLovDs() {
		super();
	}

	public PayrollPeriodLovDs(PayrollPeriod e) {
		super(e);
	}

	public Long getPayrollId() {
		return this.payrollId;
	}

	public void setPayrollId(Long payrollId) {
		this.payrollId = payrollId;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getProcessed() {
		return this.processed;
	}

	public void setProcessed(Boolean processed) {
		this.processed = processed;
	}

	public Boolean getClosed() {
		return this.closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
