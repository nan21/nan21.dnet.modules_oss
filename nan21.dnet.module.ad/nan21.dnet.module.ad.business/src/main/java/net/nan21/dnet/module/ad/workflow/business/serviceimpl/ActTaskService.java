/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActTaskService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActTask;

/**
 * Repository functionality for {@link ActTask} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ActTaskService extends AbstractEntityService<ActTask>
		implements
			IActTaskService {

	public ActTaskService() {
		super();
	}

	public ActTaskService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ActTask> getEntityClass() {
		return ActTask.class;
	}

	/**
	 * Find by reference: processDefinition
	 */
	public List<ActTask> findByProcessDefinition(
			ActProcessDefinition processDefinition) {
		return this.findByProcessDefinitionId(processDefinition.getId());
	}

	/**
	 * Find by ID of reference: processDefinition.id
	 */
	public List<ActTask> findByProcessDefinitionId(String processDefinitionId) {
		return (List<ActTask>) this.em
				.createQuery(
						"select e from ActTask e where  e.processDefinition.id = :pProcessDefinitionId",
						ActTask.class)
				.setParameter("pProcessDefinitionId", processDefinitionId)
				.getResultList();
	}

	/**
	 * Find by reference: parent
	 */
	public List<ActTask> findByParent(ActTask parent) {
		return this.findByParentId(parent.getId());
	}

	/**
	 * Find by ID of reference: parent.id
	 */
	public List<ActTask> findByParentId(String parentId) {
		return (List<ActTask>) this.em
				.createQuery(
						"select e from ActTask e where  e.parent.id = :pParentId",
						ActTask.class).setParameter("pParentId", parentId)
				.getResultList();
	}
}
