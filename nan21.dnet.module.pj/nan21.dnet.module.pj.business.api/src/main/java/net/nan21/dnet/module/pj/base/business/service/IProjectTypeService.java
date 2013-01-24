/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectCategory;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

/**
 * Interface to expose business functions specific for {@link ProjectType} domain
 * entity.
 */
public interface IProjectTypeService extends IEntityService<ProjectType> {

	/**
	 * Find by unique key
	 */
	public ProjectType findByName(String name);

	/**
	 * Find by reference: category
	 */
	public List<ProjectType> findByCategory(ProjectCategory category);

	/**
	 * Find by ID of reference: category.id
	 */
	public List<ProjectType> findByCategoryId(Long categoryId);

	/**
	 * Find by reference: projectRoles
	 */
	public List<ProjectType> findByProjectRoles(ProjectRole projectRoles);

	/**
	 * Find by ID of reference: projectRoles.id
	 */
	public List<ProjectType> findByProjectRolesId(Long projectRolesId);

	/**
	 * Find by reference: itemTypes
	 */
	public List<ProjectType> findByItemTypes(IssueType itemTypes);

	/**
	 * Find by ID of reference: itemTypes.id
	 */
	public List<ProjectType> findByItemTypesId(Long itemTypesId);
}
