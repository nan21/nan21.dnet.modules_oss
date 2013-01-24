/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeNoTenantDs;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

@Ds(entity = SysDataSource.class, sort = {@SortField(field = SysDataSourceDs.f_name)})
public class SysDataSourceDs extends AbstractTypeNoTenantDs<SysDataSource> {

	public static final String f_model = "model";
	public static final String f_isAsgn = "isAsgn";

	@DsField
	private String model;

	@DsField
	private Boolean isAsgn;

	public SysDataSourceDs() {
		super();
	}

	public SysDataSourceDs(SysDataSource e) {
		super(e);
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Boolean getIsAsgn() {
		return this.isAsgn;
	}

	public void setIsAsgn(Boolean isAsgn) {
		this.isAsgn = isAsgn;
	}
}
