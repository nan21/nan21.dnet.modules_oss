/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActTaskInstanceHistory;

/**
 * Interface to expose business functions specific for {@link ActTaskInstanceHistory} domain
 * entity.
 */
public interface IActTaskInstanceHistoryService
		extends
			IEntityService<ActTaskInstanceHistory> {

	/**
	 * Find by reference: processDefinition
	 */
	public List<ActTaskInstanceHistory> findByProcessDefinition(
			ActProcessDefinition processDefinition);

	/**
	 * Find by ID of reference: processDefinition.id
	 */
	public List<ActTaskInstanceHistory> findByProcessDefinitionId(
			String processDefinitionId);

	/**
	 * Find by reference: parent
	 */
	public List<ActTaskInstanceHistory> findByParent(
			ActTaskInstanceHistory parent);

	/**
	 * Find by ID of reference: parent.id
	 */
	public List<ActTaskInstanceHistory> findByParentId(String parentId);
}
