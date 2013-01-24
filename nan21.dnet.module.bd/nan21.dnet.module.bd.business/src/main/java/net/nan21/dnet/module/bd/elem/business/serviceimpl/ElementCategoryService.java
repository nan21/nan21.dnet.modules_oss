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
import net.nan21.dnet.module.bd.elem.business.service.IElementCategoryService;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementCategory;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

/**
 * Repository functionality for {@link ElementCategory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ElementCategoryService
		extends
			AbstractEntityService<ElementCategory>
		implements
			IElementCategoryService {

	public ElementCategoryService() {
		super();
	}

	public ElementCategoryService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ElementCategory> getEntityClass() {
		return ElementCategory.class;
	}

	/**
	 * Find by unique key
	 */
	public ElementCategory findByEngine_name(Engine engine, String name) {
		return (ElementCategory) this.getEntityManager()
				.createNamedQuery(ElementCategory.NQ_FIND_BY_ENGINE_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEngine", engine).setParameter("pName", name)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ElementCategory findByEngine_name(Long engineId, String name) {
		return (ElementCategory) this
				.getEntityManager()
				.createNamedQuery(
						ElementCategory.NQ_FIND_BY_ENGINE_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEngineId", engineId)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: engine
	 */
	public List<ElementCategory> findByEngine(Engine engine) {
		return this.findByEngineId(engine.getId());
	}

	/**
	 * Find by ID of reference: engine.id
	 */
	public List<ElementCategory> findByEngineId(Long engineId) {
		return (List<ElementCategory>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementCategory e where e.clientId = :pClientId and e.engine.id = :pEngineId",
						ElementCategory.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEngineId", engineId).getResultList();
	}
}
