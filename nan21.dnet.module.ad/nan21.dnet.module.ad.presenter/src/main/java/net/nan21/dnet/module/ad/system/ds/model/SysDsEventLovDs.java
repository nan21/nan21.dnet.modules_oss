/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableNoTenantLov;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsEvent;

@Ds(entity = SysDsEvent.class)
public class SysDsEventLovDs extends AbstractAuditableNoTenantLov<SysDsEvent> {

	public static final String f_dataSourceId = "dataSourceId";
	public static final String f_dataSourceName = "dataSourceName";
	public static final String f_name = "name";

	@DsField(join = "left", path = "dataSource.id")
	private Long dataSourceId;

	@DsField(join = "left", path = "dataSource.name")
	private String dataSourceName;

	@DsField(path = "eventType")
	private String name;

	public SysDsEventLovDs() {
		super();
	}

	public SysDsEventLovDs(SysDsEvent e) {
		super(e);
	}

	public Long getDataSourceId() {
		return this.dataSourceId;
	}

	public void setDataSourceId(Long dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public String getDataSourceName() {
		return this.dataSourceName;
	}

	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
