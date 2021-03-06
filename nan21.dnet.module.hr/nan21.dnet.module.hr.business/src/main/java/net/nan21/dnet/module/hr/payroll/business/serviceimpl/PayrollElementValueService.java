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
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeAssignment;
import net.nan21.dnet.module.hr.payroll.business.service.IPayrollElementValueService;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElementValue;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

/**
 * Repository functionality for {@link PayrollElementValue} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PayrollElementValueService
		extends
			AbstractEntityService<PayrollElementValue>
		implements
			IPayrollElementValueService {

	public PayrollElementValueService() {
		super();
	}

	public PayrollElementValueService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PayrollElementValue> getEntityClass() {
		return PayrollElementValue.class;
	}

	/**
	 * Find by reference: element
	 */
	public List<PayrollElementValue> findByElement(PayrollElement element) {
		return this.findByElementId(element.getId());
	}

	/**
	 * Find by ID of reference: element.id
	 */
	public List<PayrollElementValue> findByElementId(Long elementId) {
		return (List<PayrollElementValue>) this
				.getEntityManager()
				.createQuery(
						"select e from PayrollElementValue e where e.clientId = :pClientId and e.element.id = :pElementId",
						PayrollElementValue.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pElementId", elementId).getResultList();
	}

	/**
	 * Find by reference: period
	 */
	public List<PayrollElementValue> findByPeriod(PayrollPeriod period) {
		return this.findByPeriodId(period.getId());
	}

	/**
	 * Find by ID of reference: period.id
	 */
	public List<PayrollElementValue> findByPeriodId(Long periodId) {
		return (List<PayrollElementValue>) this
				.getEntityManager()
				.createQuery(
						"select e from PayrollElementValue e where e.clientId = :pClientId and e.period.id = :pPeriodId",
						PayrollElementValue.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPeriodId", periodId).getResultList();
	}

	/**
	 * Find by reference: assignment
	 */
	public List<PayrollElementValue> findByAssignment(
			EmployeeAssignment assignment) {
		return this.findByAssignmentId(assignment.getId());
	}

	/**
	 * Find by ID of reference: assignment.id
	 */
	public List<PayrollElementValue> findByAssignmentId(Long assignmentId) {
		return (List<PayrollElementValue>) this
				.getEntityManager()
				.createQuery(
						"select e from PayrollElementValue e where e.clientId = :pClientId and e.assignment.id = :pAssignmentId",
						PayrollElementValue.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAssignmentId", assignmentId).getResultList();
	}

	/**
	 * Find by reference: org
	 */
	public List<PayrollElementValue> findByOrg(Organization org) {
		return this.findByOrgId(org.getId());
	}

	/**
	 * Find by ID of reference: org.id
	 */
	public List<PayrollElementValue> findByOrgId(Long orgId) {
		return (List<PayrollElementValue>) this
				.getEntityManager()
				.createQuery(
						"select e from PayrollElementValue e where e.clientId = :pClientId and e.org.id = :pOrgId",
						PayrollElementValue.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOrgId", orgId).getResultList();
	}
}
