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

/**
 * Repository functionality for {@link RatingScale} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class RatingScaleService extends AbstractEntityService<RatingScale>
		implements
			IRatingScaleService {

	public RatingScaleService() {
		super();
	}

	public RatingScaleService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<RatingScale> getEntityClass() {
		return RatingScale.class;
	}

	/**
	 * Find by unique key
	 */
	public RatingScale findByName(String name) {
		return (RatingScale) this.getEntityManager()
				.createNamedQuery(RatingScale.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
