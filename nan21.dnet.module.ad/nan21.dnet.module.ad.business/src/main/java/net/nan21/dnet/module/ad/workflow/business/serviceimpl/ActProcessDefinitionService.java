/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActProcessDefinitionService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;


public class ActProcessDefinitionService extends AbstractEntityService<ActProcessDefinition>
		implements IActProcessDefinitionService {
 
	public ActProcessDefinitionService() {
		super();
	}

	public ActProcessDefinitionService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ActProcessDefinition> getEntityClass() {
		return ActProcessDefinition.class;
	}
	
	public List<ActProcessDefinition> findByDeployment(ActDeployment deployment) {
		return this.findByDeploymentId(deployment.getId()); 
	}
	
	public List<ActProcessDefinition> findByDeploymentId(String deploymentId) {
		return (List<ActProcessDefinition>) this.em
			.createQuery("select e from ActProcessDefinition e where  e.deployment.id = :pDeploymentId", ActProcessDefinition.class)
					.setParameter("pDeploymentId", deploymentId)			 	
			.getResultList(); 
	}
}
