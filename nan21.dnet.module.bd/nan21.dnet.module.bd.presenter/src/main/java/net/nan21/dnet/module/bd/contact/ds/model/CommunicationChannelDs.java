/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.contact.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannel;
import net.nan21.dnet.module.bd.contact.domain.entity.CommunicationChannelType;

@Ds(entity = CommunicationChannel.class)
@RefLookups({@RefLookup(refId = CommunicationChannelDs.f_typeId, namedQuery = CommunicationChannelType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = CommunicationChannelDs.f_type)})})
public class CommunicationChannelDs
		extends
			AbstractAuditableDs<CommunicationChannel> {

	public static final String f_typeId = "typeId";
	public static final String f_type = "type";
	public static final String f_targetUuid = "targetUuid";
	public static final String f_targetType = "targetType";
	public static final String f_value = "value";
	public static final String f_validFrom = "validFrom";
	public static final String f_validTo = "validTo";

	@DsField(join = "left", path = "type.id")
	private Long typeId;

	@DsField(join = "left", path = "type.name")
	private String type;

	@DsField
	private String targetUuid;

	@DsField
	private String targetType;

	@DsField
	private String value;

	@DsField
	private Date validFrom;

	@DsField
	private Date validTo;

	public CommunicationChannelDs() {
		super();
	}

	public CommunicationChannelDs(CommunicationChannel e) {
		super(e);
	}

	public Long getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTargetUuid() {
		return this.targetUuid;
	}

	public void setTargetUuid(String targetUuid) {
		this.targetUuid = targetUuid;
	}

	public String getTargetType() {
		return this.targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
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
}
