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

public interface IDsReportService extends IEntityService<DsReport> {
	
	public List<DsReport> findByReport(Report report);
	
	public List<DsReport> findByReportId(Long reportId);
	
}
