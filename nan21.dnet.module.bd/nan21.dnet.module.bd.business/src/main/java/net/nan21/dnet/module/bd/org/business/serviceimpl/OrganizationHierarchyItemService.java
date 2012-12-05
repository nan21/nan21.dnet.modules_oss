/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.org.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationHierarchyItemService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchy;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchyItem;

/**
 * Repository functionality for {@link OrganizationHierarchyItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class OrganizationHierarchyItemService
		extends
			AbstractEntityService<OrganizationHierarchyItem>
		implements
			IOrganizationHierarchyItemService {

	public OrganizationHierarchyItemService() {
		super();
	}

	public OrganizationHierarchyItemService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<OrganizationHierarchyItem> getEntityClass() {
		return OrganizationHierarchyItem.class;
	}

	/**
	 * Find by reference: hierarchy
	 */
	public List<OrganizationHierarchyItem> findByHierarchy(
			OrganizationHierarchy hierarchy) {
		return this.findByHierarchyId(hierarchy.getId());
	}

	/**
	 * Find by ID of reference: hierarchy.id
	 */
	public List<OrganizationHierarchyItem> findByHierarchyId(Long hierarchyId) {
		return (List<OrganizationHierarchyItem>) this
				.getEntityManager()
				.createQuery(
						"select e from OrganizationHierarchyItem e where e.clientId = :pClientId and e.hierarchy.id = :pHierarchyId",
						OrganizationHierarchyItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pHierarchyId", hierarchyId).getResultList();
	}

	/**
	 * Find by reference: org
	 */
	public List<OrganizationHierarchyItem> findByOrg(Organization org) {
		return this.findByOrgId(org.getId());
	}

	/**
	 * Find by ID of reference: org.id
	 */
	public List<OrganizationHierarchyItem> findByOrgId(Long orgId) {
		return (List<OrganizationHierarchyItem>) this
				.getEntityManager()
				.createQuery(
						"select e from OrganizationHierarchyItem e where e.clientId = :pClientId and e.org.id = :pOrgId",
						OrganizationHierarchyItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOrgId", orgId).getResultList();
	}

	/**
	 * Find by reference: parent
	 */
	public List<OrganizationHierarchyItem> findByParent(Organization parent) {
		return this.findByParentId(parent.getId());
	}

	/**
	 * Find by ID of reference: parent.id
	 */
	public List<OrganizationHierarchyItem> findByParentId(Long parentId) {
		return (List<OrganizationHierarchyItem>) this
				.getEntityManager()
				.createQuery(
						"select e from OrganizationHierarchyItem e where e.clientId = :pClientId and e.parent.id = :pParentId",
						OrganizationHierarchyItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pParentId", parentId).getResultList();
	}
}
