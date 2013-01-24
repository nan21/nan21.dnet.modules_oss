/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.payroll.ds.model;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class PayrollElementValueDsParam extends EmptyParam {

	public static final String f_elementSetId = "elementSetId";
	public static final String f_elementSet = "elementSet";

	private Long elementSetId;

	private String elementSet;

	public Long getElementSetId() {
		return this.elementSetId;
	}

	public void setElementSetId(Long elementSetId) {
		this.elementSetId = elementSetId;
	}

	public String getElementSet() {
		return this.elementSet;
	}

	public void setElementSet(String elementSet) {
		this.elementSet = elementSet;
	}
}
