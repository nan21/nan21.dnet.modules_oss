/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.res.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.res.business.service.IEmployeeBaseService;
import net.nan21.dnet.module.md.res.domain.entity.EmployeeBase;

/**
 * Repository functionality for {@link EmployeeBase} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class EmployeeBaseService extends AbstractEntityService<EmployeeBase>
		implements
			IEmployeeBaseService {

	public EmployeeBaseService() {
		super();
	}

	public EmployeeBaseService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<EmployeeBase> getEntityClass() {
		return EmployeeBase.class;
	}

	/**
	 * Find by reference: employer
	 */
	public List<EmployeeBase> findByEmployer(Organization employer) {
		return this.findByEmployerId(employer.getId());
	}

	/**
	 * Find by ID of reference: employer.id
	 */
	public List<EmployeeBase> findByEmployerId(Long employerId) {
		return (List<EmployeeBase>) this
				.getEntityManager()
				.createQuery(
						"select e from EmployeeBase e where e.clientId = :pClientId and e.employer.id = :pEmployerId",
						EmployeeBase.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEmployerId", employerId).getResultList();
	}

	/**
	 * Find by reference: citizenship
	 */
	public List<EmployeeBase> findByCitizenship(Country citizenship) {
		return this.findByCitizenshipId(citizenship.getId());
	}

	/**
	 * Find by ID of reference: citizenship.id
	 */
	public List<EmployeeBase> findByCitizenshipId(Long citizenshipId) {
		return (List<EmployeeBase>) this
				.getEntityManager()
				.createQuery(
						"select e from EmployeeBase e where e.clientId = :pClientId and e.citizenship.id = :pCitizenshipId",
						EmployeeBase.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCitizenshipId", citizenshipId).getResultList();
	}
}
