/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.report.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.report.business.service.IReportServerService;
import net.nan21.dnet.module.ad.report.domain.entity.ReportServer;

/**
 * Repository functionality for {@link ReportServer} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ReportServerService extends AbstractEntityService<ReportServer>
		implements
			IReportServerService {

	public ReportServerService() {
		super();
	}

	public ReportServerService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ReportServer> getEntityClass() {
		return ReportServer.class;
	}

	/**
	 * Find by unique key
	 */
	public ReportServer findByName(String name) {
		return (ReportServer) this.em
				.createNamedQuery(ReportServer.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
