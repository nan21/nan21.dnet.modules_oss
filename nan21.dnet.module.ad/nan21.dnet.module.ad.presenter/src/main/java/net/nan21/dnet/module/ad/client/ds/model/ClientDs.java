/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.client.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.X_AbstractAuditedDs;
import net.nan21.dnet.module.ad.client.domain.entity.Client;

@Ds(entity = Client.class)
public class ClientDs extends X_AbstractAuditedDs<Client> {

	public static final String f_name = "name";
	public static final String f_code = "code";
	public static final String f_notes = "notes";
	public static final String f_maintenanceLanguage = "maintenanceLanguage";
	public static final String f_defaultImportPath = "defaultImportPath";
	public static final String f_defaultExportPath = "defaultExportPath";
	public static final String f_tempPath = "tempPath";
	public static final String f_systemClient = "systemClient";
	public static final String f_defaultDsAccessRule = "defaultDsAccessRule";
	public static final String f_adminRole = "adminRole";

	@DsField
	private String name;

	@DsField
	private String code;

	@DsField
	private String notes;

	@DsField
	private String maintenanceLanguage;

	@DsField
	private String defaultImportPath;

	@DsField
	private String defaultExportPath;

	@DsField
	private String tempPath;

	@DsField
	private Boolean systemClient;

	@DsField
	private String defaultDsAccessRule;

	@DsField
	private String adminRole;

	public ClientDs() {
		super();
	}

	public ClientDs(Client e) {
		super(e);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getMaintenanceLanguage() {
		return this.maintenanceLanguage;
	}

	public void setMaintenanceLanguage(String maintenanceLanguage) {
		this.maintenanceLanguage = maintenanceLanguage;
	}

	public String getDefaultImportPath() {
		return this.defaultImportPath;
	}

	public void setDefaultImportPath(String defaultImportPath) {
		this.defaultImportPath = defaultImportPath;
	}

	public String getDefaultExportPath() {
		return this.defaultExportPath;
	}

	public void setDefaultExportPath(String defaultExportPath) {
		this.defaultExportPath = defaultExportPath;
	}

	public String getTempPath() {
		return this.tempPath;
	}

	public void setTempPath(String tempPath) {
		this.tempPath = tempPath;
	}

	public Boolean getSystemClient() {
		return this.systemClient;
	}

	public void setSystemClient(Boolean systemClient) {
		this.systemClient = systemClient;
	}

	public String getDefaultDsAccessRule() {
		return this.defaultDsAccessRule;
	}

	public void setDefaultDsAccessRule(String defaultDsAccessRule) {
		this.defaultDsAccessRule = defaultDsAccessRule;
	}

	public String getAdminRole() {
		return this.adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}
}
