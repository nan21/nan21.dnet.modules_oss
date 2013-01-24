/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.attr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSetAttribute;

@Ds(entity = AttributeSetAttribute.class)
@RefLookups({
		@RefLookup(refId = AttributeSetAttributeDs.f_setId, namedQuery = AttributeSet.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = AttributeSetAttributeDs.f_set)}),
		@RefLookup(refId = AttributeSetAttributeDs.f_attributeId, namedQuery = Attribute.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = AttributeSetAttributeDs.f_attribute)})})
public class AttributeSetAttributeDs
		extends
			AbstractAuditableDs<AttributeSetAttribute> {

	public static final String f_setId = "setId";
	public static final String f_set = "set";
	public static final String f_attributeId = "attributeId";
	public static final String f_attribute = "attribute";
	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_inDescription = "inDescription";

	@DsField(join = "left", path = "attributeSet.id")
	private Long setId;

	@DsField(join = "left", path = "attributeSet.name")
	private String set;

	@DsField(join = "left", path = "attribute.id")
	private Long attributeId;

	@DsField(join = "left", path = "attribute.name")
	private String attribute;

	@DsField
	private Integer sequenceNo;

	@DsField
	private Boolean inDescription;

	public AttributeSetAttributeDs() {
		super();
	}

	public AttributeSetAttributeDs(AttributeSetAttribute e) {
		super(e);
	}

	public Long getSetId() {
		return this.setId;
	}

	public void setSetId(Long setId) {
		this.setId = setId;
	}

	public String getSet() {
		return this.set;
	}

	public void setSet(String set) {
		this.set = set;
	}

	public Long getAttributeId() {
		return this.attributeId;
	}

	public void setAttributeId(Long attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttribute() {
		return this.attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public Boolean getInDescription() {
		return this.inDescription;
	}

	public void setInDescription(Boolean inDescription) {
		this.inDescription = inDescription;
	}
}
