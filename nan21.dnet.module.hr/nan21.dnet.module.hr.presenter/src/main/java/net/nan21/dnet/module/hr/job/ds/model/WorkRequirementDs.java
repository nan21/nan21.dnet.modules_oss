/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirementType;

@Ds(entity = WorkRequirement.class, sort = {@SortField(field = WorkRequirementDs.f_name)})
@RefLookups({@RefLookup(refId = WorkRequirementDs.f_typeId, namedQuery = WorkRequirementType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = WorkRequirementDs.f_type)})})
public class WorkRequirementDs extends AbstractTypeDs<WorkRequirement> {

	public static final String f_typeId = "typeId";
	public static final String f_type = "type";

	@DsField(join = "left", path = "type.id")
	private Long typeId;

	@DsField(join = "left", path = "type.name")
	private String type;

	public WorkRequirementDs() {
		super();
	}

	public WorkRequirementDs(WorkRequirement e) {
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
