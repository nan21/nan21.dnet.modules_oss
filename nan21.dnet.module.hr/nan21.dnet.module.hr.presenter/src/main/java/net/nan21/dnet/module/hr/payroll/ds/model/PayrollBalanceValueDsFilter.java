/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.model;
import java.util.Date;
import net.nan21.dnet.module.hr.payroll.ds.model.PayrollBalanceValueDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class PayrollBalanceValueDsFilter extends PayrollBalanceValueDs {

	private Date periodStart_From;

	private Date periodStart_To;

	private Date periodEnd_From;

	private Date periodEnd_To;

	public Date getPeriodStart_From() {
		return this.periodStart_From;
	}

	public Date getPeriodStart_To() {
		return this.periodStart_To;
	}

	public void setPeriodStart_From(Date periodStart_From) {
		this.periodStart_From = periodStart_From;
	}

	public void setPeriodStart_To(Date periodStart_To) {
		this.periodStart_To = periodStart_To;
	}

	public Date getPeriodEnd_From() {
		return this.periodEnd_From;
	}

	public Date getPeriodEnd_To() {
		return this.periodEnd_To;
	}

	public void setPeriodEnd_From(Date periodEnd_From) {
		this.periodEnd_From = periodEnd_From;
	}

	public void setPeriodEnd_To(Date periodEnd_To) {
		this.periodEnd_To = periodEnd_To;
	}
}
