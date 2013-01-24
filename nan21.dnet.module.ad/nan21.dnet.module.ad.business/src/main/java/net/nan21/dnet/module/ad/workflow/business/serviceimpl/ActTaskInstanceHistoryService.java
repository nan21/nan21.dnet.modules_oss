/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActTaskInstanceHistoryService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActTaskInstanceHistory;

/**
 * Repository functionality for {@link ActTaskInstanceHistory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ActTaskInstanceHistoryService
		extends
			AbstractEntityService<ActTaskInstanceHistory>
		implements
			IActTaskInstanceHistoryService {

	public ActTaskInstanceHistoryService() {
		super();
	}

	public ActTaskInstanceHistoryService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ActTaskInstanceHistory> getEntityClass() {
		return ActTaskInstanceHistory.class;
	}

	/**
	 * Find by reference: processDefinition
	 */
	public List<ActTaskInstanceHistory> findByProcessDefinition(
			ActProcessDefinition processDefinition) {
		return this.findByProcessDefinitionId(processDefinition.getId());
	}

	/**
	 * Find by ID of reference: processDefinition.id
	 */
	public List<ActTaskInstanceHistory> findByProcessDefinitionId(
			String processDefinitionId) {
		return (List<ActTaskInstanceHistory>) this
				.getEntityManager()
				.createQuery(
						"select e from ActTaskInstanceHistory e where  e.processDefinition.id = :pProcessDefinitionId",
						ActTaskInstanceHistory.class)
				.setParameter("pProcessDefinitionId", processDefinitionId)
				.getResultList();
	}

	/**
	 * Find by reference: parent
	 */
	public List<ActTaskInstanceHistory> findByParent(
			ActTaskInstanceHistory parent) {
		return this.findByParentId(parent.getId());
	}

	/**
	 * Find by ID of reference: parent.id
	 */
	public List<ActTaskInstanceHistory> findByParentId(String parentId) {
		return (List<ActTaskInstanceHistory>) this
				.getEntityManager()
				.createQuery(
						"select e from ActTaskInstanceHistory e where  e.parent.id = :pParentId",
						ActTaskInstanceHistory.class)
				.setParameter("pParentId", parentId).getResultList();
	}
}
