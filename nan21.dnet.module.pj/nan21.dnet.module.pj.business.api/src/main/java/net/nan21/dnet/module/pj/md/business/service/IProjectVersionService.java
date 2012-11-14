/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

/**
 * Interface to expose business functions specific for {@link ProjectVersion} domain
 * entity.
 */
public interface IProjectVersionService extends IEntityService<ProjectVersion> {

	/**
	 * Find by unique key
	 */
	public ProjectVersion findByName(Project project, String name);

	/**
	 * Find by unique key
	 */
	public ProjectVersion findByName(Long projectId, String name);

	/**
	 * Find by reference: project
	 */
	public List<ProjectVersion> findByProject(Project project);

	/**
	 * Find by ID of reference: project.id
	 */
	public List<ProjectVersion> findByProjectId(Long projectId);

	/**
	 * Find by reference: affectingIssues
	 */
	public List<ProjectVersion> findByAffectingIssues(Issue affectingIssues);

	/**
	 * Find by ID of reference: affectingIssues.id
	 */
	public List<ProjectVersion> findByAffectingIssuesId(Long affectingIssuesId);
}
