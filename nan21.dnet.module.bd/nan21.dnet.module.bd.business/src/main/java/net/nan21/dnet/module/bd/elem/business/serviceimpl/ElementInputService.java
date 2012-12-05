/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.elem.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.elem.business.service.IElementInputService;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementInput;

/**
 * Repository functionality for {@link ElementInput} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ElementInputService extends AbstractEntityService<ElementInput>
		implements
			IElementInputService {

	public ElementInputService() {
		super();
	}

	public ElementInputService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ElementInput> getEntityClass() {
		return ElementInput.class;
	}

	/**
	 * Find by reference: element
	 */
	public List<ElementInput> findByElement(Element element) {
		return this.findByElementId(element.getId());
	}

	/**
	 * Find by ID of reference: element.id
	 */
	public List<ElementInput> findByElementId(Long elementId) {
		return (List<ElementInput>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementInput e where e.clientId = :pClientId and e.element.id = :pElementId",
						ElementInput.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pElementId", elementId).getResultList();
	}

	/**
	 * Find by reference: crossReference
	 */
	public List<ElementInput> findByCrossReference(Element crossReference) {
		return this.findByCrossReferenceId(crossReference.getId());
	}

	/**
	 * Find by ID of reference: crossReference.id
	 */
	public List<ElementInput> findByCrossReferenceId(Long crossReferenceId) {
		return (List<ElementInput>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementInput e where e.clientId = :pClientId and e.crossReference.id = :pCrossReferenceId",
						ElementInput.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCrossReferenceId", crossReferenceId)
				.getResultList();
	}
}
