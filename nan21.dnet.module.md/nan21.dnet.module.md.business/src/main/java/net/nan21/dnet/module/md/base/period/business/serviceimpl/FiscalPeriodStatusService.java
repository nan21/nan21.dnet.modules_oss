/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.period.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.period.business.service.IFiscalPeriodStatusService;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriodStatus;

/**
 * Repository functionality for {@link FiscalPeriodStatus} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class FiscalPeriodStatusService
		extends
			AbstractEntityService<FiscalPeriodStatus>
		implements
			IFiscalPeriodStatusService {

	public FiscalPeriodStatusService() {
		super();
	}

	public FiscalPeriodStatusService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<FiscalPeriodStatus> getEntityClass() {
		return FiscalPeriodStatus.class;
	}

	/**
	 * Find by unique key
	 */
	public FiscalPeriodStatus findByOrg_period(Organization org,
			FiscalPeriod period) {
		return (FiscalPeriodStatus) this.em
				.createNamedQuery(FiscalPeriodStatus.NQ_FIND_BY_ORG_PERIOD)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOrg", org).setParameter("pPeriod", period)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public FiscalPeriodStatus findByOrg_period(Long orgId, Long periodId) {
		return (FiscalPeriodStatus) this.em
				.createNamedQuery(
						FiscalPeriodStatus.NQ_FIND_BY_ORG_PERIOD_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOrgId", orgId)
				.setParameter("pPeriodId", periodId).getSingleResult();
	}

	/**
	 * Find by reference: period
	 */
	public List<FiscalPeriodStatus> findByPeriod(FiscalPeriod period) {
		return this.findByPeriodId(period.getId());
	}

	/**
	 * Find by ID of reference: period.id
	 */
	public List<FiscalPeriodStatus> findByPeriodId(Long periodId) {
		return (List<FiscalPeriodStatus>) this.em
				.createQuery(
						"select e from FiscalPeriodStatus e where e.clientId = :pClientId and e.period.id = :pPeriodId",
						FiscalPeriodStatus.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPeriodId", periodId).getResultList();
	}

	/**
	 * Find by reference: org
	 */
	public List<FiscalPeriodStatus> findByOrg(Organization org) {
		return this.findByOrgId(org.getId());
	}

	/**
	 * Find by ID of reference: org.id
	 */
	public List<FiscalPeriodStatus> findByOrgId(Long orgId) {
		return (List<FiscalPeriodStatus>) this.em
				.createQuery(
						"select e from FiscalPeriodStatus e where e.clientId = :pClientId and e.org.id = :pOrgId",
						FiscalPeriodStatus.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOrgId", orgId).getResultList();
	}
}
