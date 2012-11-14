/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchy;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchyItem;

/**
 * Interface to expose business functions specific for {@link OrganizationHierarchyItem} domain
 * entity.
 */
public interface IOrganizationHierarchyItemService
		extends
			IEntityService<OrganizationHierarchyItem> {

	/**
	 * Find by reference: hierarchy
	 */
	public List<OrganizationHierarchyItem> findByHierarchy(
			OrganizationHierarchy hierarchy);

	/**
	 * Find by ID of reference: hierarchy.id
	 */
	public List<OrganizationHierarchyItem> findByHierarchyId(Long hierarchyId);

	/**
	 * Find by reference: org
	 */
	public List<OrganizationHierarchyItem> findByOrg(Organization org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<OrganizationHierarchyItem> findByOrgId(Long orgId);

	/**
	 * Find by reference: parent
	 */
	public List<OrganizationHierarchyItem> findByParent(Organization parent);

	/**
	 * Find by ID of reference: parent.id
	 */
	public List<OrganizationHierarchyItem> findByParentId(Long parentId);
}
