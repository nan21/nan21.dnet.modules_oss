/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.time.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

@Ds(entity = AbsenceReason.class, sort = {@SortField(field = AbsenceReasonDs.f_name)})
@RefLookups({@RefLookup(refId = AbsenceReasonDs.f_typeId, namedQuery = AbsenceType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = AbsenceReasonDs.f_type)})})
public class AbsenceReasonDs extends AbstractTypeDs<AbsenceReason> {

	public static final String f_typeId = "typeId";
	public static final String f_type = "type";

	@DsField(join = "left", path = "type.id")
	private Long typeId;

	@DsField(join = "left", path = "type.name")
	private String type;

	public AbsenceReasonDs() {
		super();
	}

	public AbsenceReasonDs(AbsenceReason e) {
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
}
