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
import net.nan21.dnet.module.ad.workflow.business.service.IWfDefNodeFieldService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNodeField;

/**
 * Repository functionality for {@link WfDefNodeField} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class WfDefNodeFieldService
		extends
			AbstractEntityService<WfDefNodeField>
		implements
			IWfDefNodeFieldService {

	public WfDefNodeFieldService() {
		super();
	}

	public WfDefNodeFieldService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<WfDefNodeField> getEntityClass() {
		return WfDefNodeField.class;
	}

	/**
	 * Find by unique key
	 */
	public WfDefNodeField findByName(String name) {
		return (WfDefNodeField) this.em
				.createNamedQuery(WfDefNodeField.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: node
	 */
	public List<WfDefNodeField> findByNode(WfDefNode node) {
		return this.findByNodeId(node.getId());
	}

	/**
	 * Find by ID of reference: node.id
	 */
	public List<WfDefNodeField> findByNodeId(Long nodeId) {
		return (List<WfDefNodeField>) this.em
				.createQuery(
						"select e from WfDefNodeField e where e.clientId = :pClientId and e.node.id = :pNodeId",
						WfDefNodeField.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pNodeId", nodeId).getResultList();
	}
}
