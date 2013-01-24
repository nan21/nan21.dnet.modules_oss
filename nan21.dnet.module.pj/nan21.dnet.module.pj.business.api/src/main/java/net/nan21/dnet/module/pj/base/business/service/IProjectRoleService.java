/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

/**
 * Interface to expose business functions specific for {@link ProjectRole} domain
 * entity.
 */
public interface IProjectRoleService extends IEntityService<ProjectRole> {

	/**
	 * Find by unique key
	 */
	public ProjectRole findByName(String name);

	/**
	 * Find by reference: projectTypes
	 */
	public List<ProjectRole> findByProjectTypes(ProjectType projectTypes);

	/**
	 * Find by ID of reference: projectTypes.id
	 */
	public List<ProjectRole> findByProjectTypesId(Long projectTypesId);
}
