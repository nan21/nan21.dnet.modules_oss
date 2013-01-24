/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IAssignableService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.ad.usr.domain.entity.AssignableType;

/**
 * Repository functionality for {@link Assignable} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AssignableService extends AbstractEntityService<Assignable>
		implements
			IAssignableService {

	public AssignableService() {
		super();
	}

	public AssignableService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Assignable> getEntityClass() {
		return Assignable.class;
	}

	/**
	 * Find by unique key
	 */
	public Assignable findByName(String name) {
		return (Assignable) this.getEntityManager()
				.createNamedQuery(Assignable.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: assignableType
	 */
	public List<Assignable> findByAssignableType(AssignableType assignableType) {
		return this.findByAssignableTypeId(assignableType.getId());
	}

	/**
	 * Find by ID of reference: assignableType.id
	 */
	public List<Assignable> findByAssignableTypeId(Long assignableTypeId) {
		return (List<Assignable>) this
				.getEntityManager()
				.createQuery(
						"select e from Assignable e where e.clientId = :pClientId and e.assignableType.id = :pAssignableTypeId",
						Assignable.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAssignableTypeId", assignableTypeId)
				.getResultList();
	}
}
