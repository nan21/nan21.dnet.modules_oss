/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.base.period.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalYear;

@Ds(entity = FiscalYear.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = FiscalYearLovDs.f_code)})
public class FiscalYearLovDs extends AbstractTypeWithCodeLov<FiscalYear> {

	public FiscalYearLovDs() {
		super();
	}

	public FiscalYearLovDs(FiscalYear e) {
		super(e);
	}
}
