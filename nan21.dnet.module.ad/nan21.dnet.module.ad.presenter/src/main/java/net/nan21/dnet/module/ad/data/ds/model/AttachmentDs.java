/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.data.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.ad.data.domain.entity.Attachment;
import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;

@Ds(entity = Attachment.class)
@RefLookups({@RefLookup(refId = AttachmentDs.f_typeId, namedQuery = AttachmentType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = AttachmentDs.f_type)})})
public class AttachmentDs extends AbstractAuditableDs<Attachment> {

	public static final String f_targetUuid = "targetUuid";
	public static final String f_targetType = "targetType";
	public static final String f_typeId = "typeId";
	public static final String f_type = "type";
	public static final String f_category = "category";
	public static final String f_baseUrl = "baseUrl";
	public static final String f_name = "name";
	public static final String f_location = "location";
	public static final String f_notes = "notes";
	public static final String f_url = "url";

	@DsField
	private String targetUuid;

	@DsField
	private String targetType;

	@DsField(join = "left", path = "type.id")
	private Long typeId;

	@DsField(join = "left", path = "type.name")
	private String type;

	@DsField(join = "left", path = "type.category")
	private String category;

	@DsField(join = "left", path = "type.baseUrl")
	private String baseUrl;

	@DsField
	private String name;

	@DsField
	private String location;

	@DsField
	private String notes;

	@DsField(fetch = false)
	private String url;

	public AttachmentDs() {
		super();
	}

	public AttachmentDs(Attachment e) {
		super(e);
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

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
