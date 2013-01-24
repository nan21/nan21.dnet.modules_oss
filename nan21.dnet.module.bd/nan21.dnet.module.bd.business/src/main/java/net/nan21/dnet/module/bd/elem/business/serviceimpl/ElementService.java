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
import net.nan21.dnet.module.bd.elem.business.service.IElementService;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementFormula;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementInput;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementType;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

/**
 * Repository functionality for {@link Element} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ElementService extends AbstractEntityService<Element>
		implements
			IElementService {

	public ElementService() {
		super();
	}

	public ElementService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Element> getEntityClass() {
		return Element.class;
	}

	/**
	 * Find by unique key
	 */
	public Element findByEngine_code(Engine engine, String code) {
		return (Element) this.getEntityManager()
				.createNamedQuery(Element.NQ_FIND_BY_ENGINE_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEngine", engine).setParameter("pCode", code)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public Element findByEngine_code(Long engineId, String code) {
		return (Element) this.getEntityManager()
				.createNamedQuery(Element.NQ_FIND_BY_ENGINE_CODE_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEngineId", engineId)
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by reference: engine
	 */
	public List<Element> findByEngine(Engine engine) {
		return this.findByEngineId(engine.getId());
	}

	/**
	 * Find by ID of reference: engine.id
	 */
	public List<Element> findByEngineId(Long engineId) {
		return (List<Element>) this
				.getEntityManager()
				.createQuery(
						"select e from Element e where e.clientId = :pClientId and e.engine.id = :pEngineId",
						Element.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEngineId", engineId).getResultList();
	}

	/**
	 * Find by reference: type
	 */
	public List<Element> findByType(ElementType type) {
		return this.findByTypeId(type.getId());
	}

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Element> findByTypeId(Long typeId) {
		return (List<Element>) this
				.getEntityManager()
				.createQuery(
						"select e from Element e where e.clientId = :pClientId and e.type.id = :pTypeId",
						Element.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTypeId", typeId).getResultList();
	}

	/**
	 * Find by reference: variables
	 */
	public List<Element> findByVariables(ElementInput variables) {
		return this.findByVariablesId(variables.getId());
	}

	/**
	 * Find by ID of reference: variables.id
	 */
	public List<Element> findByVariablesId(Long variablesId) {
		return (List<Element>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Element e, IN (e.variables) c where e.clientId = :pClientId and c.id = :pVariablesId",
						Element.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pVariablesId", variablesId).getResultList();
	}

	/**
	 * Find by reference: formulas
	 */
	public List<Element> findByFormulas(ElementFormula formulas) {
		return this.findByFormulasId(formulas.getId());
	}

	/**
	 * Find by ID of reference: formulas.id
	 */
	public List<Element> findByFormulasId(Long formulasId) {
		return (List<Element>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Element e, IN (e.formulas) c where e.clientId = :pClientId and c.id = :pFormulasId",
						Element.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFormulasId", formulasId).getResultList();
	}
}
