/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.elem.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementSet;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementSetElement;

/**
 * Interface to expose business functions specific for {@link ElementSetElement} domain
 * entity.
 */
public interface IElementSetElementService
		extends
			IEntityService<ElementSetElement> {

	/**
	 * Find by unique key
	 */
	public ElementSetElement findBySet_elem(ElementSet elementSet,
			Element element);

	/**
	 * Find by unique key
	 */
	public ElementSetElement findBySet_elem(Long elementSetId, Long elementId);

	/**
	 * Find by reference: elementSet
	 */
	public List<ElementSetElement> findByElementSet(ElementSet elementSet);

	/**
	 * Find by ID of reference: elementSet.id
	 */
	public List<ElementSetElement> findByElementSetId(Long elementSetId);

	/**
	 * Find by reference: element
	 */
	public List<ElementSetElement> findByElement(Element element);

	/**
	 * Find by ID of reference: element.id
	 */
	public List<ElementSetElement> findByElementId(Long elementId);
}
