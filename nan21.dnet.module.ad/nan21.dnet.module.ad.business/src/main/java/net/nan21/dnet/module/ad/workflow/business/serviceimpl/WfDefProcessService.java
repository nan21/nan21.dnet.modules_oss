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
import net.nan21.dnet.module.ad.workflow.business.service.IWfDefProcessService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;

/**
 * Repository functionality for {@link WfDefProcess} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class WfDefProcessService extends AbstractEntityService<WfDefProcess>
		implements
			IWfDefProcessService {

	public WfDefProcessService() {
		super();
	}

	public WfDefProcessService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<WfDefProcess> getEntityClass() {
		return WfDefProcess.class;
	}

	/**
	 * Find by unique key
	 */
	public WfDefProcess findByName(String name) {
		return (WfDefProcess) this.getEntityManager()
				.createNamedQuery(WfDefProcess.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: nodes
	 */
	public List<WfDefProcess> findByNodes(WfDefNode nodes) {
		return this.findByNodesId(nodes.getId());
	}

	/**
	 * Find by ID of reference: nodes.id
	 */
	public List<WfDefProcess> findByNodesId(Long nodesId) {
		return (List<WfDefProcess>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from WfDefProcess e, IN (e.nodes) c where e.clientId = :pClientId and c.id = :pNodesId",
						WfDefProcess.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pNodesId", nodesId).getResultList();
	}
}
