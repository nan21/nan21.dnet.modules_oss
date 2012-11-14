/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.report.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;
import net.nan21.dnet.module.ad.report.domain.entity.DsReportUsage;

/**
 * Interface to expose business functions specific for {@link DsReportUsage} domain
 * entity.
 */
public interface IDsReportUsageService extends IEntityService<DsReportUsage> {

	/**
	 * Find by reference: dsReport
	 */
	public List<DsReportUsage> findByDsReport(DsReport dsReport);

	/**
	 * Find by ID of reference: dsReport.id
	 */
	public List<DsReportUsage> findByDsReportId(Long dsReportId);
}
