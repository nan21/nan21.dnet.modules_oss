/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeNoTenantLov;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsField;

@Ds(entity = SysDsField.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = SysDsFieldLovDs.f_name)})
public class SysDsFieldLovDs extends AbstractTypeNoTenantLov<SysDsField> {

	public static final String f_dataSourceId = "dataSourceId";
	public static final String f_dataSourceName = "dataSourceName";
	public static final String f_dataType = "dataType";

	@DsField(join = "left", path = "dataSource.id")
	private Long dataSourceId;

	@DsField(join = "left", path = "dataSource.name")
	private String dataSourceName;

	@DsField
	private String dataType;

	public SysDsFieldLovDs() {
		super();
	}

	public SysDsFieldLovDs(SysDsField e) {
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

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
}
