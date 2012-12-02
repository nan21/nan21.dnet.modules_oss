/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.model;
import java.util.Date;
import net.nan21.dnet.module.sc.invoice.ds.model.PurchaseTxAmountOverviewDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class PurchaseTxAmountOverviewDsFilter
		extends
			PurchaseTxAmountOverviewDs {

	private Date dueDate_From;

	private Date dueDate_To;

	private Float dueAmount_From;

	private Float dueAmount_To;

	private Float payedAmount_From;

	private Float payedAmount_To;

	private Float outstandingAmount_From;

	private Float outstandingAmount_To;

	public Date getDueDate_From() {
		return this.dueDate_From;
	}

	public Date getDueDate_To() {
		return this.dueDate_To;
	}

	public void setDueDate_From(Date dueDate_From) {
		this.dueDate_From = dueDate_From;
	}

	public void setDueDate_To(Date dueDate_To) {
		this.dueDate_To = dueDate_To;
	}

	public Float getDueAmount_From() {
		return this.dueAmount_From;
	}

	public Float getDueAmount_To() {
		return this.dueAmount_To;
	}

	public void setDueAmount_From(Float dueAmount_From) {
		this.dueAmount_From = dueAmount_From;
	}

	public void setDueAmount_To(Float dueAmount_To) {
		this.dueAmount_To = dueAmount_To;
	}

	public Float getPayedAmount_From() {
		return this.payedAmount_From;
	}

	public Float getPayedAmount_To() {
		return this.payedAmount_To;
	}

	public void setPayedAmount_From(Float payedAmount_From) {
		this.payedAmount_From = payedAmount_From;
	}

	public void setPayedAmount_To(Float payedAmount_To) {
		this.payedAmount_To = payedAmount_To;
	}

	public Float getOutstandingAmount_From() {
		return this.outstandingAmount_From;
	}

	public Float getOutstandingAmount_To() {
		return this.outstandingAmount_To;
	}

	public void setOutstandingAmount_From(Float outstandingAmount_From) {
		this.outstandingAmount_From = outstandingAmount_From;
	}

	public void setOutstandingAmount_To(Float outstandingAmount_To) {
		this.outstandingAmount_To = outstandingAmount_To;
	}
}
