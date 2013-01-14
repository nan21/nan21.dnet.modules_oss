/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.client.ds.model;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class ClientDsParam extends EmptyParam {

	public static final String f_adminUserCode = "adminUserCode";
	public static final String f_adminUserName = "adminUserName";
	public static final String f_adminPassword = "adminPassword";
	public static final String f_importJobId = "importJobId";
	public static final String f_importJob = "importJob";

	private String adminUserCode;

	private String adminUserName;

	private String adminPassword;

	private Long importJobId;

	private String importJob;

	public String getAdminUserCode() {
		return this.adminUserCode;
	}

	public void setAdminUserCode(String adminUserCode) {
		this.adminUserCode = adminUserCode;
	}

	public String getAdminUserName() {
		return this.adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Long getImportJobId() {
		return this.importJobId;
	}

	public void setImportJobId(Long importJobId) {
		this.importJobId = importJobId;
	}

	public String getImportJob() {
		return this.importJob;
	}

	public void setImportJob(String importJob) {
		this.importJob = importJob;
	}
}
