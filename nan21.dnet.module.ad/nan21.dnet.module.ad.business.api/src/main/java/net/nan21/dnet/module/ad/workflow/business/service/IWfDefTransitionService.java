/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefNode;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefProcess;
import net.nan21.dnet.module.ad.workflow.domain.entity.WfDefTransition;

/**
 * Interface to expose business functions specific for {@link WfDefTransition} domain
 * entity.
 */
public interface IWfDefTransitionService
		extends
			IEntityService<WfDefTransition> {

	/**
	 * Find by reference: process
	 */
	public List<WfDefTransition> findByProcess(WfDefProcess process);

	/**
	 * Find by ID of reference: process.id
	 */
	public List<WfDefTransition> findByProcessId(Long processId);

	/**
	 * Find by reference: source
	 */
	public List<WfDefTransition> findBySource(WfDefNode source);

	/**
	 * Find by ID of reference: source.id
	 */
	public List<WfDefTransition> findBySourceId(Long sourceId);

	/**
	 * Find by reference: target
	 */
	public List<WfDefTransition> findByTarget(WfDefNode target);

	/**
	 * Find by ID of reference: target.id
	 */
	public List<WfDefTransition> findByTargetId(Long targetId);
}
