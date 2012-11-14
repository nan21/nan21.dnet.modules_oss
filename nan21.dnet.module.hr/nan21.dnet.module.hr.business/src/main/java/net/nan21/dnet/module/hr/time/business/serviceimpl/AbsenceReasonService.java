/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.time.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.time.business.service.IAbsenceReasonService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

/**
 * Repository functionality for {@link AbsenceReason} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AbsenceReasonService extends AbstractEntityService<AbsenceReason>
		implements
			IAbsenceReasonService {

	public AbsenceReasonService() {
		super();
	}

	public AbsenceReasonService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<AbsenceReason> getEntityClass() {
		return AbsenceReason.class;
	}

	/**
	 * Find by unique key
	 */
	public AbsenceReason findByName(String name) {
		return (AbsenceReason) this.em
				.createNamedQuery(AbsenceReason.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: type
	 */
	public List<AbsenceReason> findByType(AbsenceType type) {
		return this.findByTypeId(type.getId());
	}

	/**
	 * Find by ID of reference: type.id
	 */
	public List<AbsenceReason> findByTypeId(Long typeId) {
		return (List<AbsenceReason>) this.em
				.createQuery(
						"select e from AbsenceReason e where e.clientId = :pClientId and e.type.id = :pTypeId",
						AbsenceReason.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTypeId", typeId).getResultList();
	}
}
