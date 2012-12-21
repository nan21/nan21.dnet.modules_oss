/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.job.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.hr.job.domain.entity.PositionRequirement;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

@Ds(entity = PositionRequirement.class)
@RefLookups({
		@RefLookup(refId = PositionRequirementDs.f_positionId),
		@RefLookup(refId = PositionRequirementDs.f_requirementId, namedQuery = WorkRequirement.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PositionRequirementDs.f_requirement)})})
public class PositionRequirementDs
		extends
			AbstractAuditableDs<PositionRequirement> {

	public static final String f_positionId = "positionId";
	public static final String f_requirementId = "requirementId";
	public static final String f_requirement = "requirement";
	public static final String f_notes = "notes";

	@DsField(join = "left", path = "position.id")
	private Long positionId;

	@DsField(join = "left", path = "requirement.id")
	private Long requirementId;

	@DsField(join = "left", path = "requirement.name")
	private String requirement;

	@DsField
	private String notes;

	public PositionRequirementDs() {
		super();
	}

	public PositionRequirementDs(PositionRequirement e) {
		super(e);
	}

	public Long getPositionId() {
		return this.positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public Long getRequirementId() {
		return this.requirementId;
	}

	public void setRequirementId(Long requirementId) {
		this.requirementId = requirementId;
	}

	public String getRequirement() {
		return this.requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
