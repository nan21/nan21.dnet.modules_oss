/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.ad.system.domain.entity.SysJob;

@Ds(entity=SysJob.class,jpqlWhere=" e.active = true ", sort={@SortField(field=SysJobLovDs.fNAME)})
public class SysJobLovDs extends AbstractTypeLov<SysJob> {


	public SysJobLovDs() {
		super();
	}

 	public SysJobLovDs(SysJob e) {
		super(e);
	}
}
