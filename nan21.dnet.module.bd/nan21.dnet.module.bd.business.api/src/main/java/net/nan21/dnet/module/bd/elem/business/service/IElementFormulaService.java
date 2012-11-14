/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.elem.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementFormula;

/**
 * Interface to expose business functions specific for {@link ElementFormula} domain
 * entity.
 */
public interface IElementFormulaService extends IEntityService<ElementFormula> {

	/**
	 * Find by reference: element
	 */
	public List<ElementFormula> findByElement(Element element);

	/**
	 * Find by ID of reference: element.id
	 */
	public List<ElementFormula> findByElementId(Long elementId);
}
