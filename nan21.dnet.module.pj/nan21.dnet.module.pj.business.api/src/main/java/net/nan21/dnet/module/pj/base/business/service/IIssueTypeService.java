/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueCategory;
import net.nan21.dnet.module.pj.base.domain.entity.IssueType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

/**
 * Interface to expose business functions specific for {@link IssueType} domain
 * entity.
 */
public interface IIssueTypeService extends IEntityService<IssueType> {

	/**
	 * Find by unique key
	 */
	public IssueType findByName(String name);

	/**
	 * Find by reference: category
	 */
	public List<IssueType> findByCategory(IssueCategory category);

	/**
	 * Find by ID of reference: category.id
	 */
	public List<IssueType> findByCategoryId(Long categoryId);

	/**
	 * Find by reference: projectTypes
	 */
	public List<IssueType> findByProjectTypes(ProjectType projectTypes);

	/**
	 * Find by ID of reference: projectTypes.id
	 */
	public List<IssueType> findByProjectTypesId(Long projectTypesId);
}
