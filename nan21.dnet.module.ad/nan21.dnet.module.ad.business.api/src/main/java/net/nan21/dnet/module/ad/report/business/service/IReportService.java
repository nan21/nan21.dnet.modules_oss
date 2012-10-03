/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.report.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.report.domain.entity.Report;
import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;

public interface IReportService extends IEntityService<Report> {
	
	public Report findByCode(String code);
	
	public Report findByName(String name);
	
	public List<Report> findByReportServer(ReportServer reportServer);
	
	public List<Report> findByReportServerId(Long reportServerId);
	
}
