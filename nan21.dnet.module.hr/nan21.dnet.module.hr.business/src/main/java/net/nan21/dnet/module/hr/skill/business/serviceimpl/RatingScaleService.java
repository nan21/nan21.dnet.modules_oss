/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.skill.business.service.IRatingScaleService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;


public class RatingScaleService extends AbstractEntityService<RatingScale>
		implements IRatingScaleService {
 
	public RatingScaleService() {
		super();
	}

	public RatingScaleService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<RatingScale> getEntityClass() {
		return RatingScale.class;
	}
	
	public RatingScale findByName(String name) {		 
		return (RatingScale) this.em
			.createNamedQuery(RatingScale.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
}
