/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJob;

@Ds(entity = ExportJob.class, sort = {@SortField(field = ExportJobDs.f_name)})
public class ExportJobDs extends AbstractTypeDs<ExportJob> {

	public ExportJobDs() {
		super();
	}

	public ExportJobDs(ExportJob e) {
		super(e);
	}
}
