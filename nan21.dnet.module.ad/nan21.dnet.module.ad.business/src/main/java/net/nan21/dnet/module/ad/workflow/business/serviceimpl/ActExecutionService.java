/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActExecutionService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActExecution;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

/**
 * Repository functionality for {@link ActExecution} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ActExecutionService extends AbstractEntityService<ActExecution>
		implements
			IActExecutionService {

	public ActExecutionService() {
		super();
	}

	public ActExecutionService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ActExecution> getEntityClass() {
		return ActExecution.class;
	}

	/**
	 * Find by reference: parent
	 */
	public List<ActExecution> findByParent(ActExecution parent) {
		return this.findByParentId(parent.getId());
	}

	/**
	 * Find by ID of reference: parent.id
	 */
	public List<ActExecution> findByParentId(String parentId) {
		return (List<ActExecution>) this
				.getEntityManager()
				.createQuery(
						"select e from ActExecution e where  e.parent.id = :pParentId",
						ActExecution.class).setParameter("pParentId", parentId)
				.getResultList();
	}

	/**
	 * Find by reference: processDefinition
	 */
	public List<ActExecution> findByProcessDefinition(
			ActProcessDefinition processDefinition) {
		return this.findByProcessDefinitionId(processDefinition.getId());
	}

	/**
	 * Find by ID of reference: processDefinition.id
	 */
	public List<ActExecution> findByProcessDefinitionId(
			String processDefinitionId) {
		return (List<ActExecution>) this
				.getEntityManager()
				.createQuery(
						"select e from ActExecution e where  e.processDefinition.id = :pProcessDefinitionId",
						ActExecution.class)
				.setParameter("pProcessDefinitionId", processDefinitionId)
				.getResultList();
	}
}
