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
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalYear;

/**
 * Repository functionality for {@link FiscalPeriod} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class FiscalPeriodService extends AbstractEntityService<FiscalPeriod> {

	public FiscalPeriodService() {
		super();
	}

	public FiscalPeriodService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<FiscalPeriod> getEntityClass() {
		return FiscalPeriod.class;
	}

	/**
	 * Find by unique key
	 */
	public FiscalPeriod findByCode(String code) {
		return (FiscalPeriod) this.em
				.createNamedQuery(FiscalPeriod.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public FiscalPeriod findByName(String name) {
		return (FiscalPeriod) this.em
				.createNamedQuery(FiscalPeriod.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: year
	 */
	public List<FiscalPeriod> findByYear(FiscalYear year) {
		return this.findByYearId(year.getId());
	}

	/**
	 * Find by ID of reference: year.id
	 */
	public List<FiscalPeriod> findByYearId(Long yearId) {
		return (List<FiscalPeriod>) this.em
				.createQuery(
						"select e from FiscalPeriod e where e.clientId = :pClientId and e.year.id = :pYearId",
						FiscalPeriod.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pYearId", yearId).getResultList();
	}
}
