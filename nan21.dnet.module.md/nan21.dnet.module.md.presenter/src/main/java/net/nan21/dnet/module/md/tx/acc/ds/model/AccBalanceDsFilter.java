/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.acc.ds.model;
import net.nan21.dnet.module.md.tx.acc.ds.model.AccBalanceDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class AccBalanceDsFilter extends AccBalanceDs {

	private Float amount_From;

	private Float amount_To;

	private Float initialAmount_From;

	private Float initialAmount_To;

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

	public Float getInitialAmount_From() {
		return this.initialAmount_From;
	}

	public Float getInitialAmount_To() {
		return this.initialAmount_To;
	}

	public void setInitialAmount_From(Float initialAmount_From) {
		this.initialAmount_From = initialAmount_From;
	}

	public void setInitialAmount_To(Float initialAmount_To) {
		this.initialAmount_To = initialAmount_To;
	}
}
