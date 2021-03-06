/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.model;
import java.util.Date;
import net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class PurchaseInvoiceDsFilter extends PurchaseInvoiceDs {

	private Date docDate_From;

	private Date docDate_To;

	private Float totalNetAmount_From;

	private Float totalNetAmount_To;

	private Float totalAmount_From;

	private Float totalAmount_To;

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

	public Float getTotalNetAmount_From() {
		return this.totalNetAmount_From;
	}

	public Float getTotalNetAmount_To() {
		return this.totalNetAmount_To;
	}

	public void setTotalNetAmount_From(Float totalNetAmount_From) {
		this.totalNetAmount_From = totalNetAmount_From;
	}

	public void setTotalNetAmount_To(Float totalNetAmount_To) {
		this.totalNetAmount_To = totalNetAmount_To;
	}

	public Float getTotalAmount_From() {
		return this.totalAmount_From;
	}

	public Float getTotalAmount_To() {
		return this.totalAmount_To;
	}

	public void setTotalAmount_From(Float totalAmount_From) {
		this.totalAmount_From = totalAmount_From;
	}

	public void setTotalAmount_To(Float totalAmount_To) {
		this.totalAmount_To = totalAmount_To;
	}
}
