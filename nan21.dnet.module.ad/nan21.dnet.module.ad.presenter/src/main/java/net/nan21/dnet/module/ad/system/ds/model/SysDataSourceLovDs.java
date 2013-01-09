/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeNoTenantLov;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

@Ds(entity = SysDataSource.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = SysDataSourceLovDs.f_name)})
public class SysDataSourceLovDs extends AbstractTypeNoTenantLov<SysDataSource> {

	public SysDataSourceLovDs() {
		super();
	}

	public SysDataSourceLovDs(SysDataSource e) {
		super(e);
	}
}
