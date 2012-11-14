/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IProjectTypeService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectCategory;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

/**
 * Repository functionality for {@link ProjectType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProjectTypeService extends AbstractEntityService<ProjectType>
		implements
			IProjectTypeService {

	public ProjectTypeService() {
		super();
	}

	public ProjectTypeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ProjectType> getEntityClass() {
		return ProjectType.class;
	}

	/**
	 * Find by unique key
	 */
	public ProjectType findByName(String name) {
		return (ProjectType) this.em
				.createNamedQuery(ProjectType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: category
	 */
	public List<ProjectType> findByCategory(ProjectCategory category) {
		return this.findByCategoryId(category.getId());
	}

	/**
	 * Find by ID of reference: category.id
	 */
	public List<ProjectType> findByCategoryId(Long categoryId) {
		return (List<ProjectType>) this.em
				.createQuery(
						"select e from ProjectType e where e.clientId = :pClientId and e.category.id = :pCategoryId",
						ProjectType.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCategoryId", categoryId).getResultList();
	}

	/**
	 * Find by reference: projectRoles
	 */
	public List<ProjectType> findByProjectRoles(ProjectRole projectRoles) {
		return this.findByProjectRolesId(projectRoles.getId());
	}

	/**
	 * Find by ID of reference: projectRoles.id
	 */
	public List<ProjectType> findByProjectRolesId(Long projectRolesId) {
		return (List<ProjectType>) this.em
				.createQuery(
						"select distinct e from ProjectType e, IN (e.projectRoles) c where e.clientId = :pClientId and c.id = :pProjectRolesId",
						ProjectType.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProjectRolesId", projectRolesId)
				.getResultList();
	}

	/**
	 * Find by reference: itemTypes
	 */
	public List<ProjectType> findByItemTypes(IssueType itemTypes) {
		return this.findByItemTypesId(itemTypes.getId());
	}

	/**
	 * Find by ID of reference: itemTypes.id
	 */
	public List<ProjectType> findByItemTypesId(Long itemTypesId) {
		return (List<ProjectType>) this.em
				.createQuery(
						"select distinct e from ProjectType e, IN (e.itemTypes) c where e.clientId = :pClientId and c.id = :pItemTypesId",
						ProjectType.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pItemTypesId", itemTypesId).getResultList();
	}
}
