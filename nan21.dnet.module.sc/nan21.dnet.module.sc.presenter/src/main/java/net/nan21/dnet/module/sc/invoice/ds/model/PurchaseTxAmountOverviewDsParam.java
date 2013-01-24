/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.model;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class PurchaseTxAmountOverviewDsParam extends EmptyParam {

	public static final String f_overDue = "overDue";

	private Boolean overDue;

	public Boolean getOverDue() {
		return this.overDue;
	}

	public void setOverDue(Boolean overDue) {
		this.overDue = overDue;
	}
}
