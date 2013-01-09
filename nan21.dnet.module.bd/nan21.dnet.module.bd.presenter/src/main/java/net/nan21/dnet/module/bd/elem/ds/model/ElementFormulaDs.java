/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.elem.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.elem.domain.entity.Element;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementFormula;

@Ds(entity = ElementFormula.class, sort = {
		@SortField(field = ElementFormulaDs.f_engine),
		@SortField(field = ElementFormulaDs.f_sequenceNo),
		@SortField(field = ElementFormulaDs.f_validFrom, desc = true)})
@RefLookups({@RefLookup(refId = ElementFormulaDs.f_elementId, namedQuery = Element.NQ_FIND_BY_ENGINE_CODE_PRIMITIVE, params = {
		@Param(name = "pEngineId", field = ElementFormulaDs.f_engineId),
		@Param(name = "pCode", field = ElementFormulaDs.f_element)})})
public class ElementFormulaDs extends AbstractAuditableDs<ElementFormula> {

	public static final String f_elementId = "elementId";
	public static final String f_element = "element";
	public static final String f_elementName = "elementName";
	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_engineId = "engineId";
	public static final String f_engine = "engine";
	public static final String f_engineType = "engineType";
	public static final String f_validFrom = "validFrom";
	public static final String f_validTo = "validTo";
	public static final String f_staticValue = "staticValue";
	public static final String f_expression = "expression";

	@DsField(join = "left", path = "element.id")
	private Long elementId;

	@DsField(join = "left", path = "element.code")
	private String element;

	@DsField(join = "left", path = "element.name")
	private String elementName;

	@DsField(join = "left", path = "element.sequenceNo")
	private Integer sequenceNo;

	@DsField(join = "left", path = "element.engine.id")
	private Long engineId;

	@DsField(join = "left", path = "element.engine.name")
	private String engine;

	@DsField(join = "left", path = "element.engine.type")
	private String engineType;

	@DsField
	private Date validFrom;

	@DsField
	private Date validTo;

	@DsField
	private Boolean staticValue;

	@DsField
	private String expression;

	public ElementFormulaDs() {
		super();
	}

	public ElementFormulaDs(ElementFormula e) {
		super(e);
	}

	public Long getElementId() {
		return this.elementId;
	}

	public void setElementId(Long elementId) {
		this.elementId = elementId;
	}

	public String getElement() {
		return this.element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getElementName() {
		return this.elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
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

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Boolean getStaticValue() {
		return this.staticValue;
	}

	public void setStaticValue(Boolean staticValue) {
		this.staticValue = staticValue;
	}

	public String getExpression() {
		return this.expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}
}
