/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActExecution;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

/**
 * Interface to expose business functions specific for {@link ActExecution} domain
 * entity.
 */
public interface IActExecutionService extends IEntityService<ActExecution> {

	/**
	 * Find by reference: parent
	 */
	public List<ActExecution> findByParent(ActExecution parent);

	/**
	 * Find by ID of reference: parent.id
	 */
	public List<ActExecution> findByParentId(String parentId);

	/**
	 * Find by reference: processDefinition
	 */
	public List<ActExecution> findByProcessDefinition(
			ActProcessDefinition processDefinition);

	/**
	 * Find by ID of reference: processDefinition.id
	 */
	public List<ActExecution> findByProcessDefinitionId(
			String processDefinitionId);
}
