/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.ad.report.domain.entity.Report;

@Ds(entity = Report.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = ReportLovDs.f_code)})
public class ReportLovDs extends AbstractTypeWithCodeLov<Report> {

	public ReportLovDs() {
		super();
	}

	public ReportLovDs(Report e) {
		super(e);
	}
}
