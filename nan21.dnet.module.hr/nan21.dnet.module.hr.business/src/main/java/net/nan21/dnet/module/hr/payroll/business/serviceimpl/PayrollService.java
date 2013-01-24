/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.payroll.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;
import net.nan21.dnet.module.hr.payroll.business.service.IPayrollService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

/**
 * Repository functionality for {@link Payroll} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PayrollService extends AbstractEntityService<Payroll>
		implements
			IPayrollService {

	public PayrollService() {
		super();
	}

	public PayrollService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Payroll> getEntityClass() {
		return Payroll.class;
	}

	/**
	 * Find by unique key
	 */
	public Payroll findByName(String name) {
		return (Payroll) this.getEntityManager()
				.createNamedQuery(Payroll.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: engine
	 */
	public List<Payroll> findByEngine(Engine engine) {
		return this.findByEngineId(engine.getId());
	}

	/**
	 * Find by ID of reference: engine.id
	 */
	public List<Payroll> findByEngineId(Long engineId) {
		return (List<Payroll>) this
				.getEntityManager()
				.createQuery(
						"select e from Payroll e where e.clientId = :pClientId and e.engine.id = :pEngineId",
						Payroll.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEngineId", engineId).getResultList();
	}
}
