/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.elem.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementFormula;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementInput;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementType;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

/**
 * Interface to expose business functions specific for {@link Element} domain
 * entity.
 */
public interface IElementService extends IEntityService<Element> {

	/**
	 * Find by unique key
	 */
	public Element findByEngine_code(Engine engine, String code);

	/**
	 * Find by unique key
	 */
	public Element findByEngine_code(Long engineId, String code);

	/**
	 * Find by reference: engine
	 */
	public List<Element> findByEngine(Engine engine);

	/**
	 * Find by ID of reference: engine.id
	 */
	public List<Element> findByEngineId(Long engineId);

	/**
	 * Find by reference: type
	 */
	public List<Element> findByType(ElementType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Element> findByTypeId(Long typeId);

	/**
	 * Find by reference: variables
	 */
	public List<Element> findByVariables(ElementInput variables);

	/**
	 * Find by ID of reference: variables.id
	 */
	public List<Element> findByVariablesId(Long variablesId);

	/**
	 * Find by reference: formulas
	 */
	public List<Element> findByFormulas(ElementFormula formulas);

	/**
	 * Find by ID of reference: formulas.id
	 */
	public List<Element> findByFormulasId(Long formulasId);
}
