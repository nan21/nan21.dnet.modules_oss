/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.report.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.report.domain.entity.Report;
import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;

/**
 * Interface to expose business functions specific for {@link Report} domain
 * entity.
 */
public interface IReportService extends IEntityService<Report> {

	/**
	 * Find by unique key
	 */
	public Report findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Report findByName(String name);

	/**
	 * Find by reference: reportServer
	 */
	public List<Report> findByReportServer(ReportServer reportServer);

	/**
	 * Find by ID of reference: reportServer.id
	 */
	public List<Report> findByReportServerId(Long reportServerId);
}
