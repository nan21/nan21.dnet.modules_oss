/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActActivityInstanceHistoryService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActActivityInstanceHistory;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProcessDefinition;


public class ActActivityInstanceHistoryService extends AbstractEntityService<ActActivityInstanceHistory>
		implements IActActivityInstanceHistoryService {
 
	public ActActivityInstanceHistoryService() {
		super();
	}

	public ActActivityInstanceHistoryService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ActActivityInstanceHistory> getEntityClass() {
		return ActActivityInstanceHistory.class;
	}
	
	public List<ActActivityInstanceHistory> findByProcessDefinition(ActProcessDefinition processDefinition) {
		return this.findByProcessDefinitionId(processDefinition.getId()); 
	}
	
	public List<ActActivityInstanceHistory> findByProcessDefinitionId(String processDefinitionId) {
		return (List<ActActivityInstanceHistory>) this.em
			.createQuery("select e from ActActivityInstanceHistory e where  e.processDefinition.id = :pProcessDefinitionId", ActActivityInstanceHistory.class)
					.setParameter("pProcessDefinitionId", processDefinitionId)			 	
			.getResultList(); 
	}
}
