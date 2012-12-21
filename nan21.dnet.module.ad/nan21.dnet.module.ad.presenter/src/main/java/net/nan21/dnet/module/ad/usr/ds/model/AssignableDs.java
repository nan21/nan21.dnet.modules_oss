/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.usr.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.ad.usr.domain.entity.AssignableType;

@Ds(entity = Assignable.class, sort = {@SortField(field = AssignableDs.f_name)})
@RefLookups({@RefLookup(refId = AssignableDs.f_typeId, namedQuery = AssignableType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = AssignableDs.f_type)})})
public class AssignableDs extends AbstractTypeDs<Assignable> {

	public static final String f_typeId = "typeId";
	public static final String f_type = "type";
	public static final String f_userCode = "userCode";

	@DsField(join = "left", path = "assignableType.id")
	private Long typeId;

	@DsField(join = "left", path = "assignableType.name")
	private String type;

	@DsField
	private String userCode;

	public AssignableDs() {
		super();
	}

	public AssignableDs(Assignable e) {
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

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
}
