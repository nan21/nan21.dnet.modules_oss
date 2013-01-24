/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.elem.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementCategory;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

@Ds(entity = ElementCategory.class, sort = {@SortField(field = ElementCategoryDs.f_name)})
@RefLookups({@RefLookup(refId = ElementCategoryDs.f_engineId, namedQuery = Engine.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ElementCategoryDs.f_engine)})})
public class ElementCategoryDs extends AbstractTypeDs<ElementCategory> {

	public static final String f_engineId = "engineId";
	public static final String f_engine = "engine";
	public static final String f_engineType = "engineType";

	@DsField(join = "left", path = "engine.id")
	private Long engineId;

	@DsField(join = "left", path = "engine.name")
	private String engine;

	@DsField(join = "left", path = "engine.type")
	private String engineType;

	public ElementCategoryDs() {
		super();
	}

	public ElementCategoryDs(ElementCategory e) {
		super(e);
	}

	public Long getEngineId() {
		return this.engineId;
	}

	public void setEngineId(Long engineId) {
		this.engineId = engineId;
	}

	public String getEngine() {
		return this.engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getEngineType() {
		return this.engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
}
