/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.org.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationHierarchyService;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchy;

/**
 * Repository functionality for {@link OrganizationHierarchy} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class OrganizationHierarchyService
		extends
			AbstractEntityService<OrganizationHierarchy>
		implements
			IOrganizationHierarchyService {

	public OrganizationHierarchyService() {
		super();
	}

	public OrganizationHierarchyService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<OrganizationHierarchy> getEntityClass() {
		return OrganizationHierarchy.class;
	}

	/**
	 * Find by unique key
	 */
	public OrganizationHierarchy findByName(String name) {
		return (OrganizationHierarchy) this.em
				.createNamedQuery(OrganizationHierarchy.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
