/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.report.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;
import net.nan21.dnet.module.ad.report.domain.entity.DsReportParam;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;

/**
 * Interface to expose business functions specific for {@link DsReportParam} domain
 * entity.
 */
public interface IDsReportParamService extends IEntityService<DsReportParam> {

	/**
	 * Find by reference: dsReport
	 */
	public List<DsReportParam> findByDsReport(DsReport dsReport);

	/**
	 * Find by ID of reference: dsReport.id
	 */
	public List<DsReportParam> findByDsReportId(Long dsReportId);

	/**
	 * Find by reference: reportParam
	 */
	public List<DsReportParam> findByReportParam(ReportParam reportParam);

	/**
	 * Find by ID of reference: reportParam.id
	 */
	public List<DsReportParam> findByReportParamId(Long reportParamId);
}
