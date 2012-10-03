/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

public interface IProjectRoleService extends IEntityService<ProjectRole> {
	
	public ProjectRole findByName(String name);
	
	public List<ProjectRole> findByProjectTypes(ProjectType projectTypes);
	
	public List<ProjectRole> findByProjectTypesId(Long projectTypesId);
	
}
