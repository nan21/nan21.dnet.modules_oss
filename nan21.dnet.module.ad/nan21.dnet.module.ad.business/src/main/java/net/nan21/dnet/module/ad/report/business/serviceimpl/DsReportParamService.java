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
import net.nan21.dnet.module.ad.report.business.service.IDsReportParamService;
import net.nan21.dnet.module.ad.report.domain.entity.DsReport;
import net.nan21.dnet.module.ad.report.domain.entity.DsReportParam;
import net.nan21.dnet.module.ad.report.domain.entity.ReportParam;

/**
 * Repository functionality for {@link DsReportParam} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DsReportParamService extends AbstractEntityService<DsReportParam>
		implements
			IDsReportParamService {

	public DsReportParamService() {
		super();
	}

	public DsReportParamService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<DsReportParam> getEntityClass() {
		return DsReportParam.class;
	}

	/**
	 * Find by reference: dsReport
	 */
	public List<DsReportParam> findByDsReport(DsReport dsReport) {
		return this.findByDsReportId(dsReport.getId());
	}

	/**
	 * Find by ID of reference: dsReport.id
	 */
	public List<DsReportParam> findByDsReportId(Long dsReportId) {
		return (List<DsReportParam>) this.em
				.createQuery(
						"select e from DsReportParam e where e.clientId = :pClientId and e.dsReport.id = :pDsReportId",
						DsReportParam.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDsReportId", dsReportId).getResultList();
	}

	/**
	 * Find by reference: reportParam
	 */
	public List<DsReportParam> findByReportParam(ReportParam reportParam) {
		return this.findByReportParamId(reportParam.getId());
	}

	/**
	 * Find by ID of reference: reportParam.id
	 */
	public List<DsReportParam> findByReportParamId(Long reportParamId) {
		return (List<DsReportParam>) this.em
				.createQuery(
						"select e from DsReportParam e where e.clientId = :pClientId and e.reportParam.id = :pReportParamId",
						DsReportParam.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pReportParamId", reportParamId).getResultList();
	}
}
