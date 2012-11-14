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
import net.nan21.dnet.module.ad.report.business.service.IReportParamService;
import net.nan21.dnet.module.ad.report.domain.entity.Report;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;

/**
 * Repository functionality for {@link ReportParam} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ReportParamService extends AbstractEntityService<ReportParam>
		implements
			IReportParamService {

	public ReportParamService() {
		super();
	}

	public ReportParamService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ReportParam> getEntityClass() {
		return ReportParam.class;
	}

	/**
	 * Find by unique key
	 */
	public ReportParam findByCode(Report report, String code) {
		return (ReportParam) this.em
				.createNamedQuery(ReportParam.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pReport", report).setParameter("pCode", code)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ReportParam findByCode(Long reportId, String code) {
		return (ReportParam) this.em
				.createNamedQuery(ReportParam.NQ_FIND_BY_CODE_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pReportId", reportId)
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ReportParam findByName(Report report, String name) {
		return (ReportParam) this.em
				.createNamedQuery(ReportParam.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pReport", report).setParameter("pName", name)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ReportParam findByName(Long reportId, String name) {
		return (ReportParam) this.em
				.createNamedQuery(ReportParam.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pReportId", reportId)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: report
	 */
	public List<ReportParam> findByReport(Report report) {
		return this.findByReportId(report.getId());
	}

	/**
	 * Find by ID of reference: report.id
	 */
	public List<ReportParam> findByReportId(Long reportId) {
		return (List<ReportParam>) this.em
				.createQuery(
						"select e from ReportParam e where e.clientId = :pClientId and e.report.id = :pReportId",
						ReportParam.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pReportId", reportId).getResultList();
	}
}
