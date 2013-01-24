/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.report.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;

/**
 * Interface to expose business functions specific for {@link ReportServer} domain
 * entity.
 */
public interface IReportServerService extends IEntityService<ReportServer> {

	/**
	 * Find by unique key
	 */
	public ReportServer findByName(String name);
}
