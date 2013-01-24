/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.fin.ds.model;
import net.nan21.dnet.module.md.tx.fin.ds.model.TxBalanceDs;

/**
 * Helper filter object to run query by example with range values.
 *
 */
public class TxBalanceDsFilter extends TxBalanceDs {

	private Float amount_From;

	private Float amount_To;

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
