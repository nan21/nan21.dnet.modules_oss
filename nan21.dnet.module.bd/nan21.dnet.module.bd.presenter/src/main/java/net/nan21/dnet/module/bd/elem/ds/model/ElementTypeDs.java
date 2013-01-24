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
import net.nan21.dnet.module.bd.elem.domain.entity.ElementType;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;

@Ds(entity = ElementType.class, sort = {@SortField(field = ElementTypeDs.f_name)})
@RefLookups({
		@RefLookup(refId = ElementTypeDs.f_engineId, namedQuery = Engine.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ElementTypeDs.f_engine)}),
		@RefLookup(refId = ElementTypeDs.f_categoryId, namedQuery = ElementCategory.NQ_FIND_BY_ENGINE_NAME_PRIMITIVE, params = {
				@Param(name = "pEngineId", field = ElementTypeDs.f_engineId),
				@Param(name = "pName", field = ElementTypeDs.f_category)})})
public class ElementTypeDs extends AbstractTypeDs<ElementType> {

	public static final String f_engineId = "engineId";
	public static final String f_engine = "engine";
	public static final String f_engineType = "engineType";
	public static final String f_categoryId = "categoryId";
	public static final String f_category = "category";

	@DsField(join = "left", path = "engine.id")
	private Long engineId;

	@DsField(join = "left", path = "engine.name")
	private String engine;

	@DsField(join = "left", path = "engine.type")
	private String engineType;

	@DsField(join = "left", path = "category.id")
	private Long categoryId;

	@DsField(join = "left", path = "category.name")
	private String category;

	public ElementTypeDs() {
		super();
	}

	public ElementTypeDs(ElementType e) {
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

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
