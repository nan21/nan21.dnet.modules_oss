/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.org.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationTypeService;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationType;

/**
 * Repository functionality for {@link OrganizationType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class OrganizationTypeService
		extends
			AbstractEntityService<OrganizationType>
		implements
			IOrganizationTypeService {

	public OrganizationTypeService() {
		super();
	}

	public OrganizationTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<OrganizationType> getEntityClass() {
		return OrganizationType.class;
	}

	/**
	 * Find by unique key
	 */
	public OrganizationType findByName(String name) {
		return (OrganizationType) this.getEntityManager()
				.createNamedQuery(OrganizationType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
