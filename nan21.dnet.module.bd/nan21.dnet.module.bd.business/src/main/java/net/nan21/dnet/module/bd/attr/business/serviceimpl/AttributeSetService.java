/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.attr.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.attr.business.service.IAttributeSetService;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;

/**
 * Repository functionality for {@link AttributeSet} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AttributeSetService extends AbstractEntityService<AttributeSet>
		implements
			IAttributeSetService {

	public AttributeSetService() {
		super();
	}

	public AttributeSetService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AttributeSet> getEntityClass() {
		return AttributeSet.class;
	}

	/**
	 * Find by unique key
	 */
	public AttributeSet findByName(String name) {
		return (AttributeSet) this.getEntityManager()
				.createNamedQuery(AttributeSet.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
