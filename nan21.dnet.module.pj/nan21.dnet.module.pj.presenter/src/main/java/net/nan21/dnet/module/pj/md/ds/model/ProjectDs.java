/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;
import net.nan21.dnet.module.pj.md.domain.entity.Project;

@Ds(entity = Project.class, sort = {@SortField(field = ProjectDs.f_name)})
@RefLookups({
		@RefLookup(refId = ProjectDs.f_typeId, namedQuery = ProjectType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ProjectDs.f_type)}),
		@RefLookup(refId = ProjectDs.f_projectLeadId)})
public class ProjectDs extends AbstractTypeWithCodeDs<Project> {

	public static final String f_typeId = "typeId";
	public static final String f_type = "type";
	public static final String f_isPublic = "isPublic";
	public static final String f_projectLeadId = "projectLeadId";
	public static final String f_projectLead = "projectLead";

	@DsField(join = "left", path = "type.id")
	private Long typeId;

	@DsField(join = "left", path = "type.name")
	private String type;

	@DsField
	private Boolean isPublic;

	@DsField(join = "left", path = "projectLead.id")
	private Long projectLeadId;

	@DsField(join = "left", path = "projectLead.member.name")
	private String projectLead;

	public ProjectDs() {
		super();
	}

	public ProjectDs(Project e) {
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

	public Boolean getIsPublic() {
		return this.isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Long getProjectLeadId() {
		return this.projectLeadId;
	}

	public void setProjectLeadId(Long projectLeadId) {
		this.projectLeadId = projectLeadId;
	}

	public String getProjectLead() {
		return this.projectLead;
	}

	public void setProjectLead(String projectLead) {
		this.projectLead = projectLead;
	}
}
