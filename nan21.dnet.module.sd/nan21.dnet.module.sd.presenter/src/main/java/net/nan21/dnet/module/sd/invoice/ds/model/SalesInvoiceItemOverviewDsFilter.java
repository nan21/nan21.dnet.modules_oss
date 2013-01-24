/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.model;
import java.util.Date;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemOverviewDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class SalesInvoiceItemOverviewDsFilter
		extends
			SalesInvoiceItemOverviewDs {

	private Date docDate_From;

	private Date docDate_To;

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
}
