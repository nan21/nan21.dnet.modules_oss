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
import net.nan21.dnet.module.bd.elem.business.service.IElementSetElementService;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementSet;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementSetElement;

/**
 * Repository functionality for {@link ElementSetElement} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ElementSetElementService
		extends
			AbstractEntityService<ElementSetElement>
		implements
			IElementSetElementService {

	public ElementSetElementService() {
		super();
	}

	public ElementSetElementService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ElementSetElement> getEntityClass() {
		return ElementSetElement.class;
	}

	/**
	 * Find by unique key
	 */
	public ElementSetElement findBySet_elem(ElementSet elementSet,
			Element element) {
		return (ElementSetElement) this.getEntityManager()
				.createNamedQuery(ElementSetElement.NQ_FIND_BY_SET_ELEM)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pElementSet", elementSet)
				.setParameter("pElement", element).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ElementSetElement findBySet_elem(Long elementSetId, Long elementId) {
		return (ElementSetElement) this
				.getEntityManager()
				.createNamedQuery(
						ElementSetElement.NQ_FIND_BY_SET_ELEM_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pElementSetId", elementSetId)
				.setParameter("pElementId", elementId).getSingleResult();
	}

	/**
	 * Find by reference: elementSet
	 */
	public List<ElementSetElement> findByElementSet(ElementSet elementSet) {
		return this.findByElementSetId(elementSet.getId());
	}

	/**
	 * Find by ID of reference: elementSet.id
	 */
	public List<ElementSetElement> findByElementSetId(Long elementSetId) {
		return (List<ElementSetElement>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementSetElement e where e.clientId = :pClientId and e.elementSet.id = :pElementSetId",
						ElementSetElement.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pElementSetId", elementSetId).getResultList();
	}

	/**
	 * Find by reference: element
	 */
	public List<ElementSetElement> findByElement(Element element) {
		return this.findByElementId(element.getId());
	}

	/**
	 * Find by ID of reference: element.id
	 */
	public List<ElementSetElement> findByElementId(Long elementId) {
		return (List<ElementSetElement>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementSetElement e where e.clientId = :pClientId and e.element.id = :pElementId",
						ElementSetElement.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pElementId", elementId).getResultList();
	}
}
