/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActVariableService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActByteArray;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActVariable;

/**
 * Repository functionality for {@link ActVariable} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ActVariableService extends AbstractEntityService<ActVariable>
		implements
			IActVariableService {

	public ActVariableService() {
		super();
	}

	public ActVariableService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ActVariable> getEntityClass() {
		return ActVariable.class;
	}

	/**
	 * Find by reference: byteArray
	 */
	public List<ActVariable> findByByteArray(ActByteArray byteArray) {
		return this.findByByteArrayId(byteArray.getId());
	}

	/**
	 * Find by ID of reference: byteArray.id
	 */
	public List<ActVariable> findByByteArrayId(String byteArrayId) {
		return (List<ActVariable>) this.em
				.createQuery(
						"select e from ActVariable e where  e.byteArray.id = :pByteArrayId",
						ActVariable.class)
				.setParameter("pByteArrayId", byteArrayId).getResultList();
	}
}
