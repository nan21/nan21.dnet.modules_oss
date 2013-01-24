/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.model;
import java.util.Date;
import net.nan21.dnet.module.sd.order.ds.model.SalesDeliveryDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class SalesDeliveryDsFilter extends SalesDeliveryDs {

	private Date docDate_From;

	private Date docDate_To;

	private Date eventDate_From;

	private Date eventDate_To;

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

	public Date getEventDate_From() {
		return this.eventDate_From;
	}

	public Date getEventDate_To() {
		return this.eventDate_To;
	}

	public void setEventDate_From(Date eventDate_From) {
		this.eventDate_From = eventDate_From;
	}

	public void setEventDate_To(Date eventDate_To) {
		this.eventDate_To = eventDate_To;
	}
}
