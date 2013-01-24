/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.acc.ds.model;
import java.util.Date;
import net.nan21.dnet.module.md.tx.acc.ds.model.AccDocDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class AccDocDsFilter extends AccDocDs {

	private Date docDate_From;

	private Date docDate_To;

	private Float docAmount_From;

	private Float docAmount_To;

	private Float dbAmount_From;

	private Float dbAmount_To;

	private Float crAmount_From;

	private Float crAmount_To;

	private Float difference_From;

	private Float difference_To;

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

	public Float getDocAmount_From() {
		return this.docAmount_From;
	}

	public Float getDocAmount_To() {
		return this.docAmount_To;
	}

	public void setDocAmount_From(Float docAmount_From) {
		this.docAmount_From = docAmount_From;
	}

	public void setDocAmount_To(Float docAmount_To) {
		this.docAmount_To = docAmount_To;
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

	public Float getDifference_From() {
		return this.difference_From;
	}

	public Float getDifference_To() {
		return this.difference_To;
	}

	public void setDifference_From(Float difference_From) {
		this.difference_From = difference_From;
	}

	public void setDifference_To(Float difference_To) {
		this.difference_To = difference_To;
	}
}
