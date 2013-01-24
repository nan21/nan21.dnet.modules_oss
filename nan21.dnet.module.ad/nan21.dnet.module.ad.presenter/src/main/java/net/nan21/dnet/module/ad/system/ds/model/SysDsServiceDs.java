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
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeNoTenantDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;

@Ds(entity = SysDsService.class, sort = {@SortField(field = SysDsServiceDs.f_name)})
@RefLookups({@RefLookup(refId = SysDsServiceDs.f_dataSourceId, namedQuery = SysDataSource.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = SysDsServiceDs.f_dataSource)})})
public class SysDsServiceDs extends AbstractTypeNoTenantDs<SysDsService> {

	public static final String f_dataSourceId = "dataSourceId";
	public static final String f_dataSource = "dataSource";

	@DsField(join = "left", path = "dataSource.id")
	private Long dataSourceId;

	@DsField(join = "left", path = "dataSource.name")
	private String dataSource;

	public SysDsServiceDs() {
		super();
	}

	public SysDsServiceDs(SysDsService e) {
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
}
