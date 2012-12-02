/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.elem.ds.model;
import java.util.Date;
import net.nan21.dnet.module.bd.elem.ds.model.ElementFormulaDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class ElementFormulaDsFilter extends ElementFormulaDs {

	private Integer sequenceNo_From;

	private Integer sequenceNo_To;

	private Date validFrom_From;

	private Date validFrom_To;

	private Date validTo_From;

	private Date validTo_To;

	public Integer getSequenceNo_From() {
		return this.sequenceNo_From;
	}

	public Integer getSequenceNo_To() {
		return this.sequenceNo_To;
	}

	public void setSequenceNo_From(Integer sequenceNo_From) {
		this.sequenceNo_From = sequenceNo_From;
	}

	public void setSequenceNo_To(Integer sequenceNo_To) {
		this.sequenceNo_To = sequenceNo_To;
	}

	public Date getValidFrom_From() {
		return this.validFrom_From;
	}

	public Date getValidFrom_To() {
		return this.validFrom_To;
	}

	public void setValidFrom_From(Date validFrom_From) {
		this.validFrom_From = validFrom_From;
	}

	public void setValidFrom_To(Date validFrom_To) {
		this.validFrom_To = validFrom_To;
	}

	public Date getValidTo_From() {
		return this.validTo_From;
	}

	public Date getValidTo_To() {
		return this.validTo_To;
	}

	public void setValidTo_From(Date validTo_From) {
		this.validTo_From = validTo_From;
	}

	public void setValidTo_To(Date validTo_To) {
		this.validTo_To = validTo_To;
	}
}
