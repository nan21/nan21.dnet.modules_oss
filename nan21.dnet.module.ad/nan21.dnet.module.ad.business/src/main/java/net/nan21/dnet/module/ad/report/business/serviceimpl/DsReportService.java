/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.report.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.report.business.service.IDsReportService;
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;
import net.nan21.dnet.module.ad.report.domain.entity.Report;

/**
 * Repository functionality for {@link DsReport} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DsReportService extends AbstractEntityService<DsReport>
		implements
			IDsReportService {

	public DsReportService() {
		super();
	}

	public DsReportService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<DsReport> getEntityClass() {
		return DsReport.class;
	}

	/**
	 * Find by reference: report
	 */
	public List<DsReport> findByReport(Report report) {
		return this.findByReportId(report.getId());
	}

	/**
	 * Find by ID of reference: report.id
	 */
	public List<DsReport> findByReportId(Long reportId) {
		return (List<DsReport>) this.em
				.createQuery(
						"select e from DsReport e where e.clientId = :pClientId and e.report.id = :pReportId",
						DsReport.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pReportId", reportId).getResultList();
	}
}
