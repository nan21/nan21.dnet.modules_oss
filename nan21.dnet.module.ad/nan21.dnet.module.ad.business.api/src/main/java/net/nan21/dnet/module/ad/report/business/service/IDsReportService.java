/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.report.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;
import net.nan21.dnet.module.ad.report.domain.entity.Report;

/**
 * Interface to expose business functions specific for {@link DsReport} domain
 * entity.
 */
public interface IDsReportService extends IEntityService<DsReport> {

	/**
	 * Find by reference: report
	 */
	public List<DsReport> findByReport(Report report);

	/**
	 * Find by ID of reference: report.id
	 */
	public List<DsReport> findByReportId(Long reportId);
}
