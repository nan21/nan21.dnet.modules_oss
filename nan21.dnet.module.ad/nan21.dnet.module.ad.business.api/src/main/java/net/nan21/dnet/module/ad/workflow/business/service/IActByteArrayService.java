/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActByteArray;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;

/**
 * Interface to expose business functions specific for {@link ActByteArray} domain
 * entity.
 */
public interface IActByteArrayService extends IEntityService<ActByteArray> {

	/**
	 * Find by reference: deployment
	 */
	public List<ActByteArray> findByDeployment(ActDeployment deployment);

	/**
	 * Find by ID of reference: deployment.id
	 */
	public List<ActByteArray> findByDeploymentId(String deploymentId);
}
