/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActTask;

/**
 * Interface to expose business functions specific for {@link ActTask} domain
 * entity.
 */
public interface IActTaskService extends IEntityService<ActTask> {

	/**
	 * Find by reference: processDefinition
	 */
	public List<ActTask> findByProcessDefinition(
			ActProcessDefinition processDefinition);

	/**
	 * Find by ID of reference: processDefinition.id
	 */
	public List<ActTask> findByProcessDefinitionId(String processDefinitionId);

	/**
	 * Find by reference: parent
	 */
	public List<ActTask> findByParent(ActTask parent);

	/**
	 * Find by ID of reference: parent.id
	 */
	public List<ActTask> findByParentId(String parentId);
}
