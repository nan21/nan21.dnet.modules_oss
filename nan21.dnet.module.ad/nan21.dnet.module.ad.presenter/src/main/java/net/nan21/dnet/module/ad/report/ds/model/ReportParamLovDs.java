/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.report.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;

@Ds(entity = ReportParam.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = ReportParamLovDs.f_code)})
public class ReportParamLovDs extends AbstractTypeWithCodeLov<ReportParam> {

	public static final String f_reportId = "reportId";

	@DsField(join = "left", path = "report.id")
	private Long reportId;

	public ReportParamLovDs() {
		super();
	}

	public ReportParamLovDs(ReportParam e) {
		super(e);
	}

	public Long getReportId() {
		return this.reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
}
