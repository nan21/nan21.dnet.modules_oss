/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.model;
import java.util.Date;
import net.nan21.dnet.module.sd.invoice.ds.model.PaymentInDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class PaymentInDsFilter extends PaymentInDs {

	private Date docDate_From;

	private Date docDate_To;

	private Float amount_From;

	private Float amount_To;

	public Date getDocDate_From() {
		return this.docDate_From;
	}

	public Date getDocDate_To() {
		return this.docDate_To;
	}

	public void setDocDate_From(Date docDate_From) {
		this.docDate_From = docDate_From;
	}

	public void setDocDate_To(Date docDate_To) {
		this.docDate_To = docDate_To;
	}

	public Float getAmount_From() {
		return this.amount_From;
	}

	public Float getAmount_To() {
		return this.amount_To;
	}

	public void setAmount_From(Float amount_From) {
		this.amount_From = amount_From;
	}

	public void setAmount_To(Float amount_To) {
		this.amount_To = amount_To;
	}
}
