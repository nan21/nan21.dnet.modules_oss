/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableLov;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationHierarchyItem;

@Ds(entity = OrganizationHierarchyItem.class)
public class OrganizationHierarchyItemLovDs
		extends
			AbstractAuditableLov<OrganizationHierarchyItem> {

	public static final String f_hierarchyId = "hierarchyId";
	public static final String f_orgId = "orgId";
	public static final String f_org = "org";

	@DsField(join = "left", path = "hierarchy.id")
	private Long hierarchyId;

	@DsField(join = "left", path = "org.id")
	private Long orgId;

	@DsField(join = "left", path = "org.code")
	private String org;

	public OrganizationHierarchyItemLovDs() {
		super();
	}

	public OrganizationHierarchyItemLovDs(OrganizationHierarchyItem e) {
		super(e);
	}

	public Long getHierarchyId() {
		return this.hierarchyId;
	}

	public void setHierarchyId(Long hierarchyId) {
		this.hierarchyId = hierarchyId;
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
}
