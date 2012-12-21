/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.model;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class ActTaskInstanceDsParam extends EmptyParam {

	public static final String f_hideActive = "hideActive";
	public static final String f_hideCompleted = "hideCompleted";

	private Boolean hideActive;

	private Boolean hideCompleted;

	public Boolean getHideActive() {
		return this.hideActive;
	}

	public void setHideActive(Boolean hideActive) {
		this.hideActive = hideActive;
	}

	public Boolean getHideCompleted() {
		return this.hideCompleted;
	}

	public void setHideCompleted(Boolean hideCompleted) {
		this.hideCompleted = hideCompleted;
	}
}
