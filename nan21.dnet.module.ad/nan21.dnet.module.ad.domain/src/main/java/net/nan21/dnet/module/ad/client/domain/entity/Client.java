/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.client.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.model.IModelWithId;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = Client.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class Client implements IModelWithId, Serializable {

	public static final String TABLE_NAME = "AD_CLIENT";
	public static final String SEQUENCE_NAME = "AD_CLIENT_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	@Column(name = "CODE", length = 32)
	private String code;

	@Column(name = "NAME", length = 255)
	private String name;

	@Column(name = "NOTES", length = 4000)
	private String notes;

	@Column(name = "MAINTENANCELANGUAGE", length = 5)
	private String maintenanceLanguage;

	/** 
			Specify which is the default access rule if there is no explicit entry in ACL list.
			<BR> Possible values are:
			 <li> deny: by default deny access to data-source function if there is no explicit access defined in ACL.
			 <li> allow: by default allow access to data-source function if there is no explicit denial defined in ACL.
	 */
	@Column(name = "DEFAULTDSACCESSRULE", length = 32)
	private String defaultDsAccessRule;

	/** 
			Specify which is the administrator role. 
			Access rights are not checked for the users having this role granted so they have access to ALL of the functions.
	 */
	@Column(name = "ADMINROLE", length = 32)
	private String adminRole;

	@Column(name = "DEFAULTIMPORTPATH", length = 255)
	private String defaultImportPath;

	@Column(name = "DEFAULTEXPORTPATH", length = 255)
	private String defaultExportPath;

	@Column(name = "TEMPPATH", length = 255)
	private String tempPath;

	@Column(name = "DEFAULTUOMWEIGHT", length = 3)
	private String defaultUomWeight;

	@Column(name = "DEFAULTUOMVOLUME", length = 3)
	private String defaultUomVolume;

	@Column(name = "DEFAULTUOMLENGTH", length = 3)
	private String defaultUomLength;

	@Column(name = "DEFAULTCURRENCY", length = 3)
	private String defaultCurrency;

	@Column(name = "SYSTEMCLIENT", nullable = false)
	@NotNull
	private Boolean systemClient;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDAT", nullable = false)
	@NotNull
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIEDAT", nullable = false)
	@NotNull
	private Date modifiedAt;

	@Column(name = "CREATEDBY", nullable = false, length = 32)
	@NotBlank
	private String createdBy;

	@Column(name = "MODIFIEDBY", nullable = false, length = 32)
	@NotBlank
	private String modifiedBy;

	@Version
	@Column(name = "VERSION", nullable = false)
	@NotNull
	private Long version;

	@Column(name = "UUID", length = 36)
	private String uuid;

	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDefaultUomWeight() {
		return this.defaultUomWeight;
	}

	public void setDefaultUomWeight(String defaultUomWeight) {
		this.defaultUomWeight = defaultUomWeight;
	}

	public String getDefaultUomVolume() {
		return this.defaultUomVolume;
	}

	public void setDefaultUomVolume(String defaultUomVolume) {
		this.defaultUomVolume = defaultUomVolume;
	}

	public String getDefaultUomLength() {
		return this.defaultUomLength;
	}

	public void setDefaultUomLength(String defaultUomLength) {
		this.defaultUomLength = defaultUomLength;
	}

	public String getDefaultCurrency() {
		return this.defaultCurrency;
	}

	public void setDefaultCurrency(String defaultCurrency) {
		this.defaultCurrency = defaultCurrency;
	}

	public Boolean getSystemClient() {
		return this.systemClient;
	}

	public void setSystemClient(Boolean systemClient) {
		this.systemClient = systemClient;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return this.modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Transient
	public String getClassName() {
		return this.getClass().getCanonicalName();
	}

	public void setClassName(String className) {
	}

	public void aboutToInsert(DescriptorEvent event) {
		event.updateAttributeWithObject("createdAt", new Date());
		event.updateAttributeWithObject("modifiedAt", new Date());
		event.updateAttributeWithObject("createdBy", Session.user.get()
				.getUsername());
		event.updateAttributeWithObject("modifiedBy", Session.user.get()
				.getUsername());
		if (this.uuid == null || this.uuid.equals("")) {
			event.updateAttributeWithObject("uuid", UUID.randomUUID()
					.toString().toUpperCase());
		}

		if (this.getSystemClient() == null) {
			event.updateAttributeWithObject("systemClient", false);
		}
	}

	public void aboutToUpdate(DescriptorEvent event) {
		event.updateAttributeWithObject("modifiedAt", new Date());
		event.updateAttributeWithObject("modifiedBy", Session.user.get()
				.getUsername());
	}
}
