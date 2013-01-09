/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeNoTenantLov;
import net.nan21.dnet.module.ad.system.domain.entity.SysParam;

@Ds(entity = SysParam.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = SysParamLovDs.f_code)})
public class SysParamLovDs extends AbstractTypeWithCodeNoTenantLov<SysParam> {

	public SysParamLovDs() {
		super();
	}

	public SysParamLovDs(SysParam e) {
		super(e);
	}
}
