/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;

/**
 * Interface to expose business functions specific for {@link WfDefProcess} domain
 * entity.
 */
public interface IWfDefProcessService extends IEntityService<WfDefProcess> {

	/**
	 * Find by unique key
	 */
	public WfDefProcess findByName(String name);

	/**
	 * Find by reference: nodes
	 */
	public List<WfDefProcess> findByNodes(WfDefNode nodes);

	/**
	 * Find by ID of reference: nodes.id
	 */
	public List<WfDefProcess> findByNodesId(Long nodesId);
}
