/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;

/**
 * Interface to expose business functions specific for {@link ActProcessDefinition} domain
 * entity.
 */
public interface IActProcessDefinitionService
		extends
			IEntityService<ActProcessDefinition> {

	/**
	 * Find by reference: deployment
	 */
	public List<ActProcessDefinition> findByDeployment(ActDeployment deployment);

	/**
	 * Find by ID of reference: deployment.id
	 */
	public List<ActProcessDefinition> findByDeploymentId(String deploymentId);
}
