/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueLinkTypeService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueLinkType;

/**
 * Repository functionality for {@link IssueLinkType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class IssueLinkTypeService extends AbstractEntityService<IssueLinkType>
		implements
			IIssueLinkTypeService {

	public IssueLinkTypeService() {
		super();
	}

	public IssueLinkTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<IssueLinkType> getEntityClass() {
		return IssueLinkType.class;
	}

	/**
	 * Find by unique key
	 */
	public IssueLinkType findByName(String name) {
		return (IssueLinkType) this.getEntityManager()
				.createNamedQuery(IssueLinkType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
