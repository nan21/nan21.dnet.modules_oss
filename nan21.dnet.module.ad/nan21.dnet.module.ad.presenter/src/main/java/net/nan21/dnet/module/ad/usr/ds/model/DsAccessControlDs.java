/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.DsAccessControl;

@Ds(entity = DsAccessControl.class, sort = {@SortField(field = DsAccessControlDs.f_dsName)})
@RefLookups({@RefLookup(refId = DsAccessControlDs.f_accessControlId, namedQuery = AccessControl.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = DsAccessControlDs.f_accessControl)})})
public class DsAccessControlDs extends AbstractAuditableDs<DsAccessControl> {

	public static final String f_dsName = "dsName";
	public static final String f_queryAllowed = "queryAllowed";
	public static final String f_insertAllowed = "insertAllowed";
	public static final String f_updateAllowed = "updateAllowed";
	public static final String f_deleteAllowed = "deleteAllowed";
	public static final String f_importAllowed = "importAllowed";
	public static final String f_exportAllowed = "exportAllowed";
	public static final String f_accessControlId = "accessControlId";
	public static final String f_accessControl = "accessControl";

	@DsField
	private String dsName;

	@DsField
	private Boolean queryAllowed;

	@DsField
	private Boolean insertAllowed;

	@DsField
	private Boolean updateAllowed;

	@DsField
	private Boolean deleteAllowed;

	@DsField
	private Boolean importAllowed;

	@DsField
	private Boolean exportAllowed;

	@DsField(join = "left", path = "accessControl.id")
	private Long accessControlId;

	@DsField(join = "left", path = "accessControl.name")
	private String accessControl;

	public DsAccessControlDs() {
		super();
	}

	public DsAccessControlDs(DsAccessControl e) {
		super(e);
	}

	public String getDsName() {
		return this.dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public Boolean getQueryAllowed() {
		return this.queryAllowed;
	}

	public void setQueryAllowed(Boolean queryAllowed) {
		this.queryAllowed = queryAllowed;
	}

	public Boolean getInsertAllowed() {
		return this.insertAllowed;
	}

	public void setInsertAllowed(Boolean insertAllowed) {
		this.insertAllowed = insertAllowed;
	}

	public Boolean getUpdateAllowed() {
		return this.updateAllowed;
	}

	public void setUpdateAllowed(Boolean updateAllowed) {
		this.updateAllowed = updateAllowed;
	}

	public Boolean getDeleteAllowed() {
		return this.deleteAllowed;
	}

	public void setDeleteAllowed(Boolean deleteAllowed) {
		this.deleteAllowed = deleteAllowed;
	}

	public Boolean getImportAllowed() {
		return this.importAllowed;
	}

	public void setImportAllowed(Boolean importAllowed) {
		this.importAllowed = importAllowed;
	}

	public Boolean getExportAllowed() {
		return this.exportAllowed;
	}

	public void setExportAllowed(Boolean exportAllowed) {
		this.exportAllowed = exportAllowed;
	}

	public Long getAccessControlId() {
		return this.accessControlId;
	}

	public void setAccessControlId(Long accessControlId) {
		this.accessControlId = accessControlId;
	}

	public String getAccessControl() {
		return this.accessControl;
	}

	public void setAccessControl(String accessControl) {
		this.accessControl = accessControl;
	}
}
