/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableNoTenantDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsEvent;

@Ds(entity = SysDsEvent.class)
@RefLookups({@RefLookup(refId = SysDsEventDs.f_dataSourceId, namedQuery = SysDataSource.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = SysDsEventDs.f_dataSource)})})
public class SysDsEventDs extends AbstractAuditableNoTenantDs<SysDsEvent> {

	public static final String f_dataSourceId = "dataSourceId";
	public static final String f_dataSource = "dataSource";
	public static final String f_name = "name";

	@DsField(join = "left", path = "dataSource.id")
	private Long dataSourceId;

	@DsField(join = "left", path = "dataSource.name")
	private String dataSource;

	@DsField(path = "eventType")
	private String name;

	public SysDsEventDs() {
		super();
	}

	public SysDsEventDs(SysDsEvent e) {
		super(e);
	}

	public Long getDataSourceId() {
		return this.dataSourceId;
	}

	public void setDataSourceId(Long dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
