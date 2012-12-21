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
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

@Ds(entity = ProjectMember.class)
@RefLookups({
		@RefLookup(refId = ProjectMemberDs.f_projectId, namedQuery = Project.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProjectMemberDs.f_project)}),
		@RefLookup(refId = ProjectMemberDs.f_roleId, namedQuery = ProjectRole.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ProjectMemberDs.f_role)}),
		@RefLookup(refId = ProjectMemberDs.f_memberId, namedQuery = Assignable.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ProjectMemberDs.f_member)})})
public class ProjectMemberDs extends AbstractAuditableDs<ProjectMember> {

	public static final String f_projectId = "projectId";
	public static final String f_project = "project";
	public static final String f_projectName = "projectName";
	public static final String f_roleId = "roleId";
	public static final String f_role = "role";
	public static final String f_memberId = "memberId";
	public static final String f_member = "member";

	@DsField(join = "left", path = "project.id")
	private Long projectId;

	@DsField(join = "left", path = "project.code")
	private String project;

	@DsField(join = "left", path = "project.name")
	private String projectName;

	@DsField(join = "left", path = "projectRole.id")
	private Long roleId;

	@DsField(join = "left", path = "projectRole.name")
	private String role;

	@DsField(join = "left", path = "member.id")
	private Long memberId;

	@DsField(join = "left", path = "member.name")
	private String member;

	public ProjectMemberDs() {
		super();
	}

	public ProjectMemberDs(ProjectMember e) {
		super(e);
	}

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMember() {
		return this.member;
	}

	public void setMember(String member) {
		this.member = member;
	}
}
