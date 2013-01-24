/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.elem.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.elem.business.service.IElementTypeService;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementCategory;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementType;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

/**
 * Repository functionality for {@link ElementType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ElementTypeService extends AbstractEntityService<ElementType>
		implements
			IElementTypeService {

	public ElementTypeService() {
		super();
	}

	public ElementTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ElementType> getEntityClass() {
		return ElementType.class;
	}

	/**
	 * Find by unique key
	 */
	public ElementType findByEngine_name(Engine engine, String name) {
		return (ElementType) this.getEntityManager()
				.createNamedQuery(ElementType.NQ_FIND_BY_ENGINE_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEngine", engine).setParameter("pName", name)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ElementType findByEngine_name(Long engineId, String name) {
		return (ElementType) this.getEntityManager()
				.createNamedQuery(ElementType.NQ_FIND_BY_ENGINE_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEngineId", engineId)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: engine
	 */
	public List<ElementType> findByEngine(Engine engine) {
		return this.findByEngineId(engine.getId());
	}

	/**
	 * Find by ID of reference: engine.id
	 */
	public List<ElementType> findByEngineId(Long engineId) {
		return (List<ElementType>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementType e where e.clientId = :pClientId and e.engine.id = :pEngineId",
						ElementType.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEngineId", engineId).getResultList();
	}

	/**
	 * Find by reference: category
	 */
	public List<ElementType> findByCategory(ElementCategory category) {
		return this.findByCategoryId(category.getId());
	}

	/**
	 * Find by ID of reference: category.id
	 */
	public List<ElementType> findByCategoryId(Long categoryId) {
		return (List<ElementType>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementType e where e.clientId = :pClientId and e.category.id = :pCategoryId",
						ElementType.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCategoryId", categoryId).getResultList();
	}
}
