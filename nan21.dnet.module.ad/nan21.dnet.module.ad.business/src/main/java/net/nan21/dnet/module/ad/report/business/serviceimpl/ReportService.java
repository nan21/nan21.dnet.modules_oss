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
import net.nan21.dnet.module.ad.report.business.service.IReportService;
import net.nan21.dnet.module.ad.report.domain.entity.Report;
import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;

/**
 * Repository functionality for {@link Report} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ReportService extends AbstractEntityService<Report>
		implements
			IReportService {

	public ReportService() {
		super();
	}

	public ReportService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Report> getEntityClass() {
		return Report.class;
	}

	/**
	 * Find by unique key
	 */
	public Report findByCode(String code) {
		return (Report) this.getEntityManager()
				.createNamedQuery(Report.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public Report findByName(String name) {
		return (Report) this.getEntityManager()
				.createNamedQuery(Report.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: reportServer
	 */
	public List<Report> findByReportServer(ReportServer reportServer) {
		return this.findByReportServerId(reportServer.getId());
	}

	/**
	 * Find by ID of reference: reportServer.id
	 */
	public List<Report> findByReportServerId(Long reportServerId) {
		return (List<Report>) this
				.getEntityManager()
				.createQuery(
						"select e from Report e where e.clientId = :pClientId and e.reportServer.id = :pReportServerId",
						Report.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pReportServerId", reportServerId)
				.getResultList();
	}
}
