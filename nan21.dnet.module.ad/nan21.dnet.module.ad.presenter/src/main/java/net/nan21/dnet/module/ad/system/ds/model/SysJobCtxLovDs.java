/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;

@Ds(entity = SysJobCtx.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = SysJobCtxLovDs.f_name)})
public class SysJobCtxLovDs extends AbstractTypeLov<SysJobCtx> {

	public SysJobCtxLovDs() {
		super();
	}

	public SysJobCtxLovDs(SysJobCtx e) {
		super(e);
	}
}
