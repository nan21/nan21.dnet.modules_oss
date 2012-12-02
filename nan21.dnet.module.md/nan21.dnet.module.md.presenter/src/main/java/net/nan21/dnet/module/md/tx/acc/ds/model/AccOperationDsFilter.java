/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.acc.ds.model;
import java.util.Date;
import net.nan21.dnet.module.md.tx.acc.ds.model.AccOperationDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class AccOperationDsFilter extends AccOperationDs {

	private Date eventDate_From;

	private Date eventDate_To;

	private Float dbAmount_From;

	private Float dbAmount_To;

	private Float crAmount_From;

	private Float crAmount_To;

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

	public Float getDbAmount_From() {
		return this.dbAmount_From;
	}

	public Float getDbAmount_To() {
		return this.dbAmount_To;
	}

	public void setDbAmount_From(Float dbAmount_From) {
		this.dbAmount_From = dbAmount_From;
	}

	public void setDbAmount_To(Float dbAmount_To) {
		this.dbAmount_To = dbAmount_To;
	}

	public Float getCrAmount_From() {
		return this.crAmount_From;
	}

	public Float getCrAmount_To() {
		return this.crAmount_To;
	}

	public void setCrAmount_From(Float crAmount_From) {
		this.crAmount_From = crAmount_From;
	}

	public void setCrAmount_To(Float crAmount_To) {
		this.crAmount_To = crAmount_To;
	}
}
