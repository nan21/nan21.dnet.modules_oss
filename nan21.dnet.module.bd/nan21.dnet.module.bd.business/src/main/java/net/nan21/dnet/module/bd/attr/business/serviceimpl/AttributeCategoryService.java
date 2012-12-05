/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.attr.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.attr.business.service.IAttributeCategoryService;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeCategory;

/**
 * Repository functionality for {@link AttributeCategory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AttributeCategoryService
		extends
			AbstractEntityService<AttributeCategory>
		implements
			IAttributeCategoryService {

	public AttributeCategoryService() {
		super();
	}

	public AttributeCategoryService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AttributeCategory> getEntityClass() {
		return AttributeCategory.class;
	}

	/**
	 * Find by unique key
	 */
	public AttributeCategory findByName(String name) {
		return (AttributeCategory) this.getEntityManager()
				.createNamedQuery(AttributeCategory.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
