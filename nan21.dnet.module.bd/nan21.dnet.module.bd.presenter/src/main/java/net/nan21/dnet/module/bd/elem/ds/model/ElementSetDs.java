/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
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
import net.nan21.dnet.module.bd.elem.domain.entity.ElementSet;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

@Ds(entity = ElementSet.class, sort = {@SortField(field = ElementSetDs.f_name)})
@RefLookups({@RefLookup(refId = ElementSetDs.f_engineId, namedQuery = Engine.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ElementSetDs.f_engine)})})
public class ElementSetDs extends AbstractTypeDs<ElementSet> {

	public static final String f_engineId = "engineId";
	public static final String f_engine = "engine";
	public static final String f_engineType = "engineType";

	@DsField(join = "left", path = "engine.id")
	private Long engineId;

	@DsField(join = "left", path = "engine.name")
	private String engine;

	@DsField(join = "left", path = "engine.type")
	private String engineType;

	public ElementSetDs() {
		super();
	}

	public ElementSetDs(ElementSet e) {
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
