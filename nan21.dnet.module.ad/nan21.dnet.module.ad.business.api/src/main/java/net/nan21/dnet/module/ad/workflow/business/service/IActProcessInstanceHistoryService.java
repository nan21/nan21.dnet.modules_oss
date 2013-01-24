/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessInstanceHistory;

/**
 * Interface to expose business functions specific for {@link ActProcessInstanceHistory} domain
 * entity.
 */
public interface IActProcessInstanceHistoryService
		extends
			IEntityService<ActProcessInstanceHistory> {

	/**
	 * Find by reference: processDefinition
	 */
	public List<ActProcessInstanceHistory> findByProcessDefinition(
			ActProcessDefinition processDefinition);

	/**
	 * Find by ID of reference: processDefinition.id
	 */
	public List<ActProcessInstanceHistory> findByProcessDefinitionId(
			String processDefinitionId);
}
