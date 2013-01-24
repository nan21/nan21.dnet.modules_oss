/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.report.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.report.domain.entity.Report;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;

/**
 * Interface to expose business functions specific for {@link ReportParam} domain
 * entity.
 */
public interface IReportParamService extends IEntityService<ReportParam> {

	/**
	 * Find by unique key
	 */
	public ReportParam findByCode(Report report, String code);

	/**
	 * Find by unique key
	 */
	public ReportParam findByCode(Long reportId, String code);

	/**
	 * Find by unique key
	 */
	public ReportParam findByName(Report report, String name);

	/**
	 * Find by unique key
	 */
	public ReportParam findByName(Long reportId, String name);

	/**
	 * Find by reference: report
	 */
	public List<ReportParam> findByReport(Report report);

	/**
	 * Find by ID of reference: report.id
	 */
	public List<ReportParam> findByReportId(Long reportId);
}
