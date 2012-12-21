/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class ProjectVersionDsParam extends EmptyParam {

	public static final String f_hideReleased = "hideReleased";
	public static final String f_hideDue = "hideDue";

	private Boolean hideReleased;

	private Boolean hideDue;

	public Boolean getHideReleased() {
		return this.hideReleased;
	}

	public void setHideReleased(Boolean hideReleased) {
		this.hideReleased = hideReleased;
	}

	public Boolean getHideDue() {
		return this.hideDue;
	}

	public void setHideDue(Boolean hideDue) {
		this.hideDue = hideDue;
	}
}
