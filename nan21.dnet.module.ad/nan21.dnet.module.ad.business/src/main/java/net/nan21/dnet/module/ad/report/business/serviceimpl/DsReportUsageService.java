/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.report.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.report.business.service.IDsReportUsageService;
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;
import net.nan21.dnet.module.ad.report.domain.entity.DsReportUsage;

/**
 * Repository functionality for {@link DsReportUsage} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DsReportUsageService extends AbstractEntityService<DsReportUsage>
		implements
			IDsReportUsageService {

	public DsReportUsageService() {
		super();
	}

	public DsReportUsageService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DsReportUsage> getEntityClass() {
		return DsReportUsage.class;
	}

	/**
	 * Find by reference: dsReport
	 */
	public List<DsReportUsage> findByDsReport(DsReport dsReport) {
		return this.findByDsReportId(dsReport.getId());
	}

	/**
	 * Find by ID of reference: dsReport.id
	 */
	public List<DsReportUsage> findByDsReportId(Long dsReportId) {
		return (List<DsReportUsage>) this
				.getEntityManager()
				.createQuery(
						"select e from DsReportUsage e where e.clientId = :pClientId and e.dsReport.id = :pDsReportId",
						DsReportUsage.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDsReportId", dsReportId).getResultList();
	}
}
