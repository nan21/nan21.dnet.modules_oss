/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.payroll.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

/**
 * Repository functionality for {@link PayrollPeriod} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PayrollPeriodService extends AbstractEntityService<PayrollPeriod> {

	public PayrollPeriodService() {
		super();
	}

	public PayrollPeriodService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PayrollPeriod> getEntityClass() {
		return PayrollPeriod.class;
	}

	/**
	 * Find by unique key
	 */
	public PayrollPeriod findByName(String name) {
		return (PayrollPeriod) this.getEntityManager()
				.createNamedQuery(PayrollPeriod.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: payroll
	 */
	public List<PayrollPeriod> findByPayroll(Payroll payroll) {
		return this.findByPayrollId(payroll.getId());
	}

	/**
	 * Find by ID of reference: payroll.id
	 */
	public List<PayrollPeriod> findByPayrollId(Long payrollId) {
		return (List<PayrollPeriod>) this
				.getEntityManager()
				.createQuery(
						"select e from PayrollPeriod e where e.clientId = :pClientId and e.payroll.id = :pPayrollId",
						PayrollPeriod.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPayrollId", payrollId).getResultList();
	}
}
