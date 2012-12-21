/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class AccessControlDsParam extends EmptyParam {

	public static final String f_withRoleId = "withRoleId";
	public static final String f_withRole = "withRole";
	public static final String f_copyFromId = "copyFromId";
	public static final String f_copyFrom = "copyFrom";
	public static final String f_resetRules = "resetRules";
	public static final String f_skipDs = "skipDs";
	public static final String f_skipAsgn = "skipAsgn";

	private Long withRoleId;

	private String withRole;

	private Long copyFromId;

	private String copyFrom;

	private Boolean resetRules;

	private Boolean skipDs;

	private Boolean skipAsgn;

	public Long getWithRoleId() {
		return this.withRoleId;
	}

	public void setWithRoleId(Long withRoleId) {
		this.withRoleId = withRoleId;
	}

	public String getWithRole() {
		return this.withRole;
	}

	public void setWithRole(String withRole) {
		this.withRole = withRole;
	}

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

	public Boolean getResetRules() {
		return this.resetRules;
	}

	public void setResetRules(Boolean resetRules) {
		this.resetRules = resetRules;
	}

	public Boolean getSkipDs() {
		return this.skipDs;
	}

	public void setSkipDs(Boolean skipDs) {
		this.skipDs = skipDs;
	}

	public Boolean getSkipAsgn() {
		return this.skipAsgn;
	}

	public void setSkipAsgn(Boolean skipAsgn) {
		this.skipAsgn = skipAsgn;
	}
}
