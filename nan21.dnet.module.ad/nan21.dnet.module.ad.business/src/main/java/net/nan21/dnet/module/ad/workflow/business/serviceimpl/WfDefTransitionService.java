/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IWfDefTransitionService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefTransition;

/**
 * Repository functionality for {@link WfDefTransition} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class WfDefTransitionService
		extends
			AbstractEntityService<WfDefTransition>
		implements
			IWfDefTransitionService {

	public WfDefTransitionService() {
		super();
	}

	public WfDefTransitionService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<WfDefTransition> getEntityClass() {
		return WfDefTransition.class;
	}

	/**
	 * Find by reference: process
	 */
	public List<WfDefTransition> findByProcess(WfDefProcess process) {
		return this.findByProcessId(process.getId());
	}

	/**
	 * Find by ID of reference: process.id
	 */
	public List<WfDefTransition> findByProcessId(Long processId) {
		return (List<WfDefTransition>) this
				.getEntityManager()
				.createQuery(
						"select e from WfDefTransition e where e.clientId = :pClientId and e.process.id = :pProcessId",
						WfDefTransition.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProcessId", processId).getResultList();
	}

	/**
	 * Find by reference: source
	 */
	public List<WfDefTransition> findBySource(WfDefNode source) {
		return this.findBySourceId(source.getId());
	}

	/**
	 * Find by ID of reference: source.id
	 */
	public List<WfDefTransition> findBySourceId(Long sourceId) {
		return (List<WfDefTransition>) this
				.getEntityManager()
				.createQuery(
						"select e from WfDefTransition e where e.clientId = :pClientId and e.source.id = :pSourceId",
						WfDefTransition.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSourceId", sourceId).getResultList();
	}

	/**
	 * Find by reference: target
	 */
	public List<WfDefTransition> findByTarget(WfDefNode target) {
		return this.findByTargetId(target.getId());
	}

	/**
	 * Find by ID of reference: target.id
	 */
	public List<WfDefTransition> findByTargetId(Long targetId) {
		return (List<WfDefTransition>) this
				.getEntityManager()
				.createQuery(
						"select e from WfDefTransition e where e.clientId = :pClientId and e.target.id = :pTargetId",
						WfDefTransition.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTargetId", targetId).getResultList();
	}
}
