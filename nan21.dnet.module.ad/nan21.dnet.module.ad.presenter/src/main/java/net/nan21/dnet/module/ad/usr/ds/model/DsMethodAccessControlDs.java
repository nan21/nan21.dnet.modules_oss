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
import net.nan21.dnet.module.ad.usr.domain.entity.DsMethodAccessControl;

@Ds(entity = DsMethodAccessControl.class, sort = {
		@SortField(field = DsMethodAccessControlDs.f_dsName),
		@SortField(field = DsMethodAccessControlDs.f_serviceMethod)})
@RefLookups({@RefLookup(refId = DsMethodAccessControlDs.f_accessControlId, namedQuery = AccessControl.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = DsMethodAccessControlDs.f_accessControl)})})
public class DsMethodAccessControlDs
		extends
			AbstractAuditableDs<DsMethodAccessControl> {

	public static final String f_dsName = "dsName";
	public static final String f_serviceMethod = "serviceMethod";
	public static final String f_accessControlId = "accessControlId";
	public static final String f_accessControl = "accessControl";

	@DsField
	private String dsName;

	@DsField
	private String serviceMethod;

	@DsField(join = "left", path = "accessControl.id")
	private Long accessControlId;

	@DsField(join = "left", path = "accessControl.name")
	private String accessControl;

	public DsMethodAccessControlDs() {
		super();
	}

	public DsMethodAccessControlDs(DsMethodAccessControl e) {
		super(e);
	}

	public String getDsName() {
		return this.dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public String getServiceMethod() {
		return this.serviceMethod;
	}

	public void setServiceMethod(String serviceMethod) {
		this.serviceMethod = serviceMethod;
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
