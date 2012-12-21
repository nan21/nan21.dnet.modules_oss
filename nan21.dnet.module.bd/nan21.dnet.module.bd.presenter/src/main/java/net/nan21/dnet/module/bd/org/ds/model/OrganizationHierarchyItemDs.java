/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchy;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchyItem;

@Ds(entity = OrganizationHierarchyItem.class)
@RefLookups({
		@RefLookup(refId = OrganizationHierarchyItemDs.f_hierarchyId, namedQuery = OrganizationHierarchy.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = OrganizationHierarchyItemDs.f_hierarchy)}),
		@RefLookup(refId = OrganizationHierarchyItemDs.f_orgId, namedQuery = Organization.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = OrganizationHierarchyItemDs.f_org)}),
		@RefLookup(refId = OrganizationHierarchyItemDs.f_parentId, namedQuery = Organization.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = OrganizationHierarchyItemDs.f_parentCode)})})
public class OrganizationHierarchyItemDs
		extends
			AbstractAuditableDs<OrganizationHierarchyItem> {

	public static final String f_hierarchyId = "hierarchyId";
	public static final String f_hierarchy = "hierarchy";
	public static final String f_orgId = "orgId";
	public static final String f_org = "org";
	public static final String f_parentId = "parentId";
	public static final String f_parentCode = "parentCode";

	@DsField(join = "left", path = "hierarchy.id")
	private Long hierarchyId;

	@DsField(join = "left", path = "hierarchy.name")
	private String hierarchy;

	@DsField(join = "left", path = "org.id")
	private Long orgId;

	@DsField(join = "left", path = "org.code")
	private String org;

	@DsField(join = "left", path = "parent.id")
	private Long parentId;

	@DsField(join = "left", path = "parent.code")
	private String parentCode;

	public OrganizationHierarchyItemDs() {
		super();
	}

	public OrganizationHierarchyItemDs(OrganizationHierarchyItem e) {
		super(e);
	}

	public Long getHierarchyId() {
		return this.hierarchyId;
	}

	public void setHierarchyId(Long hierarchyId) {
		this.hierarchyId = hierarchyId;
	}

	public String getHierarchy() {
		return this.hierarchy;
	}

	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}

	public Long getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrg() {
		return this.org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentCode() {
		return this.parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
}
