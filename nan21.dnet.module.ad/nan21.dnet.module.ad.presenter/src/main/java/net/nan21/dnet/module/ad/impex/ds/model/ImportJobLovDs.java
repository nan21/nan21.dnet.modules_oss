/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;

@Ds(entity = ImportJob.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = ImportJobLovDs.f_name)})
public class ImportJobLovDs extends AbstractTypeLov<ImportJob> {

	public ImportJobLovDs() {
		super();
	}

	public ImportJobLovDs(ImportJob e) {
		super(e);
	}
}
