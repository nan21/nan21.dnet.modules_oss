/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.model;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class PurchaseInvoiceDsParam extends EmptyParam {

	public static final String fCOPYFROMID = "copyFromId";
	public static final String fCOPYFROM = "copyFrom";

	private Long copyFromId;

	private String copyFrom;

	public Long getCopyFromId() {
		return this.copyFromId;
	}

	public void setCopyFromId(Long copyFromId) {
		this.copyFromId = copyFromId;
	}

	public String getCopyFrom() {
		return this.copyFrom;
	}

	public void setCopyFrom(String copyFrom) {
		this.copyFrom = copyFrom;
	}
}
