/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.elem.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementInput;

/**
 * Interface to expose business functions specific for {@link ElementInput} domain
 * entity.
 */
public interface IElementInputService extends IEntityService<ElementInput> {

	/**
	 * Find by reference: element
	 */
	public List<ElementInput> findByElement(Element element);

	/**
	 * Find by ID of reference: element.id
	 */
	public List<ElementInput> findByElementId(Long elementId);

	/**
	 * Find by reference: crossReference
	 */
	public List<ElementInput> findByCrossReference(Element crossReference);

	/**
	 * Find by ID of reference: crossReference.id
	 */
	public List<ElementInput> findByCrossReferenceId(Long crossReferenceId);
}
