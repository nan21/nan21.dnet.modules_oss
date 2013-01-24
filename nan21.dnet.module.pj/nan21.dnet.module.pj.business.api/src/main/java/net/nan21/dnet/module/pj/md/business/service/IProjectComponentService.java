/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectComponent;

/**
 * Interface to expose business functions specific for {@link ProjectComponent} domain
 * entity.
 */
public interface IProjectComponentService
		extends
			IEntityService<ProjectComponent> {

	/**
	 * Find by unique key
	 */
	public ProjectComponent findByName(Project project, String name);

	/**
	 * Find by unique key
	 */
	public ProjectComponent findByName(Long projectId, String name);

	/**
	 * Find by reference: componentLead
	 */
	public List<ProjectComponent> findByComponentLead(Assignable componentLead);

	/**
	 * Find by ID of reference: componentLead.id
	 */
	public List<ProjectComponent> findByComponentLeadId(Long componentLeadId);

	/**
	 * Find by reference: project
	 */
	public List<ProjectComponent> findByProject(Project project);

	/**
	 * Find by ID of reference: project.id
	 */
	public List<ProjectComponent> findByProjectId(Long projectId);

	/**
	 * Find by reference: affectingIssues
	 */
	public List<ProjectComponent> findByAffectingIssues(Issue affectingIssues);

	/**
	 * Find by ID of reference: affectingIssues.id
	 */
	public List<ProjectComponent> findByAffectingIssuesId(Long affectingIssuesId);
}
