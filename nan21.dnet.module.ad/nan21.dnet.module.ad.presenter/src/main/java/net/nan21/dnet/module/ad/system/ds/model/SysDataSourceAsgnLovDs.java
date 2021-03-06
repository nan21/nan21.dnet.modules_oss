/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeNoTenantLov;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

@Ds(entity = SysDataSource.class, jpqlWhere = " e.isAsgn = true ", sort = {@SortField(field = SysDataSourceAsgnLovDs.f_name)})
public class SysDataSourceAsgnLovDs
		extends
			AbstractTypeNoTenantLov<SysDataSource> {

	public SysDataSourceAsgnLovDs() {
		super();
	}

	public SysDataSourceAsgnLovDs(SysDataSource e) {
		super(e);
	}
}
