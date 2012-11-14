/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

/**
 * Interface to expose business functions specific for {@link Project} domain
 * entity.
 */
public interface IProjectService extends IEntityService<Project> {

	/**
	 * Find by unique key
	 */
	public Project findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Project findByName(String name);

	/**
	 * Find by reference: type
	 */
	public List<Project> findByType(ProjectType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Project> findByTypeId(Long typeId);

	/**
	 * Find by reference: projectLead
	 */
	public List<Project> findByProjectLead(ProjectMember projectLead);

	/**
	 * Find by ID of reference: projectLead.id
	 */
	public List<Project> findByProjectLeadId(Long projectLeadId);
}
