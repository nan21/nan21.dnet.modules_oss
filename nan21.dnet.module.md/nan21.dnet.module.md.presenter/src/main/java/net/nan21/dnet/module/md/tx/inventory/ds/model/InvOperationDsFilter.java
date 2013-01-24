/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.inventory.ds.model;
import java.util.Date;
import net.nan21.dnet.module.md.tx.inventory.ds.model.InvOperationDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class InvOperationDsFilter extends InvOperationDs {

	private Date eventDate_From;

	private Date eventDate_To;

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
