/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActByteArrayService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActByteArray;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;

/**
 * Repository functionality for {@link ActByteArray} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ActByteArrayService extends AbstractEntityService<ActByteArray>
		implements
			IActByteArrayService {

	public ActByteArrayService() {
		super();
	}

	public ActByteArrayService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ActByteArray> getEntityClass() {
		return ActByteArray.class;
	}

	/**
	 * Find by reference: deployment
	 */
	public List<ActByteArray> findByDeployment(ActDeployment deployment) {
		return this.findByDeploymentId(deployment.getId());
	}

	/**
	 * Find by ID of reference: deployment.id
	 */
	public List<ActByteArray> findByDeploymentId(String deploymentId) {
		return (List<ActByteArray>) this
				.getEntityManager()
				.createQuery(
						"select e from ActByteArray e where  e.deployment.id = :pDeploymentId",
						ActByteArray.class)
				.setParameter("pDeploymentId", deploymentId).getResultList();
	}
}
