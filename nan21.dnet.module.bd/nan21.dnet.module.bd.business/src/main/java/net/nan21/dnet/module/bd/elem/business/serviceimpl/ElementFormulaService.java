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
import net.nan21.dnet.module.bd.elem.business.service.IElementFormulaService;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementFormula;

/**
 * Repository functionality for {@link ElementFormula} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ElementFormulaService
		extends
			AbstractEntityService<ElementFormula>
		implements
			IElementFormulaService {

	public ElementFormulaService() {
		super();
	}

	public ElementFormulaService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ElementFormula> getEntityClass() {
		return ElementFormula.class;
	}

	/**
	 * Find by reference: element
	 */
	public List<ElementFormula> findByElement(Element element) {
		return this.findByElementId(element.getId());
	}

	/**
	 * Find by ID of reference: element.id
	 */
	public List<ElementFormula> findByElementId(Long elementId) {
		return (List<ElementFormula>) this
				.getEntityManager()
				.createQuery(
						"select e from ElementFormula e where e.clientId = :pClientId and e.element.id = :pElementId",
						ElementFormula.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pElementId", elementId).getResultList();
	}
}
