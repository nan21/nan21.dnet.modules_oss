/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActDetailHistoryService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActByteArray;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDetailHistory;

/**
 * Repository functionality for {@link ActDetailHistory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ActDetailHistoryService
		extends
			AbstractEntityService<ActDetailHistory>
		implements
			IActDetailHistoryService {

	public ActDetailHistoryService() {
		super();
	}

	public ActDetailHistoryService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ActDetailHistory> getEntityClass() {
		return ActDetailHistory.class;
	}

	/**
	 * Find by reference: byteArray
	 */
	public List<ActDetailHistory> findByByteArray(ActByteArray byteArray) {
		return this.findByByteArrayId(byteArray.getId());
	}

	/**
	 * Find by ID of reference: byteArray.id
	 */
	public List<ActDetailHistory> findByByteArrayId(String byteArrayId) {
		return (List<ActDetailHistory>) this.em
				.createQuery(
						"select e from ActDetailHistory e where  e.byteArray.id = :pByteArrayId",
						ActDetailHistory.class)
				.setParameter("pByteArrayId", byteArrayId).getResultList();
	}
}
