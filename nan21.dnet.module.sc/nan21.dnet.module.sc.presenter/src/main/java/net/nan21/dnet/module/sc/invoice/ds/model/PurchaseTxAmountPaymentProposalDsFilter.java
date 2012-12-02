/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.model;
import java.util.Date;
import net.nan21.dnet.module.sc.invoice.ds.model.PurchaseTxAmountPaymentProposalDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class PurchaseTxAmountPaymentProposalDsFilter
		extends
			PurchaseTxAmountPaymentProposalDs {

	private Date dueDate_From;

	private Date dueDate_To;

	private Float dueAmount_From;

	private Float dueAmount_To;

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
}
