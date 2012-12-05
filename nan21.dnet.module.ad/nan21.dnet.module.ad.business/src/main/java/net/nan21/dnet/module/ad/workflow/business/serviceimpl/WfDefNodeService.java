/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IWfDefNodeService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeField;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;

/**
 * Repository functionality for {@link WfDefNode} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class WfDefNodeService extends AbstractEntityService<WfDefNode>
		implements
			IWfDefNodeService {

	public WfDefNodeService() {
		super();
	}

	public WfDefNodeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<WfDefNode> getEntityClass() {
		return WfDefNode.class;
	}

	/**
	 * Find by unique key
	 */
	public WfDefNode findByName(String name) {
		return (WfDefNode) this.getEntityManager()
				.createNamedQuery(WfDefNode.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: process
	 */
	public List<WfDefNode> findByProcess(WfDefProcess process) {
		return this.findByProcessId(process.getId());
	}

	/**
	 * Find by ID of reference: process.id
	 */
	public List<WfDefNode> findByProcessId(Long processId) {
		return (List<WfDefNode>) this
				.getEntityManager()
				.createQuery(
						"select e from WfDefNode e where e.clientId = :pClientId and e.process.id = :pProcessId",
						WfDefNode.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProcessId", processId).getResultList();
	}

	/**
	 * Find by reference: fields
	 */
	public List<WfDefNode> findByFields(WfDefNodeField fields) {
		return this.findByFieldsId(fields.getId());
	}

	/**
	 * Find by ID of reference: fields.id
	 */
	public List<WfDefNode> findByFieldsId(Long fieldsId) {
		return (List<WfDefNode>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from WfDefNode e, IN (e.fields) c where e.clientId = :pClientId and c.id = :pFieldsId",
						WfDefNode.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFieldsId", fieldsId).getResultList();
	}
}
