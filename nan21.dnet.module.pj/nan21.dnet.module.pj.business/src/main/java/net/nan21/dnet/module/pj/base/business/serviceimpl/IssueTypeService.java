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
import net.nan21.dnet.module.pj.base.business.service.IIssueTypeService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueCategory;
import net.nan21.dnet.module.pj.base.domain.entity.IssueType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

/**
 * Repository functionality for {@link IssueType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class IssueTypeService extends AbstractEntityService<IssueType>
		implements
			IIssueTypeService {

	public IssueTypeService() {
		super();
	}

	public IssueTypeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<IssueType> getEntityClass() {
		return IssueType.class;
	}

	/**
	 * Find by unique key
	 */
	public IssueType findByName(String name) {
		return (IssueType) this.em.createNamedQuery(IssueType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: category
	 */
	public List<IssueType> findByCategory(IssueCategory category) {
		return this.findByCategoryId(category.getId());
	}

	/**
	 * Find by ID of reference: category.id
	 */
	public List<IssueType> findByCategoryId(Long categoryId) {
		return (List<IssueType>) this.em
				.createQuery(
						"select e from IssueType e where e.clientId = :pClientId and e.category.id = :pCategoryId",
						IssueType.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCategoryId", categoryId).getResultList();
	}

	/**
	 * Find by reference: projectTypes
	 */
	public List<IssueType> findByProjectTypes(ProjectType projectTypes) {
		return this.findByProjectTypesId(projectTypes.getId());
	}

	/**
	 * Find by ID of reference: projectTypes.id
	 */
	public List<IssueType> findByProjectTypesId(Long projectTypesId) {
		return (List<IssueType>) this.em
				.createQuery(
						"select distinct e from IssueType e, IN (e.projectTypes) c where e.clientId = :pClientId and c.id = :pProjectTypesId",
						IssueType.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProjectTypesId", projectTypesId)
				.getResultList();
	}
}
