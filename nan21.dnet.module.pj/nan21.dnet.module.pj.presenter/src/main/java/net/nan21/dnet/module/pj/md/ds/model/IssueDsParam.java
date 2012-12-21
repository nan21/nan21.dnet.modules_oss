/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class IssueDsParam extends EmptyParam {

	public static final String f_affectedVersionId = "affectedVersionId";
	public static final String f_affectedVersion = "affectedVersion";
	public static final String f_affectedComponentId = "affectedComponentId";
	public static final String f_affectedComponent = "affectedComponent";

	private Long affectedVersionId;

	private String affectedVersion;

	private Long affectedComponentId;

	private String affectedComponent;

	public Long getAffectedVersionId() {
		return this.affectedVersionId;
	}

	public void setAffectedVersionId(Long affectedVersionId) {
		this.affectedVersionId = affectedVersionId;
	}

	public String getAffectedVersion() {
		return this.affectedVersion;
	}

	public void setAffectedVersion(String affectedVersion) {
		this.affectedVersion = affectedVersion;
	}

	public Long getAffectedComponentId() {
		return this.affectedComponentId;
	}

	public void setAffectedComponentId(Long affectedComponentId) {
		this.affectedComponentId = affectedComponentId;
	}

	public String getAffectedComponent() {
		return this.affectedComponent;
	}

	public void setAffectedComponent(String affectedComponent) {
		this.affectedComponent = affectedComponent;
	}
}
