/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActActivityInstanceHistory;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

/**
 * Interface to expose business functions specific for {@link ActActivityInstanceHistory} domain
 * entity.
 */
public interface IActActivityInstanceHistoryService
		extends
			IEntityService<ActActivityInstanceHistory> {

	/**
	 * Find by reference: processDefinition
	 */
	public List<ActActivityInstanceHistory> findByProcessDefinition(
			ActProcessDefinition processDefinition);

	/**
	 * Find by ID of reference: processDefinition.id
	 */
	public List<ActActivityInstanceHistory> findByProcessDefinitionId(
			String processDefinitionId);
}
