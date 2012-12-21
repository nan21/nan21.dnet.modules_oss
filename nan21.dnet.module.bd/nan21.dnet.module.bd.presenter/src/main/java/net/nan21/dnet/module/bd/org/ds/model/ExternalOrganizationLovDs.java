/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.bd.org.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;

@Ds(entity = Organization.class, jpqlWhere = " e.type.external = true ", sort = {@SortField(field = ExternalOrganizationLovDs.f_code)})
public class ExternalOrganizationLovDs
		extends
			AbstractTypeWithCodeLov<Organization> {

	public static final String f_external = "external";

	@DsField(join = "left", path = "type.external")
	private Boolean external;

	public ExternalOrganizationLovDs() {
		super();
	}

	public ExternalOrganizationLovDs(Organization e) {
		super(e);
	}

	public Boolean getExternal() {
		return this.external;
	}

	public void setExternal(Boolean external) {
		this.external = external;
	}
}
