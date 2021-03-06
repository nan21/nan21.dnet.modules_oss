/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.geo.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableLov;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;

@Ds(entity = Location.class, jpqlWhere = " e.active = true and e.forBilling = true ")
public class LocationToBillLovDs extends AbstractAuditableLov<Location> {

	public static final String f_targetUuid = "targetUuid";
	public static final String f_targetType = "targetType";
	public static final String f_asString = "asString";
	public static final String f_active = "active";

	@DsField
	private String targetUuid;

	@DsField
	private String targetType;

	@DsField(fetch = false)
	private String asString;

	@DsField
	private Boolean active;

	public LocationToBillLovDs() {
		super();
	}

	public LocationToBillLovDs(Location e) {
		super(e);
	}

	public String getTargetUuid() {
		return this.targetUuid;
	}

	public void setTargetUuid(String targetUuid) {
		this.targetUuid = targetUuid;
	}

	public String getTargetType() {
		return this.targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public String getAsString() {
		return this.asString;
	}

	public void setAsString(String asString) {
		this.asString = asString;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
